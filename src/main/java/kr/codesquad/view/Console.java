package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Console {
    private final int LOTTO_PRICE = 1000;
    private final int LOTTO_LENGTH = 6;

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int inputMoney() {
        System.out.println("구입할 로또 금액을 입력해 주세요.");
        int money = 0;
        while (true) {
            try {
                money = validateInteger(br.readLine());
                if (isBuyPossible(money)) {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        while (true) {
            try {
                return makeIntegerList(br.readLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printBuyLotto(int countOfLotto, String lotto) {
        System.out.println(countOfLotto + "개를 구매했습니다.");
        System.out.println(lotto);
    }

    private int validateInteger(String inputData) {
        try {
            return Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력해 주세요.");
        }
    }

    private boolean isBuyPossible(int money) {
        if (money % LOTTO_PRICE != 0) {
            System.out.println("로또 가격에 맞게 입력해 주세요.(1장 - 1000원)");
            return false;
        }
        return true;
    }

    private List<Integer> makeIntegerList(String inputData) {
        inputData = inputData.replace(" ", "");
        String[] splitData = inputData.split(",");

        List<Integer> integerList = new ArrayList<>();
        for (String data : splitData) {
            integerList.add(validateInteger(data));
        }
        if (integerList.size() != LOTTO_LENGTH) {
            throw new RuntimeException(LOTTO_LENGTH + "개의 당첨번호를 입력해주세요.");
        }
        return integerList;
    }
}
