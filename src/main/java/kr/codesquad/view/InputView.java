package kr.codesquad.view;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kr.codesquad.message.ErrorMessage;
import kr.codesquad.model.Lotto;
import kr.codesquad.model.Money;

/*
 * 사용자 입력을 담당하는 클래스
 */
public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String NUMBER_DELIMITER_KR = "쉼표";
    public static final String NUMBER_DELIMITER = ",";

    /**
     * Lotto 구입 금액을 입력받는 메서드
     * @return Money
     */
    public static Money readMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return new Money(readInt());
    }

    /**
     * 당첨 번호를 입력받는 메서드
     * @return Lotto
     */
    public static Lotto readWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        InputValidator.validateSeparatedByDelimiter(input, NUMBER_DELIMITER);
        return new Lotto(Stream.of(input.split("\\s*" + NUMBER_DELIMITER + "\\s*"))
                .map(Integer::parseInt)
                .collect(Collectors.toList())
        );
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
