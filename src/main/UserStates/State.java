package main.UserStates;

import com.sun.javafx.geom.Shape;

import java.util.List;

/**
 * Created by martin on 02/03/2017.
 */
public abstract class State {

    State move(Shape shape){return new Default();}
    State resize(Shape shape){return new Default();}
    State changeThickness(Shape shape){return new Default();}

    State drawShape(Shape shape){
        //draw the shape

     return new ShapeSelected();
    }
    abstract State selectedShape(Shape shape);
    abstract State selectedShapes(List<Shape> shapes);
}
