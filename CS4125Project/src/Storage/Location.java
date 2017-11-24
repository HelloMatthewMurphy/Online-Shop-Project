package Storage;

/**
 * A object which holds a country and address.
 * @author Matthew Murphy
 */
public class Location {
    private String country;
    private String address;
    
    /**
     * A empty constructor
     */
    public Location(){

    }
    
    /**
     * A constructor which sets country and address.
     * @param country
     * @param address 
     */
    public Location(String country, String address){
        this.country = country;
        this.address = address;
    }
    
    /**
     * 
     * @return 
     */
    public String getCountry(){
        return country;
    }
    
    /**
     * 
     * @param country 
     */
    public void setCountry(String country){
        this.country = country;
    }
    
    /**
     * 
     * @return address
     */
    public String getAddress(){
        return address;
    }
    
    /**
     * 
     * @param address 
     */
    public void setAddress(String address){
        this.address = address;
    }
}
