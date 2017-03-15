package main.Model.Shapes;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;


/**
 * Created by waleed on 15-09-22.
 */
public class Rectangle extends FillableShape {


    public Rectangle(double x, double y) {
        super(x, y);
    }

    public void draw(GraphicsContext gc){
        double dy = Math.abs(super.getPoint1().getY() - super.getPoint2().getY());
        double dx = Math.abs(super.getPoint1().getX() - super.getPoint2().getX());

        gc.setFill(super.getColor());
        if (isFilled()) {
            gc.fillRect(super.getPoint1().getX(), super.getPoint1().getY(), dx, dy);
        }else {
            gc.strokeRect(super.getPoint1().getX(), super.getPoint1().getY(), dx, dy);
        }
    }

}
