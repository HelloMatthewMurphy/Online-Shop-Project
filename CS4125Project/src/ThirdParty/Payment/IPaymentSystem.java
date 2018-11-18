package ThirdParty.Payment;

/**
 *
 * @author Brian
 */
public interface IPaymentSystem {

    /**
     * Will process payment.
     * @param paymentSystem the payment system for the payment
     */
    void processPayment(String paymentSystem);
}