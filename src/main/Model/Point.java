package main.Model;

import java.io.Serializable;

/**
 * Created by martin on 11/03/2017.
 */
public class Point implements Serializable{
    double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    //d=√((x2-x1)^2​+(y2−y1)^​2)
    public double distanceToPoint(Point p) {
        return Math.sqrt(Math.pow((p.getX()-x),2)+ Math.pow((p.getY()-y),2));
    }

    public static Point closestPoint(Point mouse,Point topLeft,Point bottomRight){
        return Math.sqrt(Math.pow((mouse.getX()-topLeft.getX()),2)+ Math.pow((mouse.getY()-topLeft.getY()),2)) <
                Math.sqrt(Math.pow((mouse.getX()-bottomRight.getX()),2)+ Math.pow((mouse.getY()-bottomRight.getY()),2)) ?
                topLeft :
                bottomRight;
    }
}
