package Storage;

/**
 *
 * @author Matthew Murphy
 */
public class Location {
    private String country;
    private String address;
    
    public Location(){

    }
    
    public Location(String country, String address){
        this.country = country;
        this.address = address;
    }
    
    public String getCountry(){
        return country;
    }
    
    public void setCountry(String country){
        this.country = country;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
}
