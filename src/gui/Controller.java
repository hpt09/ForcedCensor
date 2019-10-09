package gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Label audioFileName;

    @FXML
    private Label lyricFileName;


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
        File selectedFile;


        if (((Button) e.getSource()).getId().equals("audioUploadBtn")) {
            // Audio upload button
            fc.setTitle("Upload your Audio file");
            fc.getExtensionFilters().addAll(new ExtensionFilter("Audio files", "*.wav","*.mp3"));
            selectedFile = fc.showOpenDialog(null);

            if (selectedFile != null) {
                audioFileName.setText(selectedFile.getName());
            }

        } else {
            // Lyrics upload button
            fc.setTitle("Upload your Lyrics file");
            fc.getExtensionFilters().addAll(new ExtensionFilter("Lyric files", "*.txt"));
            selectedFile = fc.showOpenDialog(null);

            if (selectedFile != null) {
                lyricFileName.setText(selectedFile.getName());
            }
        }



    }
    
}


