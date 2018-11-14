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
public interface Delivery {
    
    /**
     * 
     * Deliveries that implement this class must have getType method.
     * @return type of delivery
     */
    public String getType();
    
    /**
     * 
     * Deliveries that implement this class must have getPrice method.
     * @return delivery price
     */
    public double getPrice();
    
    /**
     * 
     * Deliveries that implement this class must have getDays method.
     * @return days until delivery will arrive
     */
    public int getDays();
}
