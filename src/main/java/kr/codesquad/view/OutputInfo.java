package kr.codesquad.view;

import java.util.Map;

import static kr.codesquad.domain.LotteryPrize.*;

public class OutputInfo {
    public static void printNumOfTicket(int numberOfTicket) {
        System.out.println(numberOfTicket + "개를 구매했습니다.");
    }

    public static void printLotteryNumbers(String ticketList) {
        System.out.println(ticketList);
    }

    public static void printLotteryResult(Map<Integer, Integer> rankMap, double profitability) {
        String sb = "\n당첨 통계\n" + "---------\n" +
                FORTH_PLACE.getNumberOfMatches() + "개 일치 (" + FORTH_PLACE.getPrize() + "원)- " + rankMap.get(FORTH_PLACE.getNumberOfMatches()) + "개\n" +
                THIRD_PLACE.getNumberOfMatches() + "개 일치 (" + THIRD_PLACE.getPrize() + "원)- " + rankMap.get(THIRD_PLACE.getNumberOfMatches()) + "개\n" +
                SECOND_PLACE.getNumberOfMatches() + "개 일치 (" + SECOND_PLACE.getPrize() + "원)- " + rankMap.get(SECOND_PLACE.getNumberOfMatches()) + "개\n" +
                FIRST_PLACE.getNumberOfMatches() + "개 일치 (" + FIRST_PLACE.getPrize() + "원)- " + rankMap.get(FIRST_PLACE.getNumberOfMatches()) + "개\n" +
                "총 수익률은 " + profitability + "%입니다.";
        System.out.println(sb);
    }
}
