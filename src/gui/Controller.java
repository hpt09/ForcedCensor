package gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class Controller {

    @FXML
    private Button startBtn;

    @FXML
    private Button exitBtn;


    @FXML
    public void exit() {
        Platform.exit();
    }

    @FXML
    public void start() throws IOException {

        AnchorPane root = FXMLLoader.load(getClass().getResource("AlignScreen.fxml"));
        startBtn.getScene().setRoot(root);
    }
}


