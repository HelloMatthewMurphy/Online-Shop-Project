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
public class ReceiptDirector {
 
    private static ReceiptDirector instance;
    
    public static ReceiptDirector GetInstance(){
    if(instance == null)
        instance = new ReceiptDirector();
    return instance;
    }
    
    public void makeReceipt(ReceiptBuilder receiptBuilder){
    receiptBuilder.buildusername();
    receiptBuilder.buildEmail();
    receiptBuilder.buildPaymentDetails();
    receiptBuilder.buildPurchases();
    }
        
}
