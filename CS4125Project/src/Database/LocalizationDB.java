/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Stock.StockItem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author hello
 */
public class LocalizationDB implements IDatabase {
    
    String filename;
    int currentLanguage;
    HashMap<String, ArrayList<String>> localizations;
    
    /**
     * A constructor sets filename and a hashmap of Localization
     */
    public LocalizationDB() {
        filename = "";
        localizations = new HashMap();
    }

    @Override
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public void save() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void load() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        reader.readLine();
        
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            ArrayList<String> langaugeStrings = new ArrayList<String>();
            for(int i = 1; i < data.length; i++){
                langaugeStrings.add(data[i]);
            }
            localizations.put(data[0], langaugeStrings);
        }
        reader.close();  
    }
    
    public String GetLocalization(String tag){
        String localizedString =  localizations.get(tag).get(0);
        return localizedString;
    }
}
