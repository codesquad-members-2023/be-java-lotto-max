package kr.codesquad.view;

import kr.codesquad.domain.Winning;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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

    public void noticeMatchingFormat(Map<Integer, Integer> matchingNumbersMap) {
        IntStream.rangeClosed(3, 6)
                .mapToObj(i -> i + "개 일치 (" + Winning.getMoney(i) + "원) - " +
                        matchingNumbersMap.getOrDefault(i, 0) + "개")
                .forEach(System.out::println);
    }

    public void noticeTotalYield(double totalYield) {
        System.out.printf("총 수익률은 %.2f%%입니다.", totalYield);
    }

    private void printNewLine() {
        System.out.println();
    }
}
