package main.Model;


import javafx.event.Event;
import javafx.scene.control.Control;
import main.Model.ShapeFactory;
import main.Model.Shapes.Circle;
import main.Model.Shapes.Line;
import main.Model.Shapes.Rectangle;
import main.Model.Shapes.Shape;
import main.Model.UserStates.Default;
import main.Model.UserStates.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by martin on 02/03/2017.
 */
public class StateHandler {

    State currentState;
    ShapeFactory shapeFactory;

    public StateHandler() {
        this.shapeFactory = new ShapeFactory();
        this.currentState = new Default();
    }



    public void updateState(Event event){
        System.out.println(event.getEventType().toString());
        switch (event.getEventType().toString()) {
            case "ACTION":
                currentState.setShape(shapeFactory.getShape(((Control)event.getSource()).getId()));
                currentState = currentState.receivedButtonAction();
                break;
            case "MOUSE_DRAGGED":
                currentState = currentState.receivedMouseDrag(event);
                break;
            case "MOUSE_CLICKED":
                currentState = currentState.receivedMouseClick(event);
                break;
            default:
                System.out.println("DEFAULT");
                break;
        }

    }

    public List<Shape> getShapesToDraw(){
        return currentState.getShapesToDraw();
    }
}