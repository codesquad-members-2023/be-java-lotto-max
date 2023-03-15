package main.java.kr.codesquad.domain;

public class Amount {
    private final static int TicketPrice = 1_000;
    private final int purchaseAmount;

    Calculator calculator = new Calculator();

    public Amount(String inputAmount) {
        AmountValidator amountValidator = new AmountValidator();
        this.purchaseAmount = amountValidator.validateAmount(TicketPrice, inputAmount);
    }

    public int calculateTicketCount() {
        return this.calculator.division(purchaseAmount, TicketPrice);
    }

    public double calculateReturnRate(int wonAmount) {
        double a = (((double)  wonAmount - this.purchaseAmount ) / (double) this.purchaseAmount) * 100;
        return a;

    }
}
