package com.github.st1hy.simplecalculator.control;

import com.github.st1hy.simplecalculator.inject.PerApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javax.inject.Inject;
import java.util.regex.Pattern;

@PerApp
public class KeypadController {

    private static final Pattern buttonPattern = Pattern.compile("button");

    @Inject TextController textController;

    @Inject public KeypadController() {
    }

    @FXML private void handleButtonPress(ActionEvent actionEvent) {
        Button source = (Button) actionEvent.getSource();
        String id = source.getId();
        if (id != null && id.startsWith("button")) {
            String symbol = buttonPattern.matcher(id).replaceFirst("");
            String addToText = null;
            switch (symbol) {
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                    addToText = symbol;
                    break;
                case "Dot":
                    addToText = ".";
                    break;
                case "Percent":
                    addToText = "%";
                    break;
                case "Divide":
                    addToText = "/";
                    break;
                case "Multiply":
                    addToText = "*";
                    break;
                case "Minus":
                    addToText = "-";
                    break;
                case "Plus":
                    addToText = "+";
                    break;
                case "Equals":
                    textController.compute();
                    break;
                case "Delete":
                    textController.deleteLast();
                    break;
                case "Clear":
                    textController.clearText();
                    break;
            }
            if (addToText != null) {
                textController.addToText(addToText);
            }
        }
    }
}
