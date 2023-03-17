package kr.codesquad.domain;

import kr.codesquad.view.Console;

import java.util.List;
import java.util.Map;

public class LottoGame {

    private final int LOTTO_PRICE = 1000;

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
        long totalPrizeMoney = 0;

        for (Prize prize : Prize.values()) {
            int countOfMatch = prize.getCountOfMatch();
            int prizeMoney = prize.getPrizeMoney();

            int winningCount = winningResult.get(countOfMatch);
            totalPrizeMoney += prizeMoney * winningCount;

            sb.append(countOfMatch + "개 일치 (" + prizeMoney + "원) - " + winningCount + "개\n");
        }

        double prizeMoneyRate = (double) (totalPrizeMoney - money) / money * 100;
        sb.append("총 수익률은 " + String.format("%.2f", prizeMoneyRate) + "% 입니다.");
        console.printWinningResult(sb.toString());
    }
}
