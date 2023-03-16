package main.java.kr.codesquad.domain;

public class Amount {
    //책임: 구매 금액에 관한 계산 처리
    private final static int TICKET_PRICE = 1_000;
    private final int purchaseAmount;

    public Amount(String inputAmount) {
        AmountValidator amountValidator = new AmountValidator();
        //구매 금액 검증 후 변수에 assign함
        this.purchaseAmount = amountValidator.validateAmount(TICKET_PRICE, inputAmount);
    }


    //구매 금액에 따라 티켓 개수 계산
    public int calculateTicketCount() {
        return purchaseAmount/TICKET_PRICE;
    }


    //수익률 계산
    public double calculateReturnRate(int wonAmount) {
        double a = (((double)  wonAmount - this.purchaseAmount ) / (double) this.purchaseAmount) * 100;
        return a;

    }
}
