package Services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Shane
 */
public class PurchaseRequestInterceptorLogging extends PurchaseRequestInterceptor {
    
    private static final int PRIORITY = 1;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            
    String filename;
    
    public PurchaseRequestInterceptorLogging(String filename) {
        super(PRIORITY);
        this.filename = filename;
    }

    @Override
    public void onPrePurchaseRequest(PurchaseRequest req) {
        Purchase p = req.getPurchase();
        String message = String.format(
                "%s:  Customer: %s\tItem: %s\t:Quantity: %d\tDiscount: %.2f\tTotal Cost: %s\n",
                dateFormat.format(p.getDate().getTime()), p.getUsername(), 
                p.getItem().getName(), p.getQuantity(), p.getDiscount(), 
                p.getMoney());
        
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filename, true);
            out.write(message.getBytes());
            out.close();
        } catch (IOException ex) {
            System.err.printf("Error logging to %s\n", filename);
        }
    }

    @Override
    public void onPostPurchaseRequest(PurchaseRequest req) {
    }    
}
