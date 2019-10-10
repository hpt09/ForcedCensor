package gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;


import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main extends Application {

    private static Parent splashRoot;
    private static Parent alignRoot;
    private static Parent censorRoot;
    private static Parent endRoot;
    private static Stage _primaryStage;

    private static double xOffset = 0;
    private static double yOffset = 0;



    //private SplashController splashController;
    private static AlignController alignController;
    private static CensorController censorController;
    private static EndController endController;

    private static SplashController _controller;

    private File audioFile;
    private File lyricFile;

    public static void main(String[] args) {
        launch(args);
    }

    public static AnchorPane getRoots(BeepScene alignScreen) {

        switch (alignScreen) {
            case AlignScreen:
                return (AnchorPane) alignRoot;
            case CensorScreen:
                return (AnchorPane) censorRoot;
            case EndScreen:
                return (AnchorPane) endRoot;
             default:
                 return null;
        }

    }


    @Override
    public void start(Stage primaryStage) throws IOException {

        _primaryStage = primaryStage;

        System.out.println(System.getProperty("os.name"));
        System.out.println(Screen.getPrimary().getDpi());

        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(resolution.getWidth());
        System.out.println(resolution.getHeight());

        double height = resolution.getWidth();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("SplashScreen.fxml"));
        splashRoot = loader.load();

        splashRoot.getTransforms().add(new Scale(1, 1080/925,0,0));
        _controller = loader.getController();


        makeWindowMoveable(splashRoot);

        Scene scene = new Scene(splashRoot);
        //scene.getStylesheets().add(getClass().getResource("resources/main.css").toExternalForm());

        primaryStage.setTitle("Beep!");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("resources/logo.png")));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);


        loadFXMLS();

    }


    public void loadFXMLS() throws IOException{

        FXMLLoader alignLoader = new FXMLLoader(getClass().getResource("AlignScreen.fxml"));
        alignRoot = alignLoader.load();
        makeWindowMoveable(alignRoot);

        alignController = alignLoader.getController();

        FXMLLoader censorLoader = new FXMLLoader(getClass().getResource("CensorScreen.fxml"));
        censorRoot = censorLoader.load();
        makeWindowMoveable(censorRoot);

        censorController = censorLoader.getController();

        FXMLLoader endLoader = new FXMLLoader(getClass().getResource("EndScreen.fxml"));
        endRoot = endLoader.load();
        makeWindowMoveable(endRoot);

        endController = endLoader.getController();

    }


    public static Stage getPrimaryStage() {
        return _primaryStage;
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


    public static AlignController getAlignController() {
        return alignController;
    }

    public static CensorController getCensorController() {
        return censorController;
    }

    public static EndController getEndController() {
        return endController;
    }
}





