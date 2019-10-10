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
    private Button saveBtn;

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
    public void save() {

        if (ac.getAudioFile() == null) {
            audioFileName.setText("You didn't upload a song");
            saveBtn.setDisable(true);
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

        //String musicFile = "filtered-"+ac.getAudioFile().getName();
        String musicFile = "filtered-lucier.mp3";

        File file = new File(musicFile);
        System.out.println("Parent: "+file.getParent());
        System.out.println(file.toURI().toString());
        System.out.println("Last modified: " +file.lastModified());
        System.out.println("file length: " + file.length());
        Media hit = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
        System.out.println(mediaPlayer.getCurrentTime());
        System.out.println(mediaPlayer.getTotalDuration().toSeconds());

       // File file = new File(musicFile);
       // System.out.println("Reading file: " + musicFile+ " with length: " + file.length());
        //InputStream is = new FileInputStream(file);


        FileChooser fc = new FileChooser();
        fc.setTitle("Save your censored song");
        //fc.showSaveDialog();
//        System.out.println(musicFile);
//        File file = new File(musicFile);
//        System.out.println(file.toURI().toString());


//        playBtn.setDisable(true);

    }



    public void setAudioFileName(String name) {
        audioFileName.setText(name);
    }

    public void setCensoringMethod(String censoringMethod) {
        this.censoringMethod = censoringMethod;
    }
}


