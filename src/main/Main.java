package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import main.Controller.Controller;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("paint.fxml"));
        primaryStage.setTitle("Painter");
        Scene scene = new Scene(root, 800,484 );
        primaryStage.setScene(scene);
        primaryStage.show();


       /* scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            System.out.println(key.getEventType().toString());
            if(key.getCode()== KeyCode.R) {
                this.ctrl.stateHandler.updateState(key);
                System.out.println("You pressed R");
            }else if (key.getCode()== KeyCode.U){
                System.out.println("You pressed U");
            }
        });*/
    }



}
