package kr.codesquad.view;

import java.util.Scanner;
import kr.codesquad.message.ErrorMessage;
import kr.codesquad.model.Money;

/*
 * 사용자 입력을 담당하는 클래스
 */
public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Lotto 구입 금액을 입력받는 메서드
     * @return Money
     */
    public static Money readMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return new Money(readInt());
    }

    /**
     * 정수를 입력받는 메서드
     */
    private static int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE.toString());
        }
    }

    /**
     * 문자열을 입력받는 메서드
     */
    private static String readLine() {
        String input = scanner.nextLine().trim();
        InputValidator.validateHasInput(input);
        return input;
    }
}
