package Services;

/**
 *
 * @author Shane
 */
public abstract class PurchaseRequestInterceptor {
    // Interceptors with higher priorities will happen first
    private int priority;
    
    /**
     *
     */
    public PurchaseRequestInterceptor() { 
        this(0);
    }
    
    /**
     *
     * @param priority the request priority
     */
    public PurchaseRequestInterceptor(int priority) {
        this.priority = priority;
    }
    
    /**
     *
     * @param other other PurchaseRequestInterceptor to compare too
     * @return priority
     */
    public int compareTo(PurchaseRequestInterceptor other) {
        return this.priority - other.priority;
    }
    
    /**
     *
     * @param req request
     */
    public abstract void onPrePurchaseRequest(PurchaseRequest req);

    /**
     *
     * @param req request
     */
    public abstract void onPostPurchaseRequest(PurchaseRequest req);
}
