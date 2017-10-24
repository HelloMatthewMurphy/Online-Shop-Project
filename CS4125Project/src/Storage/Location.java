package Storage;

/**
 *
 * @author Matthew Murphy
 */
public class Location {
    private String country;
    private String address;
    
    public Location(String country, String address){
        this.country = country;
        this.address = address;
    }
    
    public String GetCountry(){
        return country;
    }
    
    public void SetCountry(String country){
        this.country = country;
    }
    
    public String GetAddress(){
        return address;
    }
    
    public void SetAddress(String address){
        this.address = address;
    }
}
