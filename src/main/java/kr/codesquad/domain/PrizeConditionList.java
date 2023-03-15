package main.java.kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import main.java.kr.codesquad.domain.PrizeConditions.MatchingNumberCountCondition;

public class PrizeConditionList {
    private HashMap<PrizeCondition, Integer> prizeConditionsAndCount = new HashMap<>();
    {
        prizeConditionsAndCount.put(new MatchingNumberCountCondition(PrizeType.FIRST_PRIZE), 0);
        prizeConditionsAndCount.put(new MatchingNumberCountCondition(PrizeType.SECOND_PRIZE), 0);
        prizeConditionsAndCount.put(new MatchingNumberCountCondition(PrizeType.THIRD_PRIZE), 0);
        prizeConditionsAndCount.put(new MatchingNumberCountCondition(PrizeType.FOURTH_PRIZE), 0);
    }


    public int returnPrize(ArrayList<Integer> winningNumbers, ArrayList<Integer> ticketNumbers) {
        int wonAmount = 0;
        for (Map.Entry<PrizeCondition, Integer> entry : prizeConditionsAndCount.entrySet()) {
            int prize = entry.getKey().returnPrize(winningNumbers, ticketNumbers);
            if (prize > 0) {
                wonAmount += prize;
                entry.setValue(entry.getValue() + 1);
            }
        }
        return wonAmount;
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<PrizeCondition, Integer> entry : prizeConditionsAndCount.entrySet()) {
            int count = entry.getValue();
            sb.append(entry.getKey().toString());
            sb.append(count).append("개\n");
        }
        return sb.toString();
    }
}
