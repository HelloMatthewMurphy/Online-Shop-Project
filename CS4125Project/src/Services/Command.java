/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 * The command interface for the command design pattern. 
 * @author Matthew Murphy
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
