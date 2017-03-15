package main.Model.Shapes;

import java.awt.*;
import javafx.scene.paint.Color;
/**
 * Created by waleed on 15-09-23.
 */
 public abstract class FillableShape extends Shape {
    private boolean isFilled;
    protected FillableShape(double x,double y){
        super(x,y);
        this.isFilled = false;
    }
    public boolean isFilled(){
        return isFilled;
    }
    public void setFilled(boolean isFilled){
        this.isFilled = isFilled;
    }
}
