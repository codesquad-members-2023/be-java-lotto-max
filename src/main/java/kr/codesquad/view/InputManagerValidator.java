package kr.codesquad.view;

import static kr.codesquad.domain.BallConfig.*;

import java.util.regex.Pattern;

import kr.codesquad.domain.LottoBalls;
import kr.codesquad.domain.WinningNumbers;

public class InputManagerValidator {

	public static final String DIGIT_PATTERN_ERROR_MESSAGE = "숫자를 입력 해주세요.";
	public static final String WINNING_NUMBERS_PATTERN_ERROR_MESSAGE = "당첨 번호 패턴에 매치되지 않습니다";
	public static final String WINNING_NUMBERS_DUPLICATE_OR_RANGE_ERROR_MESSAGE = "중복된 번호 혹은 범위를 초과한 번호가 있습니다.";
	public static final String UNIT_ERROR_MESSAGE = TICKET_PRICE + "원 단위로 입력해 해주세요";
	public static final String DIGIT_PATTERN = "[1-9][0-9]*";
	public static final String LOTTO_NUMBERS_PATTERN = "^[1-4]*[0-9](,[1-4]*[0-9]){5}$";
	public static final int ZERO = 0;

	private InputManagerValidator() {
	}

	public static void validIsDuplication(WinningNumbers winningNumbers, int bonusNumber) {
		if (winningNumbers.containsBallNumber(bonusNumber)) {
			throw new IllegalArgumentException("이미 포함된 로또 넘버입니다.");
		}
	}

	public static void validIsDigit(String bonusBallString) {
		if (!Pattern.matches(DIGIT_PATTERN, bonusBallString)) {
			throw new IllegalArgumentException(DIGIT_PATTERN_ERROR_MESSAGE);
		}
	}

	public static void validWinningNumbersSize(int length) {
		if (length != LottoBalls.LOTTO_NUMBERS_LENGTH) {
			throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATE_OR_RANGE_ERROR_MESSAGE);
		}
	}

	public static void validWiningNumbers(String winningNumbersString) {
		if (!winningNumbersString.matches(LOTTO_NUMBERS_PATTERN)) {
			throw new IllegalArgumentException(WINNING_NUMBERS_PATTERN_ERROR_MESSAGE);
		}
	}

	public static void validPurchaseAmount(String purchaseAmountInput) {
		validIsDigit(purchaseAmountInput);
		if (Integer.parseInt(purchaseAmountInput) % TICKET_PRICE != ZERO) {
			throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
		}
	}

	public static void validInRange(int quantity, int count) {
		if (count > quantity) {
			throw new IllegalArgumentException(quantity + "개를 초과할수 없습니다.");
		}
		if (count < 0) {
			throw new IllegalArgumentException("0이상이여야 합니다.(0포함)");
		}
	}
}
