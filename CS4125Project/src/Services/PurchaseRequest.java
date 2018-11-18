/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author Shane
 */
public class PurchaseRequest {

    private Purchase purchase;
    
    public PurchaseRequest(Purchase purchase) {
        this.purchase = purchase;
    }
    
    public Purchase getPurchase() {
        return purchase;
    }
    
    public void doPurchase() {
        Shop.getInstance().makePurchase(
            purchase.getItem(), purchase.getQuantity(), 
            purchase.getUsername(), purchase.getMoney().getCurrency()
        );
    }
}
