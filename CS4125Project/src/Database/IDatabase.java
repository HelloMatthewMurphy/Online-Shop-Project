package Database;

import java.io.IOException;

/**
 * Every database implements IDatabase
 * @author Shane
 */
public interface IDatabase {
    
    /**
     * Sets filename.
     * @param filename the filename
     */
    public void setFilename(String filename);

    /**
     * Saves database.
     * @throws IOException -
     */
    public void save() throws IOException;

    /**
     * Loads database.
     * @throws IOException -
     */
    public void load() throws IOException;
    
}
