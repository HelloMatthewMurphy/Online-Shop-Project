package ThirdParty.Payment;

public class NetBankingPayment extends Payment {
    
    public void MakePayment() {
        _IPaymentSystem.processPayment("NetBanking Payment");
    }
}