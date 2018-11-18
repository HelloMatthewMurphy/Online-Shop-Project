package ThirdParty.Payment;

/**
 *
 * @author Brian
 */
public class CardPayment extends Payment {

    @Override
    public void MakePayment(){
        _IPaymentSystem.processPayment("Card Banking");
    }
}