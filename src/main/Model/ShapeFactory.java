package main.Model;

import main.Model.Shapes.Circle;
import main.Model.Shapes.Line;
import main.Model.Shapes.Rectangle;
import main.Model.Shapes.Shape;

/**
 * Created by martin on 15/03/2017.
 */
public class ShapeFactory {

    private Line line;
    private Circle circle;
    private Rectangle rectangle;

    public ShapeFactory() {
        this.line = new Line(0,0);
        this.circle = new Circle(0,0);
        this.rectangle =  new Rectangle(0,0);
    }

    public Shape getShape(String shapeType) {
        switch (ShapeType.valueOf(shapeType)) {
            case circle:
                try {
                    return (Shape) circle.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            case line:
                try {
                    return (Shape) line.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            case square:
                try {
                    return (Shape) rectangle.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            default:
                break;
        }
        return null;
    }
    
}
