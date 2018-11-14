package ThirdParty.Payment;

public class NetBankingPayment extends Payment {
    
    @Override
    public void MakePayment() {
        _IPaymentSystem.processPayment("NetBanking Payment");
    }
}