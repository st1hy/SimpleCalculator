package com.github.st1hy.simplecalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ResourceBundle strings = ResourceBundle.getBundle("strings");
        URL main = getClass().getResource("main.fxml");
        Parent root = FXMLLoader.load(main, strings);
        primaryStage.setTitle(strings.getString("window.title"));
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
