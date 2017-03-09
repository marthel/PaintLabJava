package main.UserStates;


import java.util.List;
import javafx.scene.shape.Shape;

/**
 * Created by martin on 02/03/2017.
 */
public class DrawingShape extends State {

    public DrawingShape(Shape currentShape) {
        super(currentShape);
    }

    @Override
    State selectedShape(Shape shape) {
        //place the shape
        return new ShapeSelected();
    }
}
