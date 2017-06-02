package main.Model.UserStates;

import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import main.Model.Point;
import main.Model.Shapes.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin on 15/03/2017.
 */
public class MovingGroup extends State{

    List<Shape> selectedShapes;
    Point startPoint;

    public MovingGroup(List<Shape> shapes, Shape shape,List<Shape> selectedShapes) {
        super(shapes, shape);
        this.selectedShapes = selectedShapes;
        startPoint = null;
    }
    @Override
    public State receivedMouseClick(Event event) {

        double x = ((MouseEvent)event).getX();
        double y = ((MouseEvent)event).getY();
        Point endPoint = new Point(x, y);
        double dx = endPoint.getX() - startPoint.getX();
        double dy = endPoint.getY() - startPoint.getY();

        for (Shape s: selectedShapes) {
            double shapeRatioX = Math.abs(s.getPoint1().getX() - s.getPoint2().getX());
            double shapeRatioY = Math.abs(s.getPoint1().getY() - s.getPoint2().getY());
            s.getPoint1().setX(s.getPoint1().getX()+dx);
            s.getPoint1().setY(s.getPoint1().getY()+dy);
            s.getPoint2().setX(s.getPoint1().getX() + shapeRatioX);
            s.getPoint2().setY(s.getPoint1().getY() + shapeRatioY);
        }

        return new Default(shapes, null);
    }

    @Override
    public State receivedMouseDrag(Event event) {
        startPoint = startPoint == null ? new Point(((MouseEvent)event).getX(),((MouseEvent)event).getY()) : startPoint;
        return this;
    }
}

