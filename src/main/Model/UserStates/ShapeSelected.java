package main.Model.UserStates;

import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import main.Model.Shapes.Shape;

import java.util.List;

/**
 * Created by martin on 10/03/2017.
 */
public class ShapeSelected extends State {

    public ShapeSelected(List<Shape> shapes, Shape shape) {
        super(shapes,shape);
    }

    @Override
    public State receivedButtonAction() {
        //change state drawing
        return new Drawing(shapes,shape);
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
        //change to resize state if the shape corner is dragged, if the shape is dragged change to moving, if the canvas is dragged change to groupselected state
        double x = ((MouseEvent)event).getX();
        double y = ((MouseEvent)event).getY();
        if(shape.isInsideResizeBounds(x,y)){
            return new Resize(shapes,shape);
        }
        if(shape.isInsideBounds(x,y)) {
            return new Moving(shapes,shape);
        }
        return new Default(shapes,null);
    }
}
