package Services;

/**
 *
 * @author Shane
 */
public class PurchaseRequestInterceptorChangeCurrency extends PurchaseRequestInterceptor {
    
    private static final int PRIORITY = 0;
            
    private final Money.Currency targetCurrency;
    
    public PurchaseRequestInterceptorChangeCurrency(Money.Currency targetCurrency) {
        super(PRIORITY);
        this.targetCurrency = targetCurrency;
    }

    @Override
    public void onPrePurchaseRequest(PurchaseRequest req) {
        Purchase p = req.getPurchase();
        p.getMoney().changeCurrency(targetCurrency);
    }

    @Override
    public void onPostPurchaseRequest(PurchaseRequest req) {
    }
}
