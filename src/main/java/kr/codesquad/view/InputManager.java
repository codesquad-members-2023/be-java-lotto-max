package kr.codesquad.view;

import static kr.codesquad.domain.BallConfig.*;
import static kr.codesquad.view.InputManagerValidator.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import kr.codesquad.domain.Ball;
import kr.codesquad.domain.WinningNumbers;

public class InputManager {

	public static final String ASK_WINNING_NUMBERS_DESC = "당첨 번호를 입력해 주세요.";
	public static final String SPLIT_DELIMITER = ",";
	public static final String ASK_BONUS_BALL_DESC = "보너스 볼을 입력해 주세요.";
	private final Scanner scanner;

	public InputManager() {
		this.scanner = new Scanner(System.in);
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
}
