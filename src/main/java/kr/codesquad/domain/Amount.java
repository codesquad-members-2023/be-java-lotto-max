package main.java.kr.codesquad.domain;

public class Amount {
    private final static int TICKET_PRICE = 1_000;
    private final int purchaseAmount;

    public Amount(String inputAmount) {
        AmountValidator amountValidator = new AmountValidator();
        this.purchaseAmount = amountValidator.validateAmount(TICKET_PRICE, inputAmount);
    }

    public int calculateTicketCount() {
        return purchaseAmount/TICKET_PRICE;
    }

    public double calculateReturnRate(int wonAmount) {
        double a = (((double)  wonAmount - this.purchaseAmount ) / (double) this.purchaseAmount) * 100;
        return a;

    }
}
