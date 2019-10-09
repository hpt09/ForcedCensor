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


        public AlignController() {
            System.out.println();
            System.out.println();
            System.out.println("================ AlignController instantiated: " + this);

        }

        private File audioFile;
        private File lyricFile;


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


            FXMLLoader loader = new FXMLLoader(getClass().getResource("CensorScreen.fxml"));
            AnchorPane root = loader.load();

            Main.makeWindowMoveable(root);

            Main.getPrimaryStage().getScene().setRoot(root);


            // Insert Bash Code here

        }



//        public File getAudioFile() {
//            return audioFile;
//        }
//
//        public void setAudioFile(File audioFile) {
//            this.audioFile = audioFile;
//        }
//
//        public File getLyricFile() {
//            return lyricFile;
//        }
//
//        public void setLyricFile(File lyricFile) {
//            this.lyricFile = lyricFile;
//        }
    }




