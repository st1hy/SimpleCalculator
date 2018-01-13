package com.github.st1hy.simplecalculator.control;

import com.github.st1hy.simplecalculator.inject.PerApp;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.mariuszgromada.math.mxparser.Expression;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

@PerApp
public class TextController implements Initializable, ChangeListener<String> {

    @FXML private TextField textField;

    private static final Pattern commaPattern = Pattern.compile(",");
    private static final Pattern doubleMultiplyPattern = Pattern.compile("**", Pattern.LITERAL);

    @Inject public TextController() {
    }

    @Override public void initialize(URL location, ResourceBundle resources) {
        textField.textProperty().addListener(this);
    }

    @Override public void changed(ObservableValue<? extends String> observable,
                                  String oldValue, String newValue) {
        newValue = commaPattern.matcher(newValue).replaceAll(".");
        newValue = doubleMultiplyPattern.matcher(newValue).replaceAll("^");
        replaceText(newValue);
    }

    public void clearText() {
        textField.clear();
    }

    public void addToText(String addToText) {
        textField.setText(textField.getText() + addToText);
    }

    public void compute() {
        double results = new Expression(textField.getText()).calculate();
        String strings = BigDecimal.valueOf(results).stripTrailingZeros().toPlainString();
        replaceText(strings);
    }

    private void replaceText(String strings) {
        textField.setText(strings);
        textField.selectRange(strings.length(), strings.length());
    }

    public void oneKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            compute();
        }
    }

    public void deleteLast() {
        String text = textField.getText();
        if (!text.isEmpty()) {
            text = text.substring(0, text.length() - 1);
        }
        replaceText(text);
    }
}
