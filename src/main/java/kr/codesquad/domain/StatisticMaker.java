package main.java.kr.codesquad.domain;




import java.util.ArrayList;


public class StatisticMaker {
    //책임: 통계 만들기
    private double returnRate;

    private PrizeConditionList prizeConditionList;


    public StatisticMaker(ArrayList<Integer> winningNumbers, ArrayList<Ticket> tickets, Amount amount) {
        //당첨 금액과 조건을 담고 있는 리스트
        this.prizeConditionList = new PrizeConditionList();

        //수익률 계산
        this.returnRate = amount.calculateReturnRate( this.calculateEarnedAmount(winningNumbers, tickets));
    }


    //수익률을 위해 수익 계산
    private int calculateEarnedAmount(ArrayList<Integer> winningNumbers, ArrayList<Ticket> tickets) {
        int wonAmount = 0;
        for (Ticket ticket : tickets) {
            //prizeConditionList에서 조건 확인 후 당첨 금액 반환
            wonAmount += prizeConditionList.returnPrize(winningNumbers, ticket.getNumbers());
        }
        return wonAmount;
    }

    //통계 정보 문자로 변경
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.prizeConditionList.toString());
        sb.append("총 수익률은 ").append(returnRate).append("%").append("입니다.");
        return sb.toString();
    }
}
