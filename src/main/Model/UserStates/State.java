package main.Model.UserStates;

import javafx.event.Event;
import main.Model.Shapes.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin on 10/03/2017.
 */
public abstract class State {
    Shape shape;
    List<Shape> shapes;

    public static final PanelRegion pr = new PanelRegion();

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public State(){
        shapes = new ArrayList<>();
    }
    public State(List<Shape> shapes, Shape shape){
        this.shape = shape;
        this.shapes = shapes;
    }

    public State receivedButtonAction() {return null;}
    public State receivedMouseClick(Event event) {return null;}
    public State receivedMouseDrag(Event event) {return null;}
    public State returnToDefault(){return new Default(shapes,shape);}
    public State filling(double r, double g, double b){return new Filling(shapes,shape,r,g,b);}
    public List<Shape> getShapesToDraw() {
        return shapes;
    }

}
