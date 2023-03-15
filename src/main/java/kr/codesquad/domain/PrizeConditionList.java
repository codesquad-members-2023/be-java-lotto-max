package main.java.kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Arrays;

import main.java.kr.codesquad.domain.PrizeConditions.FirstPrizeCondition;
import main.java.kr.codesquad.domain.PrizeConditions.FouthPrizeCondition;
import main.java.kr.codesquad.domain.PrizeConditions.SecondPrizeCondition;
import main.java.kr.codesquad.domain.PrizeConditions.ThirdPrizeCondition;

public class PrizeConditionList {
    private ArrayList<PrizeCondition> prizeConditions = new ArrayList<>(Arrays.asList(
            new FirstPrizeCondition(),
            new SecondPrizeCondition(),
            new ThirdPrizeCondition(),
            new FouthPrizeCondition()
    ));

    public int retunPrize(ArrayList<Integer> winningNumbers, ArrayList<Integer> ticketNumbers) {
        int wonAmount = 0;
        for (PrizeCondition prizeCondition : prizeConditions) {
            wonAmount += prizeCondition.returnPrize(winningNumbers, ticketNumbers);
        }
        return wonAmount;
    }


}
