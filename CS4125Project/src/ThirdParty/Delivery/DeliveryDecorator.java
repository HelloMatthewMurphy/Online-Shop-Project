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
public class DeliveryDecorator implements Delivery {
    
    protected Delivery tempDelivery;
    
    public DeliveryDecorator(Delivery newDelivery){
        tempDelivery = newDelivery;
        
    }
    
    public String getType(){
        return tempDelivery.getType();
    }
    
    public double getPrice(){
        return tempDelivery.getPrice();
    }
    
    public int getDays(){
        return tempDelivery.getDays();
    }
}
