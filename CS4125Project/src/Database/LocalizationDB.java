/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Services.LocalizationLanguage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Matthew
 */
public class LocalizationDB implements IDatabase {
    
    private String filename;
    private int currentLanguage = 0;
    private LocalizationLanguage[] languages;
    private final HashMap<String, ArrayList<String>> localizations;
    
    /** A constructor sets filename and a hashmap of Localization*/
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

    /** Loads in languages and then the localizations*/
    @Override
    public void load() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        
        String[] headings = reader.readLine().split(",");
        languages = new LocalizationLanguage[headings.length - 1];
        for(int i = 1; i < headings.length; i++){
            languages[i-1] = new LocalizationLanguage(headings[i], i-1);
        }
        
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
        if(localizations.get(tag).size() > currentLanguage)
            return localizations.get(tag).get(currentLanguage);
        else
            /* defaults to English */
            return localizations.get(tag).get(0);
    }
    
    public void setLanguage(int languageNumber){
        if(languageNumber <= languages.length){
            currentLanguage = languageNumber;
        }
    }
    
    public LocalizationLanguage[] getLanguages(){
        return languages;
    }
}
