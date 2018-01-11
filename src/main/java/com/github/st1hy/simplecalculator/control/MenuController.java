package com.github.st1hy.simplecalculator.control;

import com.github.st1hy.simplecalculator.MainApp;
import com.github.st1hy.simplecalculator.inject.PerApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

@PerApp
public class MenuController implements Initializable {

    @Inject MainApp app;

    @Inject
    public MenuController() {
    }

    @FXML private MenuItem close;
    @FXML private AnchorPane menu;

    @Override public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void handleClose() {
        app.getStage().close();
    }
}
