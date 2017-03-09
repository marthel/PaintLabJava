package main;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Control;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Line;
import main.UserStates.StateHandler;

import javafx.scene.shape.Shape;

import java.awt.event.InputEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    StateHandler stateHandler;

    @FXML
    AnchorPane canvas;

    @FXML
    public void addShape(Event event){
        stateHandler.updateState(event, "ADD_SHAPE");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stateHandler = new StateHandler();
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(" X " + event.getX() + " Y " + event.getY());
            }
        });

    }
}
