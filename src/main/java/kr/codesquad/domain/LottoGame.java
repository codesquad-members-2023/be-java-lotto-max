package kr.codesquad.domain;

import kr.codesquad.view.Console;

import java.util.List;

public class LottoGame {

    private final int LOTTO_PRICE = 1000;
    private Console console;

    public void play() {
        console = new Console();

        int money = console.inputMoney();
        buyLotto(money);

        List<Integer> winningNumbers = console.inputWinningNumbers();
    }

    public void buyLotto(int money) {
        int countOfLotto = money / LOTTO_PRICE;
        Lotto lotto = new Lotto(countOfLotto);
        console.printBuyLotto(countOfLotto, lotto.toString());
    }
}
