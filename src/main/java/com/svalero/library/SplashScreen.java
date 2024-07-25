package com.svalero.library;

import javafx.animation.FadeTransition;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class SplashScreen extends Stage {

    public SplashScreen(){
        StackPane root = new StackPane();
        ImageView splashImage = new ImageView(new Image(getClass().getResourceAsStream("splash.png")));
        root.getChildren().add(splashImage);

        Scene scene = new Scene(root, 600, 400);
        this.setScene(scene);
        this.initStyle(StageStyle.UNDECORATED);
    }

    public void showSplash(Stage primaryStage, Runnable onFinish){
        this.show();
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(4), this.getScene().getRoot());
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);
        fadeOut.setOnFinished(event -> {
            this.hide();
            onFinish.run();
        });
        fadeOut.play();
    }
}
