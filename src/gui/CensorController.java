package gui;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
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


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    private AlignController ac;


    public CensorController() {
        System.out.println();
        System.out.println();
        System.out.println("================ CensorController instantiated: " + this);
        ac = Main.getAlignController();


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

            String audioPath= ac.getAudioFile().getAbsolutePath();
            String audioName = ac.getAudioFile().getName();

            //System.out.println(audioFile.getName().split(".")[0]);
            String alignFilePath= "~/AlignmentFiles/"+ac.getAudioFile().getName().split(".mp3")[0]+"output.txt";

            String command = "cp "+audioPath+" . ; python filter.py "+audioName+" "+alignFilePath;

            BashTask task = new BashTask(command);

//            censorBtn.setDisable(true);
//                censorBtn.setText("Censoring..");

            task.setOnRunning((successesEvent) -> {

                censorBtn.setDisable(true);
                warningLabel.setText("Censoring... Please Wait");
                warningLabel.setVisible(true);
            });

            task.setOnSucceeded((succeededEvent) -> {

                warningLabel.setVisible(false);
                AnchorPane endRoot = Main.getRoots(BeepScene.EndScreen);
                Main.getPrimaryStage().getScene().setRoot(endRoot);
            });

            ExecutorService executorService
                    = Executors.newFixedThreadPool(1);
            executorService.execute(task);
            executorService.shutdown();



        } else {
            // Insert code to do python commands for trimming
            System.out.println("Insert Trimming commands");

            String audioPath= ac.getAudioFile().getAbsolutePath();
            String audioName = ac.getAudioFile().getName();


            //System.out.println(audioFile.getName().split(".")[0]);
            String alignFilePath= "~/AlignmentFiles/"+ac.getAudioFile().getName().split(".mp3")[0]+"output.txt";

            System.out.println(alignFilePath);

            //creates the command and executes it
            String command = "cp "+audioPath+" . ; ./censor.sh "+audioName+" "+alignFilePath;

            BashTask task = new BashTask(command);

//            censorBtn.setDisable(true);
//                censorBtn.setText("Censoring..");

            task.setOnRunning((successesEvent) -> {

                censorBtn.setDisable(true);
                warningLabel.setText("Censoring... Please Wait");
                warningLabel.setVisible(true);
            });

            task.setOnSucceeded((succeededEvent) -> {

                warningLabel.setVisible(false);
                AnchorPane endRoot = Main.getRoots(BeepScene.EndScreen);
                Main.getPrimaryStage().getScene().setRoot(endRoot);
            });

            ExecutorService executorService
                    = Executors.newFixedThreadPool(1);
            executorService.execute(task);
            executorService.shutdown();

        }

    }

    public String getCensoringMethod() {
        return censoringMethod;
    }
}


