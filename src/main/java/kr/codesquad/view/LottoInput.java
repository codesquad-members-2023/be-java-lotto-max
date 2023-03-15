package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInput {
    private static final int ONE_TICKET = 1000;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public LottoInput() {
    }

    public int InputLottoPurchaseMoney() throws IOException {
        System.out.println("구입 금액을 입력해 주세요.");
        // 숫자를 입력하면 예외 발생
        while (true) {
            try {
                int money = InputOnlyInt();
                isMultipleOfThousand(money);
                return money;
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해야 합니다. 다시 입력해주세요!");
            } catch (IllegalArgumentException e) {
                System.out.println("입력한 금액은 1000원 단위여야 합니다. 다시 입력해주세요!");
            }
        }
    }

    private void isMultipleOfThousand(int money) {
        if (money % ONE_TICKET != 0) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> InputWinningNumbers() throws IOException {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream(br.readLine().split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int InputBonus() throws IOException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return InputOnlyInt();
    }

    private int InputOnlyInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
