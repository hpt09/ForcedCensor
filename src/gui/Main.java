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


import java.io.IOException;

public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;
    private Parent root;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        root = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));

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
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });



        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("resources/main.css").toExternalForm());

        primaryStage.setTitle("Beep!");
        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("resources/logo.png")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


//    public void changeScene(BeepScene sceneToChangeTo) throws IOException {
//
//        root = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
//
//        // Code for making window moveable, can remove this if don't want undecorated stage style
//        root.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                xOffset = event.getSceneX();
//                yOffset = event.getSceneY();
//            }
//        });
//        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                primaryStage.setX(event.getScreenX() - xOffset);
//                primaryStage.setY(event.getScreenY() - yOffset);
//            }
//        });
//
//
//
//        Scene scene = new Scene(root);
//        //scene.getStylesheets().add(getClass().getResource("resources/main.css").toExternalForm());
//
//        primaryStage.setTitle("Beep!");
//        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("resources/logo.png")));
//        primaryStage.initStyle(StageStyle.UNDECORATED);
//        primaryStage.setResizable(false);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//
//    }




}
