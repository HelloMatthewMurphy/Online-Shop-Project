/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author hello
 */
public class ShopControl {
    
    private ArrayList<Command> commands = new ArrayList<Command>();
    //private Command undoCommand;
    private Stack<Command> undoCommands = new Stack<Command>();
    private static ShopControl instance;
    public int numCommands = 0;
    
    private ShopControl(){
        
    }
    
    public static ShopControl GetInstance(){
        if(instance == null)
            instance = new ShopControl();
        return instance;
    }
    
    public void AddCommand(Command command){
        commands.add(command);
        numCommands++;
    }
    
    public void Undo(){
        if(undoCommands.size() > 0){
            Command commandToUndo = undoCommands.pop();
            commandToUndo.Undo();
        }
    }
    
    public void ExecuteCommand(int commandNum){
        commands.get(commandNum).execute();
        //undoCommand = commands.get(commandNum);
        undoCommands.push(commands.get(commandNum));
    }
    
}
