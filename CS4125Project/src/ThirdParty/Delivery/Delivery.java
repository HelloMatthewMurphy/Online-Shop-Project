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
     */
    public String getType();
    
    /**
     * 
     * Deliveries that implement this class must have getPrice method.
     */
    public double getPrice();
    
    /**
     * 
     * Deliveries that implement this class must have getDays method.
     */
    public int getDays();
}
