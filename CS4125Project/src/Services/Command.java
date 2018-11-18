package Services;

/**
 * The command interface for the command design pattern. 
 * @author Matthew
 */
public interface Command {

    /**
     * Will execute the command
     */
    public void execute();

    /**
     * Undo the command
     */
    public void undo();
}
