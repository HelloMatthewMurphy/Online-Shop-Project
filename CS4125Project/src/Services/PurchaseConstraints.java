/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.GregorianCalendar;

/**
 *
 * @author Shane
 */
public class PurchaseConstraints {
    
    public enum PurchaseType { SALES, RETURNS }
    
    private GregorianCalendar start;
    private GregorianCalendar end;
    private String category;
    private String product;
    private PurchaseType type;
    
    /**
    *
    * @param start
    * @param end
    */
    public PurchaseConstraints(GregorianCalendar start, GregorianCalendar end, 
            PurchaseType type) {
        this(start, end, null, null, type);
    }
    
    /**
    *
    * @param start
    * @param end
    * @param category
    * @param product
    * @param type
    */
    public PurchaseConstraints(GregorianCalendar start, GregorianCalendar end, 
            String category, String product, PurchaseType type) {
        this.start = start;
        this.end = end;
        this.category = category;
        this.product = product;
        this.type = type;
    }
    
    /**
    *
    * @return start
    * 
    */
    public GregorianCalendar getStart() {
        return start;
    }
    
    /**
    *
    * @return end
    * 
    */
    public GregorianCalendar getEnd() {
        return end;
    }
    
    /**
    *
    * @return category
    * 
    */
    public String getCategory() {
        return category;
    }
    
    /**
    *
    * @return product
    * 
    */
    public String getProduct() {
        return product;
    }
    
    /**
    *
    * @return type
    * 
    */
    public PurchaseType getType() {
        return type;
    }
}
