package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Controller.Controller;

public class Main extends Application {
    Controller ctrl = new Controller();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("paint.fxml"));
        primaryStage.setTitle("Painter");
        primaryStage.setScene(new Scene(root, 800,484 ));
        primaryStage.show();
    }



}
