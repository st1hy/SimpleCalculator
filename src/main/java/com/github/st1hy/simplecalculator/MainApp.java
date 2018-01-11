package com.github.st1hy.simplecalculator;

import com.github.st1hy.simplecalculator.inject.DaggerMainComponent;
import com.github.st1hy.simplecalculator.inject.MainComponent;
import dagger.Lazy;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.util.ResourceBundle;

public class MainApp extends Application {

    private Stage stage;

    @Inject ResourceBundle strings;
    @Inject Lazy<Scene> mainScene;

    @Override public void init() throws Exception {
        super.init();
        MainComponent component = DaggerMainComponent.builder()
                .mainApp(this)
                .build();
        component.inject(this);
    }

    @Override public void start(Stage primaryStage) {
        this.stage = primaryStage;
        primaryStage.setTitle(strings.getString("window.title"));
        primaryStage.setScene(mainScene.get());
        primaryStage.show();
    }

    @Override public void stop() {
        this.stage = null;
    }

    public final Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
