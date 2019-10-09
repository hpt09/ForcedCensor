package gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import javafx.event.ActionEvent;


import java.io.File;
import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class Controller {

    Main window = new Main();

    @FXML
    private Button startBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button audioUploadBtn;

    @FXML
    private Button lyricUploadBtn;

    @FXML
    private Button censorBtn;

    @FXML
    private ToggleGroup censorButtons;


    @FXML
    private Label audioFileName;

    @FXML
    private Label lyricFileName;

    @FXML
    private Label warningLabel;

    private String censoringMethod;
    private File audioFile;
    private File lyricFile;


    @FXML
    public void exit() {
        Platform.exit();
    }

    @FXML
    public void start() throws IOException {

        AnchorPane root = FXMLLoader.load(getClass().getResource("AlignScreen.fxml"));
        Main.makeWindowMoveable(root);
        Main.getPrimaryStage().getScene().setRoot(root);

    }


    @FXML
    public void handleUpload(ActionEvent e) {
        FileChooser fc = new FileChooser();

        File lyricFile;


        if (((Button) e.getSource()).getId().equals("audioUploadBtn")) {
            // Audio upload button
            fc.setTitle("Upload your Audio file");
            fc.getExtensionFilters().addAll(new ExtensionFilter("Audio files", "*.wav","*.mp3"));
            audioFile = fc.showOpenDialog(null);

            if (audioFile != null) {
                audioFileName.setText(audioFile.getName());
            }

        } else {
            // Lyrics upload button
            fc.setTitle("Upload your Lyrics file");
            fc.getExtensionFilters().addAll(new ExtensionFilter("Lyric files", "*.txt"));
            lyricFile = fc.showOpenDialog(null);

            if (lyricFile != null) {
                lyricFileName.setText(lyricFile.getName());
            }
        }
    }

    @FXML
    public void handleAlign() throws IOException {

        AnchorPane root = FXMLLoader.load(getClass().getResource("CensorScreen.fxml"));
        Main.makeWindowMoveable(root);
        Main.getPrimaryStage().getScene().setRoot(root);

        // Insert Bash Code here

    }

    @FXML
    public void handleCensor() {
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
            System.out.println("Insert Filtering commands");

        }


    }

}


