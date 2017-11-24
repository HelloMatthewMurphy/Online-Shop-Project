/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThirdParty.Delivery;

/**
 * A cheaper delivery but takes longer to deliver.
 * @author Brian
 */
public class MoneySaver extends DeliveryDecorator {
    
    /**
     * 
     * @param delivery
     */
    public MoneySaver(Delivery delivery){
        super(delivery);
    }
    
    /**
     * 
     * @return 
     */
    public double getPrice(){
        return tempDelivery.getPrice()-10;
    }
    
    /**
     * 
     * @return 
     */
    public int getDays(){
        return tempDelivery.getDays()+2;
    }
}
