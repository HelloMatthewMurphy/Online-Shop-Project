/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Storage.Location;
import ThirdParty.Payment.*;

/**
 *
 * @author Jack
 */
public class Customer extends Account{
    Location location;
    Payment payment_type;
    
    public Customer(String name, String password, String email){
        super(name, password, email);
        this.location = new Location(); 
        this.payment_type = null;
    }
    
    public void setLoc(String country, String address){
        location.setCountry(country);
        location.setAddress(address);
    }
    
    public String getLocation(){
        return location.getAddress();
    }
    
    public void setPaymentType(Payment payment) {
        payment_type = payment;
    }
    
    public Payment getPaymentType() {
        return payment_type;
    }
    
}
