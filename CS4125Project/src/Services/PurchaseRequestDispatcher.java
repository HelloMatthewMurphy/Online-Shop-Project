/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.ArrayList;

/**
 *
 * @author Shane
 */
public class PurchaseRequestDispatcher {
    
    private ArrayList<PurchaseRequestInterceptor> interceptors;
    
    public PurchaseRequestDispatcher() {
        interceptors = new ArrayList<>();
    }
    
    public void registerInterceptor(PurchaseRequestInterceptor interceptor) {
        interceptors.add(interceptor);
        
        // Sort interceptors by priority
        interceptors.sort(
            (PurchaseRequestInterceptor in1, PurchaseRequestInterceptor in2) 
                -> in1.compareTo(in2)
        );
    }
    
    public void unregisterInterceptor(PurchaseRequestInterceptor interceptor) {
        if (interceptors.contains(interceptor))
            interceptors.remove(interceptor);
    }
    
    public void dispatch(PurchaseRequest req) {        
        // Pre-purchase
        for (PurchaseRequestInterceptor interceptor : interceptors) {
            interceptor.onPrePurchaseRequest(req);
        }
        
        req.execute();
        
        // Post-purchase
        for (PurchaseRequestInterceptor interceptor : interceptors) {
            interceptor.onPostPurchaseRequest(req);
        }
    }
}
