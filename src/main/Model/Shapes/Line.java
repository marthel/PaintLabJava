package main.Model.Shapes; /**
 * Created by waleed on 15-09-21.
 */
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

import java.awt.geom.GeneralPath;


public class Line extends Shape {


    public Line(double x, double y){
        super(x,y);
    }

    public void draw(GraphicsContext gc){
        gc.setFill(super.getColor());
        gc.strokeLine(super.getPoint1().getX(), super.getPoint1().getY(), super.getPoint2().getX(), super.getPoint2().getY());
    }

}
