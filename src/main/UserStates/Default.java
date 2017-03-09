package main.UserStates;



import java.util.List;
import javafx.scene.shape.Shape;

/**
 * Created by martin on 02/03/2017.
 */
public class Default extends State {

    @Override
    State drawShape(Shape shape) {
        return new DrawingShape();
    }

    @Override
    State selectedShape(Shape shape) {
        return new GroupSelected();
    }

    @Override
    State selectedShapes(List<Shape> shapes) {
        return new ShapeSelected();
    }
}
