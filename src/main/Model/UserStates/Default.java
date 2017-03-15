package main.Model.UserStates;

import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import main.Model.Point;
import main.Model.Shapes.Shape;

import java.util.List;

/**
 * Created by martin on 10/03/2017.
 */
public class Default extends State {


    public Default() {
    }

    public Default(List<Shape> shapes,Shape shape) {
        super(shapes,shape);
    }

    @Override
    public State receivedButtonAction() {
        //change state drawing
        return new Drawing(shapes, shape);
    }

    @Override
    public State receivedMouseClick(Event event) {
        //if shape is selected change to selectedShape state else default
        double x = ((MouseEvent)event).getX();
        double y = ((MouseEvent)event).getY();
        for (Shape s: shapes) {
            if(s.isInsideBounds(x,y)) {
                return new ShapeSelected(shapes,s);
            }
        }
        return new Default(shapes, null);
    }

    @Override
    public State receivedMouseDrag(Event event) {
        //if more than one shape is selected change to selectedGroup state
        double x = ((MouseEvent)event).getX();
        double y = ((MouseEvent)event).getY();
        return new GroupSelected(shapes,null, new Point(x,y));
    }
}
