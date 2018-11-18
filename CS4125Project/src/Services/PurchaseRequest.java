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
