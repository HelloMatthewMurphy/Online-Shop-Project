/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdParty.Delivery;

/**
 * Decorator design pattern.
 * @author Brian
 */
public class DeliveryDecorator implements Delivery {
    
    protected Delivery tempDelivery;
    
    /**
     * 
     * @param newDelivery A new delivery.
     */
    public DeliveryDecorator(Delivery newDelivery){
        tempDelivery = newDelivery;
        
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String getType(){
        return tempDelivery.getType();
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public double getPrice(){
        return tempDelivery.getPrice();
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int getDays(){
        return tempDelivery.getDays();
    }
}
