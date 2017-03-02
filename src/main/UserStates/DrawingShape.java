package main.UserStates;

import com.sun.javafx.geom.Shape;

import java.util.List;

/**
 * Created by martin on 02/03/2017.
 */
public class DrawingShape extends State {


    @Override
    State selectedShape(Shape shape) {
        return new GroupSelected();
    }

    @Override
    State selectedShapes(List<Shape> shapes) {
        return new ShapeSelected();
    }

}
