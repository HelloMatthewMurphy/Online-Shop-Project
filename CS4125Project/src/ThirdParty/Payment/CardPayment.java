package ThirdParty.Payment;

public class CardPayment extends Payment {

    @Override
    public void MakePayment(){
        _IPaymentSystem.processPayment("Card Banking");
    }
}