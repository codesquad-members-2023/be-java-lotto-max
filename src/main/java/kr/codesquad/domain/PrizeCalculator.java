package kr.codesquad.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.codesquad.domain.LotteryPrize.*;

public class PrizeCalculator {
    public Map<Integer, Integer> operateRank(List<Integer> numberOfMatchList) {
        Map<Integer, Integer> rankMap = new HashMap<>();
        rankMap.put(FIRST_PLACE.getNumberOfMatches(), 0);
        rankMap.put(SECOND_PLACE.getNumberOfMatches(), 0);
        rankMap.put(THIRD_PLACE.getNumberOfMatches(), 0);
        rankMap.put(FORTH_PLACE.getNumberOfMatches(), 0);

        for(int num : numberOfMatchList) {
            rankMap.computeIfPresent(num, (k, v) -> v + 1);
        }
        return rankMap;
    }

    public int operateProfitability(Map<Integer, Integer> rankMap) {
        int totalPrize = 0;
        for (Map.Entry<Integer, Integer> entry : rankMap.entrySet()) {
            int match = entry.getKey();
            int count = entry.getValue();
            if(count > 0) {
                totalPrize += LotteryPrize.fromNumOfMatches(match).getPrize() * count;
            }
        }
        return totalPrize;
    }
}


/*
    Map 전체 출력하기 위해서는 entrySet(), keySet() 메소드를 사용
    entrySet() : key, value 값 모두 필요한 경우 사용
    keySet() : key 값만 필요한 경우 사용
 */