package main.java.kr.codesquad.domain.PrizeConditions;

import main.java.kr.codesquad.domain.PrizeCondition;
import main.java.kr.codesquad.domain.PrizeType;

import java.util.ArrayList;

public class MatchingNumberCountCondition extends PrizeCondition {
    //추상 클래스 - 책임: 당첨 조건 확인 + 금액 반환
    private PrizeType prizeType;

    //생성자에서 어느 당첨 조건인지 생성함
    public MatchingNumberCountCondition(PrizeType prizeType){
        this.prizeType = prizeType;
    }


    //금액 반환
    protected int returnPrize(ArrayList<Integer> winningNumbers, ArrayList<Integer> ticketNumber){
        if(checkCondition(winningNumbers, ticketNumber)){
            return prizeType.getPrizeAmount();
        }
        return NO_PRIZE;
    }

    //조건 확인
    protected boolean checkCondition(ArrayList<Integer> winningNumbers, ArrayList<Integer> ticketNumber){
        int count = 0;
        for(Integer i : ticketNumber){
            if(winningNumbers.contains(i)){
                count++;
            }
        }
        if(count == prizeType.getMatchingNumberCount()){
            return true;
        }
        return false;
    }

    //조건 +  금액 문자로 변환
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.prizeType.getMatchingNumberCount()+"개 일치 ("+this.prizeType.getPrizeAmount()+"원)- ");
        return sb.toString();
    }
}
