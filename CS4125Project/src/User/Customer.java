/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Storage.Location;

/**
 *
 * @author Jack
 */
public class Customer extends Account{
    Location location;
    
    public Customer(String name, String password, String email){
        super(name, password, email);
        this.location = new Location(); 
    }
    
    public void setLoc(String country, String address){
        location.setCountry(country);
        location.setAddress(address);
    }
    
    public String getLocation(){
        return location.getAddress();
    }
    
}
