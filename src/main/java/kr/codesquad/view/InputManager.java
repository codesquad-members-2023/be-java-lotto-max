package kr.codesquad.view;

import static kr.codesquad.domain.BallConfig.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import kr.codesquad.domain.Ball;
import kr.codesquad.domain.LottoBalls;
import kr.codesquad.domain.Money;
import kr.codesquad.domain.WinningNumbers;

public class InputManager {

	public static final String ASK_PURCHASE_AMOUNT_DESC = "구입금액을 입력해 주세요.";
	public static final String ASK_WINNING_NUMBERS_DESC = "당첨 번호를 입력해 주세요.";
	public static final String DIGIT_PATTERN_ERROR_MESSAGE = "숫자를 입력 해주세요.";
	public static final String WINNING_NUMBERS_PATTERN_ERROR_MESSAGE = "당첨 번호 패턴에 매치되지 않습니다";
	public static final String WINNING_NUMBERS_DUPLICATE_OR_RANGE_ERROR_MESSAGE = "중복된 번호 혹은 범위를 초과한 번호가 있습니다.";
	public static final String UNIT_ERROR_MESSAGE = TICKET_PRICE + "원 단위로 입력해 해주세요";
	public static final String DIGIT_PATTERN = "[1-9][0-9]*";
	public static final String LOTTO_NUMBERS_PATTERN = "^[1-4]*[0-9](,[1-4]*[0-9]){5}$";
	public static final int ZERO = 0;
	public static final String SPLIT_DELIMITER = ",";
	public static final String ASK_BONUS_BALL_DESC = "보너스 볼을 입력해 주세요.";
	private final Scanner scanner;

	public InputManager() {
		this.scanner = new Scanner(System.in);
	}

	public Optional<Money> askPurchaseAmount() {
		try {
			System.out.println(ASK_PURCHASE_AMOUNT_DESC);
			String purchaseAmountInput = scanner.nextLine();
			validPurchaseAmount(purchaseAmountInput);
			return Optional.of(new Money(Integer.parseInt(purchaseAmountInput)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	private void validPurchaseAmount(String purchaseAmountInput) {
		validIsDigit(purchaseAmountInput);
		if (Integer.parseInt(purchaseAmountInput) % TICKET_PRICE != ZERO) {
			throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
		}
	}

	public Optional<WinningNumbers> askWiningNumbers() {
		try {
			System.out.println(ASK_WINNING_NUMBERS_DESC);
			String winningNumbersString = scanner.nextLine();
			validWiningNumbers(winningNumbersString);
			List<Ball> winningNumbers = convertWiningNumbers(winningNumbersString);
			return Optional.of(new WinningNumbers(winningNumbers));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	private void validWiningNumbers(String winningNumbersString) {
		if (!winningNumbersString.matches(LOTTO_NUMBERS_PATTERN)) {
			throw new IllegalArgumentException(WINNING_NUMBERS_PATTERN_ERROR_MESSAGE);
		}
	}

	static List<Ball> convertWiningNumbers(String winningNumbersString) {
		String[] numbers = winningNumbersString.split(SPLIT_DELIMITER);
		validWinningNumbersSize(numbers.length);
		return Arrays.stream(numbers)
			.map(Integer::parseInt)
			.filter(number -> number >= MIN_BALL_NUMBER && number <= MAX_BALL_NUMBER)
			.distinct()
			.map(Ball::new)
			.collect(Collectors.toList());
	}

	private static void validWinningNumbersSize(int length) {
		if (length != LottoBalls.LOTTO_NUMBERS_LENGTH) {
			throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATE_OR_RANGE_ERROR_MESSAGE);
		}
	}

	public Optional<Ball> askBonusBall(WinningNumbers winningNumbers) {
		try {
			System.out.println(ASK_BONUS_BALL_DESC);
			String bonusBallString = scanner.nextLine();
			int bonusNumber = convertBonusNumber(winningNumbers, bonusBallString);
			return Optional.of(new Ball(bonusNumber));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	private int convertBonusNumber(WinningNumbers winningNumbers, String bonusBallString) {
		validIsDigit(bonusBallString);
		int bonusNumber = Integer.parseInt(bonusBallString);
		validIsDuplication(winningNumbers, bonusNumber);
		return bonusNumber;
	}

	private void validIsDuplication(WinningNumbers winningNumbers, int bonusNumber) {
		if (winningNumbers.containsBallNumber(bonusNumber)) {
			throw new IllegalArgumentException("이미 포함된 로또 넘버입니다.");
		}
	}

	private void validIsDigit(String bonusBallString) {
		if (!Pattern.matches(DIGIT_PATTERN, bonusBallString)) {
			throw new IllegalArgumentException(DIGIT_PATTERN_ERROR_MESSAGE);
		}
	}
}
