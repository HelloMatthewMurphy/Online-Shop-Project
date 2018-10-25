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
    
    public ShopControl(){
        
    }
    
    public void AddCommand(Command command){
        commands.add(command);
    }
    
    public void Undo(){
        //if(undoCommand != null)
        //    undoCommand.Undo();
        Command commandToUndo = undoCommands.pop();
        commandToUndo.Undo();
    }
    
    public void ExecuteCommand(int commandNum){
        commands.get(commandNum).execute();
        //undoCommand = commands.get(commandNum);
        undoCommands.push(commands.get(commandNum));
    }
    
}
