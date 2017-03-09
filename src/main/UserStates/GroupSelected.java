package main.UserStates;


import java.util.List;
import javafx.scene.shape.Shape;

/**
 * Created by martin on 02/03/2017.
 */
public class GroupSelected extends State {
    @Override
    State selectedShape(Shape shape) {
        return new ShapeSelected();
    }

    @Override
    State selectedShapes(List<Shape> shapes) {
        return this;
    }

    @Override
    State move(Shape shape) {
        return this;
    }
}
