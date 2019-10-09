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

public class CensorController {



    @FXML
    private Button exitBtn;

    @FXML
    private Button censorBtn;

    @FXML
    private ToggleGroup censorButtons;



    @FXML
    private Label warningLabel;

    private String censoringMethod;


    public void setAudioFile(File audioFile) {
        this.audioFile = audioFile;
    }
    public void setLyricFile(File lyricFile) {
        this.lyricFile = lyricFile;
    }

    private File audioFile;
    private File lyricFile;


    public CensorController() {
        System.out.println();
        System.out.println();
        System.out.println("================ CensorController instantiated: " + this);


    }


    @FXML
    public void exit() {
        Platform.exit();
    }


    @FXML
    public void handleCensor() throws IOException {


        // Get selected toggle
        if (censorButtons.getSelectedToggle() != null) {
            censoringMethod = ((ToggleButton)censorButtons.getSelectedToggle()).getText();
        } else {
            censoringMethod = null;
        }
        // Warn user to select an option
        if (censoringMethod == null) {
            warningLabel.setVisible(true);
            return;
        } else {
            warningLabel.setVisible(false);
        }


        if (censoringMethod.equals("Filtering")) {
            // Insert code to do python commands for filtering
            System.out.println("Insert Filtering commands");

        } else {
            // Insert code to do python commands for trimming
            System.out.println("Insert Trimming commands");

        }

        AnchorPane endRoot = Main.getRoots(BeepScene.EndScreen);
        Main.getPrimaryStage().getScene().setRoot(endRoot);


    }



}


