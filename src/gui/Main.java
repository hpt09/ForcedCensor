package gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;


import java.io.File;
import java.io.IOException;

public class Main extends Application {

    private Parent root;
    private static Stage _primaryStage;

    private static double xOffset = 0;
    private static double yOffset = 0;


    private static SplashController _controller;

    private File audioFile;
    private File lyricFile;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {

        _primaryStage = primaryStage;



        FXMLLoader loader = new FXMLLoader(getClass().getResource("SplashScreen.fxml"));
        root = loader.load();
        _controller = loader.getController();


        makeWindowMoveable(root);

        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("resources/main.css").toExternalForm());

        primaryStage.setTitle("Beep!");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("resources/logo.png")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Parent makeWindowMoveable(Parent root) {

        // Code for making window moveable, can remove this if don't want undecorated stage style
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                _primaryStage.setX(event.getScreenX() - xOffset);
                _primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        return root;
    }

    public static Stage getPrimaryStage() {
        return _primaryStage;
    }

}





