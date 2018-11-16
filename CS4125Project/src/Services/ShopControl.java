/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.ArrayList;
import java.util.Stack;

/**
 * The controller for the shop that keeps the commands and the order there executed in
 * @author Matthew Murphy
 */
public class ShopControl {
    
    private final ArrayList<Command> commands;
    private final Stack<Command> undoCommands;
    private static ShopControl instance;
    
    public int numCommands;

    /**
     * A constructor for ShopControl
     */
    private ShopControl(){
        this.commands = new ArrayList<>();
        this.undoCommands = new Stack<>();
        this.numCommands = 0; 
    }
    
    /**
     * Gets instance of Shop control and creates one if none exist
     * @return instance
     */
    public static ShopControl getInstance(){
        if(instance == null)
            instance = new ShopControl();
        return instance;
    }
    
    /**
     * Adds a command to the commands
     * @param command
     */
    public void addCommand(Command command){
        commands.add(command);
        numCommands++;
    }
    
    /**
     * Executes the command at commandNum
     */
    public void undo(){
        if(undoCommands.size() > 0){
            Command commandToUndo = undoCommands.pop();
            commandToUndo.undo();
        }
    }
    
    /**
     * Executes the command at commandNum
     * @param commandNum
     */
    public void executeCommand(int commandNum){
        commands.get(commandNum).execute();
        undoCommands.push(commands.get(commandNum));
    }
    
}
