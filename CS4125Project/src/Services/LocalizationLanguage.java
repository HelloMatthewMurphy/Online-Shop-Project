/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Matthew
 */
public class LocalizationLanguage {
    private String languageName;
    private int languageNum;
    
    public LocalizationLanguage(String name, int num){
        languageName = name;
        languageNum = num;
    }
    
    public String getName(){
        return languageName;
    }
    
    public int getNum(){
        return languageNum;
    }
}
