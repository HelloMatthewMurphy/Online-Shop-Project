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
    
    private final ArrayList<Command> commands;
    //private Command undoCommand;
    private final Stack<Command> undoCommands;
    private static ShopControl instance;
    public int numCommands;
    
    private ShopControl(){
        this.commands = new ArrayList<>();
        this.undoCommands = new Stack<>();
        this.numCommands = 0; 
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
        undoCommands.push(commands.get(commandNum));
    }
    
}
