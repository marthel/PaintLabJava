package main.UserStates;

import java.util.List;
import javafx.scene.shape.Shape;

/**
 * Created by martin on 02/03/2017.
 */
public abstract class State {


    Shape currentShape;

    public State(Shape currentShape) {
        this.currentShape = currentShape;
    }

    State move(Shape shape){return new Default();}
    State resize(Shape shape){return new Default();}
    State changeThickness(Shape shape){return new Default();}


    State drawShape(Shape shape){return new Default();}
    State selectedShape(Shape shape) { return new Default(); }
    State selectedShapes(List<Shape> shapes) { return new Default();}


}
