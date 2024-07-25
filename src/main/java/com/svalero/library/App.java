package com.svalero.library;

import com.svalero.library.Controller.AppController;
import com.svalero.library.Model.Author;
import com.svalero.library.Service.LibraryService;
import io.reactivex.schedulers.Schedulers;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class App extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("Starting JavaFX Application");
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
        LibraryService libraryService = new LibraryService();

        libraryService.getAllAuthors()
                .subscribeOn(Schedulers.io())
                .subscribe(this::printAuthors, Throwable::printStackTrace);
        */

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

    // Comprobar que nos estamos coenctando correctamente a la api de una manera muy sencilla
    /*
    private void printAuthors(List<Author> authors){
        for (Author author : authors){
            System.out.println("Author: " + author.getName());
        }
    }*/

    public static void main(String[] args) {
        launch();
    }
}