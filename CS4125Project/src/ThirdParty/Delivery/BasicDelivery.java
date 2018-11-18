/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdParty.Delivery;

/**
 *
 * @author Brian
 */
public class BasicDelivery implements Delivery {
    
    /**
     * An empty constructor
     */
    public BasicDelivery(){
        
    }
    
    /**
     * Gets basic delivery
     * @return "Basic Delivery"
     */
    @Override
    public String getType() {
       return "Basic Delivery";
    }
    
    /**
     * Gets price of delivery
     * @return price
     */
    @Override
    public double getPrice() {
       return 20.00;
    }
    
    /**
     * 
     * @return 5
     */
    @Override
    public int getDays() {
        return 5;
    }
}
