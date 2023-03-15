package main.java.kr.codesquad.domain;




import java.util.ArrayList;


public class StatisticMaker {
    private double returnRate;

    private PrizeConditionList prizeConditionList;


    public StatisticMaker(ArrayList<Integer> winningNumbers, ArrayList<Ticket> tickets, Amount amount) {
        this.prizeConditionList = new PrizeConditionList();

        this.returnRate = amount.calculateReturnRate( this.calculateWonAmount(winningNumbers, tickets));
    }

    private int calculateWonAmount(ArrayList<Integer> winningNumbers, ArrayList<Ticket> tickets) {
        int wonAmount = 0;
        for (Ticket ticket : tickets) {
            wonAmount += prizeConditionList.returnPrize(winningNumbers, ticket.getNumbers());
        }
        return wonAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.prizeConditionList.toString());
        sb.append("총 수익률은 ").append(returnRate).append("%").append("입니다.");
        return sb.toString();
    }
}
