package kr.codesquad.domain;

import kr.codesquad.view.Console;

import java.io.IOException;

public class LottoGame {

    private Console console;

    public void run() {
        console = new Console();
        try {
            int money = console.inputMoney();
            System.out.println(money);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
