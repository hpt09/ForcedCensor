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
    private Button playBtn;

    @FXML
    private Label audioFileName;

    @FXML
    private Label lyricFileName;

    private AlignController ac;

    public EndController() {
        System.out.println();
        System.out.println();
        System.out.println("================ EndController instantiated: " + this);
        ac = Main.getAlignController();

    }

    @FXML
    public void exit() {
        Platform.exit();
    }


    @FXML
    public void play() {

        if (ac.getAudioFile() == null) {
            audioFileName.setText("You didn't upload a song");
            playBtn.setDisable(true);
            return;
        }
        audioFileName.setText(ac.getAudioFile().getName());

        System.out.println("This controller: "+this);
        if (ac.getAudioFile() == null) {
            System.out.print("null");
        } else {
            System.out.println(ac.getAudioFile().getName());

        }

        String songPath="FILTERED-"+ac.getAudioFile().getName();
        File fileToPlay = new File(songPath);


        Media sound = new Media(fileToPlay.toURI().toString());
        //Media sound = new Media(ac.getAudioFile().toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        playBtn.setDisable(true);

    }

}


