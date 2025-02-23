package gui;




import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AlignController {



        @FXML
        private Button exitBtn;

        @FXML
        private Button audioUploadBtn;

        @FXML
        private Button lyricUploadBtn;


        @FXML
        private Label audioFileName;

        @FXML
        private Label lyricFileName;

        @FXML
        private Label alignWarningLabel;

        @FXML
        private Button alignBtn;



        private File audioFile;
        private File lyricFile;

        public AlignController() {
            System.out.println();
            System.out.println();
            System.out.println("================ AlignController instantiated: " + this);

        }



        @FXML
        public void exit() {
            Platform.exit();
        }


        @FXML
        public void handleUpload(ActionEvent e) {
            FileChooser fc = new FileChooser();

            System.out.println("The upload functionality is on controller:"+this);

            if (((Button) e.getSource()).getId().equals("audioUploadBtn")) {
                // Audio upload button
                fc.setTitle("Upload your Audio file");
                fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Audio files", "*.mp3"));
                audioFile = (fc.showOpenDialog(null));

                if (audioFile != null) {
                    audioFileName.setText(audioFile.getName());
                } else {
                    return;
                }

            }

            if (((Button) e.getSource()).getId().equals("lyricUploadBtn")){
                // Lyrics upload button
                fc.setTitle("Upload your Lyrics file");
                fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Lyric files", "*.txt"));
                lyricFile = (fc.showOpenDialog(null));

                if (lyricFile != null) {
                    lyricFileName.setText(lyricFile.getName());
                } else {
                    return;
                }
            }
            System.out.println(lyricFileName + "   " +audioFile.getName());
        }

        @FXML
        public void handleAlign() throws IOException {

            if (audioFile == null || lyricFile == null) {
                alignWarningLabel.setVisible(true);
                return;
            } else {
                alignWarningLabel.setVisible(false);
            }


            // Insert Bash Code here

            String audioPath= audioFile.getAbsolutePath();
            String lyricPath= lyricFile.getAbsolutePath();


            //System.out.println(audioFile.getName().split(".")[0]);
            String alignFilePath= "~/AlignmentFiles/"+audioFile.getName().split(".mp3")[0]+"output.txt";

            System.out.println(alignFilePath);

            //creates the command and executes it
            String command = "if [ ! -f "+alignFilePath+" ]; then python ~/canetis/align.py "+audioPath+" "+lyricPath+" "+alignFilePath+" ; fi";


            BashTask task = new BashTask(command);


            task.setOnRunning((succeesesEvent) -> {

                alignBtn.setDisable(true);
                alignWarningLabel.setText("Aligning...Please Wait");
                alignWarningLabel.setVisible(true);
            });

            task.setOnSucceeded((succeededEvent) -> {

                alignWarningLabel.setVisible(false);
                AnchorPane censorRoot = Main.getRoots(BeepScene.CensorScreen);
                Main.getPrimaryStage().getScene().setRoot(censorRoot);
            });

            ExecutorService executorService
                    = Executors.newFixedThreadPool(1);
            executorService.execute(task);
            executorService.shutdown();


        }

        public File getAudioFile() {
            return audioFile;
        }

        public File getLyricFile() {
            return lyricFile;
        }
    }




