/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Jack
 */
interface ReceiptBuilder {

    public void buildUser(); 
  
    public void buildPayment(); 
  
    public void bulidDelivery(); 
  
    public void buildPurchases(); 
  
    public Receipt getReceipt(); 
}
