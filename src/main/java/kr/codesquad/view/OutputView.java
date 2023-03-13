package kr.codesquad.view;

import java.util.List;

public class OutputView {
    public OutputView() {
    }

    public void outputRequestLottoPurchaseMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void outputLottoAmountNumber(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public void outputLotto(List<List<Integer>> lottoLists) {
        lottoLists.forEach(System.out::println);
        printNewLine();
    }

    public void outputRequestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void printNewLine() {
        System.out.println();
    }
}
