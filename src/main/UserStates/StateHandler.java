package main.UserStates;


import javafx.event.Event;
import javafx.scene.control.Control;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by martin on 02/03/2017.
 */
public class StateHandler {

    List<Shape> shapes;
    State currentState;

    HashMap<String, State> stateMap = new HashMap<>();

    public StateHandler() {
        this.currentState = new Default();
        this.shapes = new ArrayList<>();

        stateMap.put("line", new DrawingShape(new Line()));
        stateMap.put("triangle",new DrawingShape(new Polygon()));
        stateMap.put("square",new DrawingShape(new Rectangle()));
        stateMap.put("circle",new DrawingShape(new Circle()));
    }

    public void updateState(Event event, String msg){
        switch (msg) {
            case "ADD_SHAPE":
                currentState = stateMap.get(((Control)event.getSource()).getId());
                break;
            case "PLACE_SHAPE":
                currentState = currentState.selectedShape(currentState.currentShape);
                break;
            default:
                System.out.println("got DEFAULT");
                break;
        }

    }
}
