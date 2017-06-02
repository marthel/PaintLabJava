package main.Model.UserStates;

import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import main.Model.Point;
import main.Model.Shapes.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by waleedhassan on 15/03/17.
 */
public class GroupSelected extends State {
    Point startPoint;
    List<Shape> selectedShapes;

    public GroupSelected(List<Shape> shapes, Shape shape, Point startPoint) {
        super(shapes, shape);
        this.startPoint = startPoint;
        selectedShapes = new ArrayList<>();
    }
    @Override
    public State receivedMouseClick(Event event) {
        double x = ((MouseEvent)event).getX();
        double y = ((MouseEvent)event).getY();
        Point endPoint = new Point(x,y);
        for (Shape s: shapes) {
            if(s.isInsideBounds(startPoint,endPoint)){
                selectedShapes.add(s);
            }
        }
        if(selectedShapes.isEmpty()) {
            return new Default(shapes, null);
        } else {
            System.out.println(selectedShapes.size());
            return new MovingGroup(shapes, null, selectedShapes);
        }
    }

    @Override
    public State receivedMouseDrag(Event event) {
        return this;
    }
}
