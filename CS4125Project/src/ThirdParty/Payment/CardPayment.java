package ThirdParty.Payment;

public class CardPayment extends Payment {

    public void MakePayment(){
        _IPaymentSystem.processPayment("Card Banking");
    }
}