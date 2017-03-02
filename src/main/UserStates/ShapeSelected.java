package main.UserStates;


import com.sun.javafx.geom.Shape;

import java.util.List;

/**
 * Created by martin on 02/03/2017.
 */
public class ShapeSelected extends State {

    @Override
    State selectedShape(Shape shape) {
        return this;
    }

    @Override
    State selectedShapes(List<Shape> shapes) {
        return new GroupSelected();
    }

    @Override
    State move(Shape shape) {
        return this;
    }

    @Override
    State resize(Shape shape) {
        return this;
    }

    @Override
    State changeThickness(Shape shape) {
        return this;
    }
}
