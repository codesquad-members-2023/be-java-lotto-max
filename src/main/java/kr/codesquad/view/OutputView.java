package kr.codesquad.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public OutputView() {
    }

    public void requestLottoPurchaseMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void noticeLottoAmountNumber(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public void printLotto(List<List<Integer>> lottoLists) {
        lottoLists.forEach(System.out::println);
        printNewLine();
    }

    public void requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printFrameOfStatistics() {
        printNewLine();
        System.out.println("당첨 통계\n---------");
    }

    public void noticeMatchingFormat(Map<Integer, Integer> MatchingNumbersMap) {
        System.out.println("3개 일치 (5000원) - " + MatchingNumbersMap.get(3) + "개");
        System.out.println("4개 일치 (50000원) - " + MatchingNumbersMap.get(4) + "개");
        System.out.println("5개 일치 (1500000원) - " + MatchingNumbersMap.get(5) + "개");
        System.out.println("6개 일치 (2000000000원) - " + MatchingNumbersMap.get(6) + "개");
    }

    private void printNewLine() {
        System.out.println();
    }
}
