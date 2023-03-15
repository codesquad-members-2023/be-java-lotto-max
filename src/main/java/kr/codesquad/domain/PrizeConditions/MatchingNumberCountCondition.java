package main.java.kr.codesquad.domain.PrizeConditions;

import main.java.kr.codesquad.domain.PrizeCondition;
import main.java.kr.codesquad.domain.PrizeType;

import java.util.ArrayList;

public class MatchingNumberCountCondition extends PrizeCondition {
    private PrizeType prizeType;

    public MatchingNumberCountCondition(PrizeType prizeType){
        this.prizeType = prizeType;
    }

    protected int returnPrize(ArrayList<Integer> winningNumbers, ArrayList<Integer> ticketNumber){
        if(checkCondition(winningNumbers, ticketNumber)){
            return prizeType.getPrizeAmount();
        }
        return NO_PRIZE;
    }

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

    public PrizeType getPrizeType() {
        return this.prizeType;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.prizeType.getMatchingNumberCount()+"개 일치 ("+this.prizeType.getPrizeAmount()+"원)- ");
        return sb.toString();
    }
}
