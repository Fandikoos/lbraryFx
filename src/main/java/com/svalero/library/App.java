package com.svalero.library;

import com.svalero.library.Controller.AppController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("Starting JavaFX Application");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Crear y mostrar el splash screen
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.showSplash(primaryStage, () -> {
            // Cargar la ventana principal después del splash screen
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaz.fxml"));
                loader.setController(new AppController());
                Scene scene = new Scene(loader.load());
                primaryStage.setScene(scene);
                primaryStage.setTitle("Library");
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}