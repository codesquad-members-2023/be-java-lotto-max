package kr.codesquad.view;

import kr.codesquad.domain.Winning;

import java.util.List;
import java.util.Map;

public class LottoOutput {
    public LottoOutput() {
    }

    public void noticeLottoAmountNumber(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public void printLotto(List<List<Integer>> lottoLists) {
        lottoLists.forEach(System.out::println);
        printNewLine();
    }

    public void noticeMatchingFormat(Map<Integer, Integer> matchingNumbersMap, int bonusCount) {
        printNewLine();
        System.out.println("당첨 통계\n---------");
        for (int i = 3; i <= 6; i++) {
            System.out.println(i + "개 일치 (" + Winning.getMoney(i) + "원) - " +
                    matchingNumbersMap.getOrDefault(i, 0) + "개");
            if (i == 5) {
                System.out.println(i + "개 일치, 보너스 볼 일치(" + Winning.getMoney(5) * 20 + "원) - " + bonusCount + "개");
            }
        }
//        IntStream.rangeClosed(3, 6)
//                .mapToObj(i -> i + "개 일치 (" + Winning.getMoney(i) + "원) - " +
//                        matchingNumbersMap.getOrDefault(i, 0) + "개")
//                .forEach(System.out::println);
    }

    public void noticeTotalYield(double totalYield) {
        System.out.printf("총 수익률은 %.2f%%입니다.\n", totalYield);
    }

    private void printNewLine() {
        System.out.println();
    }
}
