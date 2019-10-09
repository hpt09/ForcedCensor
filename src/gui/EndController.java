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

import static javafx.fxml.FXMLLoader.load;

public class EndController {


    @FXML
    private Button exitBtn;



    @FXML
    private Label audioFileName;

    @FXML
    private Label lyricFileName;

    private File audioFile;
    private File lyricFile;

    public EndController() {
        System.out.println();
        System.out.println();
        System.out.println("================ EndController instantiated: " + this);

    }

    @FXML
    public void exit() {
        Platform.exit();
    }


    @FXML
    public void play() {

        System.out.println("This controller: "+this);
        if (getAudioFile() == null) {
            System.out.print("null");
        } else {
            System.out.println(getAudioFile().getName());

        }

//        System.out.println(getAudioFile().toURI().toString());
//        Media sound = new Media(getAudioFile().toURI().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();
    }






    public File getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(File audioFile) {
        this.audioFile = audioFile;
    }

    public File getLyricFile() {
        return lyricFile;
    }

    public void setLyricFile(File lyricFile) {
        this.lyricFile = lyricFile;
    }


}


