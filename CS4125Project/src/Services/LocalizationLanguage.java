package Services;

/**
 *
 * @author Matthew
 */
public class LocalizationLanguage {
    private String languageName;
    private int languageNum;
    
    /**
     *
     * @param name localization language name
     * @param num localization language number
     */
    public LocalizationLanguage(String name, int num){
        languageName = name;
        languageNum = num;
    }
    
    /**
     *
     * @return languageName
     */
    public String getName(){
        return languageName;
    }
    
    /**
     *
     * @return languageNum
     */
    public int getNum(){
        return languageNum;
    }
}
