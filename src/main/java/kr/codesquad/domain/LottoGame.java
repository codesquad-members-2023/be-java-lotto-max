package kr.codesquad.domain;

import kr.codesquad.view.Console;

import java.util.List;
import java.util.Map;

public class LottoGame {

    private final int LOTTO_PRICE = 1000;
    private final int FOURTH_PRIZE = 5000;
    private final int THIRD_PRIZE = 50000;
    private final int SECOND_PRIZE = 1500000;
    private final int FIRST_PRIZE = 2000000000;

    private Console console;
    private Lotto lotto;
    private int money;

    public void play() {
        console = new Console();

        // 로또 구매
        money = console.inputMoney();
        buyLotto(money);
        // 당첨 번호 입력
        List<Integer> winningNumbers = console.inputWinningNumbers();
        // 당첨 결과 확인
        Map<Integer, Integer> winningResult = lotto.checkWinningResult(winningNumbers);
        analyzeWinningResult(winningResult);
    }

    public void buyLotto(int money) {
        int countOfLotto = money / LOTTO_PRICE;
        lotto = new Lotto(countOfLotto);
        console.printBuyLotto(countOfLotto, lotto.toString());
    }

    public void analyzeWinningResult(Map<Integer, Integer> winningResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("3개 일치 (" + FOURTH_PRIZE + "원) - " + winningResult.get(3) + "개\n");
        sb.append("4개 일치 (" + THIRD_PRIZE + "원) - " + winningResult.get(4) + "개\n");
        sb.append("5개 일치 (" + SECOND_PRIZE + "원) - " + winningResult.get(5) + "개\n");
        sb.append("6개 일치 (" + FIRST_PRIZE + "원) - " + winningResult.get(6) + "개\n");

        long totalPrizeMoney = FOURTH_PRIZE * winningResult.get(3) + THIRD_PRIZE * winningResult.get(4)
                + SECOND_PRIZE * winningResult.get(5) + FIRST_PRIZE * winningResult.get(6);
        sb.append("총 수익은 " + totalPrizeMoney + "원 입니다.");
        console.printWinningResult(sb.toString());
    }
}
