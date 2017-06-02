package main.Model.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Model.Movable;
import main.Model.Point;
import main.Model.Resizable;

import java.io.Serializable;

/**
 * A representation of an abstract drawablee shape. For consistency, (x,y)
 * should represent the upper-left point for all sub shapes. The velocity,
 * (dx,dy), is measured in pixels per second. Subclasses must override the
 * methods - paint(GraphicsContext), defining how to paint the specific subtype
 * - constrain(...), defining how to keep the shape inside a specified area
 * ("window"). Furthermore, som subtypes must override the move methods,
 * depending on whether the added extra members defines absolute or relative
 * coordinates.
 *
 * @author Anders Lindström, anderslm@kth.se 2015-09-16
 */
abstract public class Shape implements Movable, Resizable, Cloneable, Serializable {

    private Point point1, point2;
    private double red,blue,green;

    protected Shape(double x, double y, double red, double green, double blue) {
        this.point1 = new Point(x,y);
        this.point2 = new Point(x,y);
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    protected Shape(double x, double y) {
        this.point1 = new Point(x,y);
        this.point2 = new Point(x,y);
        this.red = 0.0;
        this.green = 0.0;
        this.blue = 0.0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
            return super.clone();
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    protected Shape() {
        this(0.0, 0.0);
    }
    public Color getColor() {
        return new Color(red,green,blue,1);
    }
    public void setColor(double red, double green, double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    abstract public void draw(GraphicsContext gc);

    public boolean isInsideBounds(double x, double y){
        return (x > point1.getX()) && (y > point1.getY()) && (x < point2.getX()) && (y < point2.getY());
    }

    public boolean isInsideBounds(Point start, Point end){
        return (point1.getX() > start.getX()) &&
                (point1.getY() > start.getY()) &&
                (point2.getX() > start.getX()) &&
                (point2.getY() > start.getY()) &&
                (point1.getX() < end.getX()) &&
                (point1.getY() < end.getY()) &&
                (point2.getX() < end.getX()) &&
                (point2.getY() < end.getY());
    }

    public boolean isInsideResizeBounds(double x, double y){
        if((x > point1.getX()) && (y > point1.getY()) && (x < point2.getX()) && (y < point2.getY())){
            return point2.distanceToPoint(new Point(x , y)) < 10;
        }
        return false;
    }
    @Override
    public void move(double x, double y) {
        double dx = Math.abs(point1.getX() - point2.getX());
        double dy = Math.abs(point1.getY() - point2.getY());
        point1 = new Point(x,y);
        point2 = new Point(x + dx, y + dy);
    }

    @Override
    public void resize(double x, double y) {
            point2.setY(y);
            point2.setX(x);
    }

}
