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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class EndController{


    @FXML
    private Button exitBtn;

    @FXML
    private Button playBtn;

    @FXML
    private Button stopBtn;

    @FXML
    private Label audioFileName;

    private MediaPlayer mediaPlayer;

    private AlignController ac;
    private CensorController cc;

    public EndController() {
        System.out.println();
        System.out.println();
        System.out.println("================ EndController instantiated: " + this);
        ac = Main.getAlignController();
        cc = Main.getCensorController();

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
        } else {
            System.out.println(ac.getAudioFile().getName());
        }

        String censoringMethod = cc.getCensoringMethod();
        String musicFile = null;
        if (censoringMethod.equals("Filtering")) {
            musicFile = "filtered-"+ac.getAudioFile().getName();
        }
        if (censoringMethod.equals("Trimming")) {
            musicFile = "trimmed-"+ac.getAudioFile().getName();
        }

        Media song = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(song);
        mediaPlayer.play();


        playBtn.setDisable(true);
        stopBtn.setDisable(false);

    }

    @FXML
    public void stop() {
        mediaPlayer.stop();
        playBtn.setDisable(false);
        stopBtn.setDisable(true);

    }



    public void setAudioFileName(String name) {
        audioFileName.setText(name);
    }


}


