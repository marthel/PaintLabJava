package main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {
    Controller ctrl = new Controller();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        // Stage är containern som kan innehålla scener
        Parent root = FXMLLoader.load(getClass().getResource("paint.fxml"));

        primaryStage.setTitle("Painter");
        // en scen skapas av fxml-filer

        primaryStage.setScene(new Scene(root, 800,484 ));

        // Det är själva scenen som är det synliga (viewen)
        primaryStage.show();
        //GraphicsContext gc = ;
    }



}
