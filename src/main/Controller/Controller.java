package main.Controller;

import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import main.Model.Shapes.Shape;
import main.Model.StateHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    boolean updateShapes;
    StateHandler stateHandler;
    GraphicsContext gc;

    public Controller() {
    }

    @FXML
    Canvas canvas;

    @FXML
    TextField saveFileName;
    @FXML
    TextField loadFileName;

    @FXML
    TextField red;
    @FXML
    TextField green;
    @FXML
    TextField blue;

    @FXML
    public void fillShape(){
        stateHandler.setCurrentColour(red.getText(),green.getText(),blue.getText());
    }

    @FXML
    public void addShape(Event event){
        stateHandler.updateState(event);
    }

    @FXML
    public void saveFile(Event event){
        stateHandler.saveFile(saveFileName.getText());
    }

    @FXML
    public void loadFile(Event event){
        stateHandler.loadFile(loadFileName.getText());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stateHandler = new StateHandler();
        gc = canvas.getGraphicsContext2D();
        updateShapes = false;
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stateHandler.updateState(event);
            }
        });
        canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stateHandler.updateState(event);
            }
        });
        new DrawTimer().start();
    }

    protected class DrawTimer extends AnimationTimer {

        @Override
        public void handle(long now) {
            gc.setFill(Color.WHITE);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
            for (Shape shape : stateHandler.getShapesToDraw()) {
                shape.draw(gc);
            }
        }
    }
}
