/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Shane
 */
public interface IDatabase {
    
    public void setFilename(String filename);
    public void save() throws IOException;
    public void load() throws IOException;
    
}
