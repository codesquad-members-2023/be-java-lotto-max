package main.java.kr.codesquad.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.java.kr.codesquad.domain.PrizeConditions.MatchingNumberCountCondition;

public class PrizeConditionList {
    //책임: 당첨 조건 확인 후 금액 반환 + 당첨 조건에 몇개가 맞는지 기억?
    private HashMap<PrizeCondition, Integer> prizeConditionsAndCount = new HashMap<>();
    {
        prizeConditionsAndCount.put(new MatchingNumberCountCondition(PrizeType.FIRST_PRIZE), 0);
        prizeConditionsAndCount.put(new MatchingNumberCountCondition(PrizeType.SECOND_PRIZE), 0);
        prizeConditionsAndCount.put(new MatchingNumberCountCondition(PrizeType.THIRD_PRIZE), 0);
        prizeConditionsAndCount.put(new MatchingNumberCountCondition(PrizeType.FOURTH_PRIZE), 0);
    }

    //조건 확인 후 금액 반환
    public int returnPrize(ArrayList<Integer> winningNumbers, ArrayList<Integer> ticketNumbers) {
        int wonAmount = 0;
        for (Map.Entry<PrizeCondition, Integer> entry : prizeConditionsAndCount.entrySet()) {
            int prize = entry.getKey().returnPrize(winningNumbers, ticketNumbers);
            if (prize > 0) {
                wonAmount += prize;
                //조건에 맞는 티켓 개수 ++
                entry.setValue(entry.getValue() + 1);
            }
        }
        return wonAmount;
    }


    //조건+ 조건에 맞는 티켓 개수 정보 문자로 변환
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
