package main.Model.UserStates;

import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import main.Model.Point;
import main.Model.Shapes.Shape;

import java.util.List;

/**
 * Created by martin on 10/03/2017.
 */
public class Drawing extends State {

    public Drawing(List<Shape> shapes, Shape shape) {
        super(shapes, shape);
    }

    @Override
    public State receivedButtonAction() {
        //change shape same state
        return this;
    }

    @Override
    public State receivedMouseClick(Event event) {
        //place shape change to selectedshape state
        double x = ((MouseEvent)event).getX();
        double y = ((MouseEvent)event).getY();
        shape.setPoint1(new Point(x,y));
        shape.setPoint2(new Point(x+50,y+50));
        shapes.add(shape);
        return new ShapeSelected(shapes,shape);
    }

    @Override
    public State receivedMouseDrag(Event event) {
        double x = ((MouseEvent)event).getX();
        double y = ((MouseEvent)event).getY();
        shape.setPoint1(new Point(x,y));
        shapes.add(shape);
        return new Resize(shapes,shape);
    }
}
