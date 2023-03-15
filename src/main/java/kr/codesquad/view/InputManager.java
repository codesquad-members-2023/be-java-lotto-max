package kr.codesquad.view;

import static kr.codesquad.domain.BallConfig.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import kr.codesquad.domain.LottoBalls;

public class InputManager {

	public static final String ASK_PURCHASE_AMOUNT_DESC = "구입금액을 입력해 주세요.";
	public static final String ASK_WINNING_NUMBERS_DESC = "당첨 번호를 입력해 주세요.";
	public static final String DIGIT_PATTERN_ERROR_MESSAGE = "숫자가 아닙니다";
	public static final String WINNING_NUMBERS_PATTERN_ERROR_MESSAGE = "당첨 번호 패턴에 매치되지 않습니다";
	public static final String WINNING_NUMBERS_DUPLICATE_OR_RANGE_ERROR_MESSAGE = "중복된 번호 혹은 범위를 초과한 번호가 있습니다.";
	public static final String UNIT_ERROR_MESSAGE = TICKET_PRICE + "원 단위로 입력해 해주세요";
	public static final String DIGIT_PATTERN = "[1-9][0-9]*";
	public static final String LOTTO_NUMBERS_PATTERN = "^[1-4]*[0-9](,[1-4]*[0-9]){5}$";
	private final Scanner scanner;

	public InputManager() {
		this.scanner = new Scanner(System.in);
	}

	public int askPurchaseAmount() {
		System.out.println(ASK_PURCHASE_AMOUNT_DESC);
		String purchaseAmountInput = scanner.nextLine();
		validPurchaseAmount(purchaseAmountInput);
		return Integer.parseInt(purchaseAmountInput);
	}

	private void validPurchaseAmount(String purchaseAmountInput) {
		if (!purchaseAmountInput.matches(DIGIT_PATTERN)) {
			throw new IllegalArgumentException(DIGIT_PATTERN_ERROR_MESSAGE);
		}
		if (Integer.parseInt(purchaseAmountInput) % TICKET_PRICE != 0) {
			throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
		}
	}

	public List<Integer> askWiningNumbers() {
		System.out.println(ASK_WINNING_NUMBERS_DESC);
		String winningNumbersString = scanner.nextLine();
		validWiningNumbers(winningNumbersString);
		return convertWiningNumbers(winningNumbersString);
	}

	private void validWiningNumbers(String winningNumbersString) {
		if (!winningNumbersString.matches(LOTTO_NUMBERS_PATTERN)) {
			throw new IllegalArgumentException(WINNING_NUMBERS_PATTERN_ERROR_MESSAGE);
		}
		List<Integer> winingNumbers = convertWiningNumbers(winningNumbersString);
		if (winingNumbers.size() != LottoBalls.LOTTO_NUMBERS_LENGTH) {
			throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATE_OR_RANGE_ERROR_MESSAGE);
		}
	}

	static List<Integer> convertWiningNumbers(String winningNumbersString) {
		String[] numbers = winningNumbersString.split(",");
		return Arrays.stream(numbers)
			.map(Integer::parseInt)
			.filter(number -> number >= MIN_BALL_NUMBER && number <= MAX_BALL_NUMBER)
			.distinct()
			.collect(Collectors.toList());
	}
}
