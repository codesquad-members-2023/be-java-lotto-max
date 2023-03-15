package main.java.kr.codesquad.domain;




import java.util.ArrayList;
import java.util.Arrays;


public class Result {
    private double returnRate;

    private PrizeConditionList prizeConditionList;


    public Result(ArrayList<Integer> winningNumbers, ArrayList<Ticket> tickets, Amount amount) {
        this.prizeConditionList = new PrizeConditionList();

        this.returnRate = amount.calculateReturnRate( this.calculateWonAmount(winningNumbers, tickets));
    }

    private int calculateWonAmount(ArrayList<Integer> winningNumbers, ArrayList<Ticket> tickets) {
        int wonAmount = 0;
        for (Ticket ticket : tickets) {
            wonAmount += prizeConditionList.retunPrize(winningNumbers, ticket.getNumbers());
        }
        return wonAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(returnRate);
        return sb.toString();
    }
}
