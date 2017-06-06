package main.Model;


import javafx.event.Event;
import javafx.scene.control.Control;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.Model.ShapeFactory;
import main.Model.Shapes.Circle;
import main.Model.Shapes.Line;
import main.Model.Shapes.Rectangle;
import main.Model.Shapes.Shape;
import main.Model.UserStates.Default;
import main.Model.UserStates.State;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by martin on 02/03/2017.
 */
public class StateHandler {

    State currentState;
    ShapeFactory shapeFactory;
    double r=0,g=0,b=0;
    public StateHandler() {
        this.shapeFactory = new ShapeFactory();
        this.currentState = new Default();
    }

    public void setCurrentColour(String red, String green, String blue) {
        try {
            this.r = Double.parseDouble(red);
            this.g = Double.parseDouble(green);
            this.b = Double.parseDouble(blue);
        } catch (Exception e) {
            r = 0;
            g = 0;
            b = 0;
        } finally {
            currentState = currentState.filling(r,g,b);
        }
    }


    public void updateState(Event event){
        //System.out.println(event.getEventType().toString());
        switch (event.getEventType().toString()) {
            case "ACTION":
                Shape shape = shapeFactory.getShape(((Control)event.getSource()).getId());
                currentState.setShape(shape);
                currentState = currentState.receivedButtonAction();
                break;
            case "MOUSE_DRAGGED":
                currentState = currentState.receivedMouseDrag(event);
                break;
            case "MOUSE_CLICKED":
                currentState = currentState.receivedMouseClick(event);
                break;
            case "KEY_PRESSED":
                System.out.println("shapes: " + currentState.getShapes().size());
                System.out.println("stack: " + currentState.pr.undoMethods.size());
                if(((KeyEvent)event).getCode()== KeyCode.R) {
                    currentState.pr.invokePopRedoMethods();
                    System.out.println("You pressed R");
                }else if (((KeyEvent)event).getCode()== KeyCode.U){
                    System.out.println("You pressed U");
                    currentState.pr.invokePopUndoMethods();
                }
                break;
            default:
                System.out.println("DEFAULT");
                break;
        }

    }

    public void saveFile(String fileName){
        String path = System.getProperty("user.home") + "/Desktop/"+ (fileName != null ? fileName: "1") +".ser";
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(currentState.getShapes());
            out.close();
            fileOut.close();
            System.out.printf("saved" + path);
        }catch(IOException i) {
            i.printStackTrace();
        }
    }
    public void loadFile(String fileName){
        try {
            String path = System.getProperty("user.home") + "/Desktop/"+ (fileName != null ? fileName: "1") +".ser";
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            currentState.setShapes((List<Shape>) in.readObject());
            in.close();
            fileIn.close();
            System.out.printf("loaded" + path);
        }catch(IOException i) {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c) {
            System.out.println("ERROR");
            c.printStackTrace();
            return;
        }
    }

    public List<Shape> getShapesToDraw(){
        return currentState.getShapesToDraw();
    }
}