package main.Model.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Model.Shapes.FillableShape;

/**
 * Created by eddlow on 21/09/15.
 */
public class Circle extends FillableShape {

    /**
     * rad decides the radious of the circle
     */

    public Circle(double x, double y){
        super(x, y);
    }

    @Override
    public void draw(GraphicsContext gc){
        double dx = Math.abs(getPoint1().getX()-getPoint2().getX());
        double dy = Math.abs(getPoint1().getY()-getPoint2().getY());
        gc.setFill(super.getColor());
        if (isFilled()){
            gc.fillOval(super.getPoint1().getX(), super.getPoint1().getY(), dx, dy);
        }
        else {
            gc.strokeOval(super.getPoint1().getX(), super.getPoint1().getY(), dx, dy);
        }
    }

}
