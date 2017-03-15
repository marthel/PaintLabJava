package main.Model.UserStates;

import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import main.Model.Point;
import main.Model.Shapes.Shape;

import java.util.List;

/**
 * Created by martin on 10/03/2017.
 */
public class Resize extends State {


    public Resize(List<Shape> shapes, Shape shape) {
        super(shapes, shape);
    }

    public State receivedMouseClick(Event event) {
        return new ShapeSelected(shapes,shape);
    }

    @Override
    public State receivedMouseDrag(Event event) {
        //resize shape then change to selected shape state
        double x = ((MouseEvent)event).getX();
        double y = ((MouseEvent)event).getY();
        shape.setPoint2(new Point(x,y));
        return this;
    }
}
