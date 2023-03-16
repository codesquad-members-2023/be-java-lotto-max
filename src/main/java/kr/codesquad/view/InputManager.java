package kr.codesquad.view;

import static kr.codesquad.view.InputManagerValidator.*;

import java.util.Optional;
import java.util.Scanner;

import kr.codesquad.domain.Ball;
import kr.codesquad.domain.WinningNumbers;

public class InputManager {

	public static final String ASK_BONUS_BALL_DESC = "보너스 볼을 입력해 주세요.";
	private final Scanner scanner;

	public InputManager() {
		this.scanner = new Scanner(System.in);
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
