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

public class EndController{


    @FXML
    private Button exitBtn;

    @FXML
    private Button playBtn;

    @FXML
    private Label audioFileName;



    private AlignController ac;
    private String censoringMethod;

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
        } else {
            System.out.println(ac.getAudioFile().getName());
        }



//        FileChooser fc = new FileChooser();
//        File testFile = fc.showOpenDialog(null);
//        System.out.println(testFile.toURI().toString());
        //  file:/home/shane/ForcedCensor/FILTERED-lucier.mp3

//        String songPath= "~/ForcedCensor/FILTERED-" + ac.getAudioFile().getName();
        //System.out.println("Song path is: " +songPath);

//        File fileToPlay = new File(songPath);
//        audioFileName.setText(fileToPlay.getName());

        //System.out.println("file:~/ForcedCensor/FILTERED-" + ac.getAudioFile().getName());
        //System.out.println(ac.getAudioFile().toURI().toString());

//        System.out.println("attempting to play: "+"file:~/ForcedCensor/FILTERED-" + ac.getAudioFile().getName());

//        String musicFile = "FILTERED-"+ac.getAudioFile().getName();
//        System.out.println(musicFile);
//        File file = new File(musicFile);
//        System.out.println(file.toURI().toString());
//        Media sound = new Media(file.toURI().toString());
        //Media sound = new Media("file:/home/shane/ForcedCensor/censored-drake-back-to-back.mp3");

//        Media sound = new Media(fileToPlay.toURI().toString());
//        Media sound = new Media("file:/home/shane/ForcedCensor/FILTERED-" + ac.getAudioFile().getName());

//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.play();
//        playBtn.setDisable(true);

    }



    public void setAudioFileName(String name) {
        audioFileName.setText(name);
    }

    public void setCensoringMethod(String censoringMethod) {
        this.censoringMethod = censoringMethod;
    }
}


