package Services;

import java.util.ArrayList;
import java.util.Stack;

/**
 * The controller for the shop that keeps the commands and the order there executed in
 * @author Matthew
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
     * @param command command to add
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
     * @param commandNum the command number of the command to execute
     */
    public void executeCommand(int commandNum){
        commands.get(commandNum).execute();
        undoCommands.push(commands.get(commandNum));
    }
    
}
