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

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;


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
        private Label warningLabel;




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
                fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Audio files", "*.wav","*.mp3"));
                audioFile = (fc.showOpenDialog(null));

                if (audioFile != null) {
                    audioFileName.setText(audioFile.getName());
                }

            }

            if (((Button) e.getSource()).getId().equals("lyricUploadBtn")){
                // Lyrics upload button
                fc.setTitle("Upload your Lyrics file");
                fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Lyric files", "*.txt"));
                lyricFile = (fc.showOpenDialog(null));

                if (lyricFile != null) {
                    lyricFileName.setText(lyricFile.getName());
                }
            }
        }

        @FXML
        public void handleAlign() throws IOException {


            AnchorPane censorRoot = Main.getRoots(BeepScene.CensorScreen);
            Main.getPrimaryStage().getScene().setRoot(censorRoot);


            // Insert Bash Code here

        }

        public File getAudioFile() {
            return audioFile;
        }

        public File getLyricFile() {
            return lyricFile;
        }
    }




