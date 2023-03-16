package kr.codesquad.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {
    private static final int ONE_TICKET_PRICE = 1000;

    public int validateInputLottoPurchaseMoney(BufferedReader br) throws IOException {
        while (true) {
            try {
                int money = Integer.parseInt(br.readLine());
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

    public List<Integer> validateInputWinningNumbers(BufferedReader br) throws IOException {
        List<Integer> winningNumbers = inputNumbers(br);
        while (!isWinningNumbers(winningNumbers)) {
            System.out.println("1부터 45까지의 총 6개의 번호를 입력해야 합니다. 다시 입력해주세요!");
            winningNumbers = inputNumbers(br);
        }

        return winningNumbers;
    }

    private List<Integer> inputNumbers(BufferedReader br) throws IOException {
        while (true) {
            try {
                return Arrays.stream(br.readLine().split("\\s*,\\s*"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해야 합니다. 다시 입력해주세요!");
            }
        }
    }

    private boolean isWinningNumbers(List<Integer> numbers) {
        return numbers.size() == 6 && numbers.stream().allMatch(n -> n >= 1 && n <= 45);
    }

    public int validateInputBonus(BufferedReader br) throws IOException {
        int bonus;
        while (true) {
            try {
                bonus = Integer.parseInt(br.readLine());
                if (isBonusNumber(bonus)) {
                    break;
                }

            } catch (NumberFormatException e) {
                // 입력값이 정수가 아닐 경우 무시

            }

            System.out.println("1부터 45까지의 1개의 번호를 입력해야 합니다. 다시 입력해주세요!");
        }

        return bonus;
    }

    private boolean isBonusNumber(int bonus) {
        return bonus >= 1 && bonus <= 45;
    }
}