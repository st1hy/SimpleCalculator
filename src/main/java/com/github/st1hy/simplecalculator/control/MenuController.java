package com.github.st1hy.simplecalculator.control;

import com.github.st1hy.simplecalculator.MainApp;
import com.github.st1hy.simplecalculator.inject.About;
import com.github.st1hy.simplecalculator.inject.PerApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.inject.Inject;
import javax.inject.Provider;
import java.net.URL;
import java.util.ResourceBundle;

@PerApp
public class MenuController implements Initializable {

    @Inject MainApp app;
    @Inject TextController textController;

    @Inject @About Provider<Scene> aboutProvider;

    @Inject
    public MenuController() {
    }

    @FXML private MenuItem close;
    @FXML private AnchorPane menu;

    @Override public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML private void handleClose(ActionEvent actionEvent) {
        app.getStage().close();
    }

    @FXML private void handleDelete() {
        textController.clearText();
    }

    @FXML private void handleAbout() {
        Stage dialog = new Stage();
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setScene(aboutProvider.get());
        dialog.setResizable(false);
        dialog.show();
    }
}