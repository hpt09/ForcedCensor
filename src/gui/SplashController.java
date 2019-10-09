package gui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SplashController {


    @FXML
    private Button startBtn;

    @FXML
    private Button exitBtn;



    public SplashController() {
        System.out.println();
        System.out.println();
        System.out.println("================ SplashController instantiated: " + this);

    }


    @FXML
    public void exit() {
        Platform.exit();
    }

    @FXML
    public void handleStart() throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("AlignScreen.fxml"));
        AnchorPane root = loader.load();
        System.out.println("Align screen controller was: " +loader.getController().toString());
        //loader.setController(Main.getController());
        //System.out.println("Align screen controller is now: " +loader.getController().toString());
        Main.makeWindowMoveable(root);

        Main.getPrimaryStage().getScene().setRoot(root);
    }


}


