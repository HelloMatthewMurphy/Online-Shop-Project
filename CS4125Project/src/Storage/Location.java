package Storage;

/**
 * A object which holds a country and address.
 * @author Matthew
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
     * @param country country of user
     * @param address address of user
     */
    public Location(String country, String address){
        this.country = country;
        this.address = address;
    }
    
    /**
     * 
     * @return country
     */
    public String getCountry(){
        return country;
    }
    
    /**
     * 
     * @param country the country of user
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
     * @param address address of user
     */
    public void setAddress(String address){
        this.address = address;
    }
}
