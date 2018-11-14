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
public abstract class PurchaseRequestInterceptor {
    // Interceptors with higher priorities will happen first
    private int priority;
    
    public PurchaseRequestInterceptor() { 
        this(0);
    }
    
    public PurchaseRequestInterceptor(int priority) {
        this.priority = priority;
    }
    
    public int compareTo(PurchaseRequestInterceptor other) {
        return this.priority - other.priority;
    }
    
    public abstract void onPrePurchaseRequest(PurchaseRequest req);
    public abstract void onPostPurchaseRequest(PurchaseRequest req);
}
