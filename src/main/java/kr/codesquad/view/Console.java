package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    private final int LOTTO_MONEY = 1000;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int inputMoney() throws IOException, NumberFormatException {
        System.out.println("구입할 로또 금액을 입력해 주세요.");
        int money = 0;
        while (true) {
            try {
                money = validateInteger(br.readLine());
                if (isBuyPossible(money)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    private int validateInteger(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("금액은 숫자만 입력해 주세요.");
        }
    }

    private boolean isBuyPossible(int money) {
        if (money % LOTTO_MONEY != 0) {
            System.out.println("로또 가격에 맞게 입력해 주세요.(1장 - 1000원)");
            return false;
        }
        return true;
    }

    public void printBuyLotto(int countOfLotto, String lotto) {
        System.out.println(countOfLotto + "개를 구매했습니다.");
        System.out.println(lotto);
    }
}
