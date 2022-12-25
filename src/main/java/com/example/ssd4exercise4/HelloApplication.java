package com.example.ssd4exercise4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage.setTitle("SSD4Exercise4");
        stage.setScene(scene);
        HelloController controller = fxmlLoader.getController();
        controller.init();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}