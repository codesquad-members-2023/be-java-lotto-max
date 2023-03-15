package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInput {
    private static final int ONE_TICKET_PRICE = 1000;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public LottoInput() {
    }

    public int InputLottoPurchaseMoney() throws IOException {
        System.out.println("구입 금액을 입력해 주세요.");

        while (true) {
            try {
                int money = inputOnlyInt();
                checkMultipleOfThousand(money);
                return money;

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해야 합니다. 다시 입력해주세요!");

            } catch (IllegalArgumentException e) {
                System.out.println("입력한 금액은 1000원 단위여야 합니다. 다시 입력해주세요!");
            }
        }
    }

    private void checkMultipleOfThousand(int money) {
        if (money % ONE_TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> inputWinningNumbers() throws IOException {
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> winningNumbers = inputNumbers();
        while (!isWinningNumbers(winningNumbers)) {
            System.out.println("1부터 45까지의 총 6개의 번호를 입력해야 합니다. 다시 입력해주세요!");
            winningNumbers = inputNumbers();
        }

        return winningNumbers;
    }

    private List<Integer> inputNumbers() throws IOException {
        try {
            return Arrays.stream(br.readLine().split("\\s*,\\s*"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해야 합니다. 다시 입력해주세요!");
            return inputNumbers();

        }
    }

    private boolean isWinningNumbers(List<Integer> numbers) {
        return numbers.size() == 6 && numbers.stream().allMatch(n -> n >= 1 && n <= 45);
    }

    public int inputBonus() throws IOException {
        System.out.println("보너스 볼을 입력해 주세요.");

        int bonus = inputOnlyInt();
        while (!isBonusNumber(bonus)) {
            System.out.println("1부터 45까지의 1개의 번호를 입력해야 합니다. 다시 입력해주세요!");
            bonus = inputOnlyInt();
        }

        return bonus;
    }

    private boolean isBonusNumber(int bonus) {
        return bonus >= 1 && bonus <= 45;
    }

    private int inputOnlyInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
