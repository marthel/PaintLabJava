package main.Model.UserStates;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Scalman on 2017-06-05.
 */
public class PanelRegion {

    public Stack<Runnable> undoMethods;
    public Stack<Runnable> redoMethods;

    PanelRegion(){
        undoMethods = new Stack<>();
        redoMethods = new Stack<>();
    }

    public void addUndoMethod(Runnable methodCall) {
        undoMethods.push(methodCall);
    }

    public void addRedoMethod(Runnable methodCall){
        redoMethods.push(methodCall);
    }

    public void invokePopUndoMethods()
    {
        if (undoMethods.empty())
            return;
        redoMethods.push(undoMethods.pop()).run();
    }

    public void invokePopRedoMethods()
    {
        if (redoMethods.empty())
            return;
        undoMethods.push(redoMethods.pop()).run();
    }
}
