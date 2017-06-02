package main.Model.UserStates;

import javafx.event.Event;
import javafx.scene.input.MouseEvent;
import main.Model.Point;
import main.Model.Shapes.FillableShape;
import main.Model.Shapes.Shape;

import java.util.List;

/**
 * Created by martin on 01/06/2017.
 */
public class Filling extends State {
    double r, g, b;

    public Filling(List<Shape> shapes, Shape shape, double r, double g, double b) {
        super(shapes, shape);
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public State receivedButtonAction() {
        //change shape same state
        return this;
    }

    @Override
    public State receivedMouseClick(Event event) {
        //if shape is selected change to selectedShape state else default
        double x = ((MouseEvent) event).getX();
        double y = ((MouseEvent) event).getY();
        try {
            for (Shape s : shapes) {
                if (s.isInsideBounds(x, y)) {

                    ((FillableShape) s).setFilled(true);
                    s.setColor(r, g, b);
                }
            }
        } catch (Exception ignored) {
        }
        return new Default(shapes, null);
    }
}


