package main.Model.UserStates;

import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import main.Model.Point;
import main.Model.Shapes.Shape;

import java.util.List;

/**
 * Created by martin on 10/03/2017.
 */
public class Moving extends State  {

    public Moving(List<Shape> shapes, Shape shape) {
        super(shapes, shape);
    }

    @Override
    public State receivedMouseClick(Event event) {
        //change to selectedShape same shape
        return new ShapeSelected(shapes, shape);
    }

    @Override
    public State receivedMouseDrag(Event event) {
        //move shape
        double x = ((MouseEvent)event).getX();
        double y = ((MouseEvent)event).getY();
        shape.move(x,y);

        //shape.setPoint2(new Point());
        return this;
    }
}
