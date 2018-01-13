package com.github.st1hy.simplecalculator.inject;

import com.github.st1hy.simplecalculator.MainApp;
import com.github.st1hy.simplecalculator.utils.UTF8Control;
import dagger.Module;
import dagger.Provides;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Module(includes = ControllersModule.class)
abstract class MainModule {

    @Provides @PerApp static ResourceBundle resourceBundle(UTF8Control control) {
        return ResourceBundle.getBundle("strings", control);
    }

    @Provides @PerApp static FXMLLoader provideMainFXMLLoader(ResourceBundle resourceBundle,
                                                              ControllerFactory controllerFactory) {
        return newFXMLLoader("main.fxml", resourceBundle, controllerFactory);
    }

    @Provides @About static FXMLLoader provideAboutFXMLLoader(ResourceBundle resourceBundle,
                                                              ControllerFactory controllerFactory) {
        return newFXMLLoader("about.fxml", resourceBundle, controllerFactory);
    }

    @Provides @PerApp static Scene provideMainScene(FXMLLoader fxmlLoader) {
        return new Scene(fxmlLoader.getRoot(), 300, 220);
    }

    @Provides @About static Scene provideAboutScene(@About FXMLLoader aboutLoader) {
        return new Scene(aboutLoader.getRoot());
    }

    private static FXMLLoader newFXMLLoader(String fxml,
                                            ResourceBundle resourceBundle,
                                            ControllerFactory controllerFactory) {
        URL main = MainApp.class.getResource(fxml);
        FXMLLoader fxmlLoader = new FXMLLoader(main, resourceBundle);
        fxmlLoader.setControllerFactory(controllerFactory);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fxmlLoader;
    }

}
