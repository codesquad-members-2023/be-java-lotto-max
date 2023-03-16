package kr.codesquad.view;

import static kr.codesquad.view.InputManagerValidator.*;

import java.util.Optional;
import java.util.Scanner;

import kr.codesquad.domain.Ball;
import kr.codesquad.domain.WinningNumbers;

public class InputBonusBallManger {

	public static final String ASK_BONUS_BALL_DESC = "보너스 볼을 입력해 주세요.";

	public Optional<Ball> askClient(WinningNumbers winningNumbers) {
		try {
			String bonusBallString = getString();
			validIsDigit(bonusBallString);
			int bonusBallNumber = Integer.parseInt(bonusBallString);
			validIsDuplication(winningNumbers, bonusBallNumber);
			return Optional.of(new Ball(bonusBallNumber));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	private static String getString() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(ASK_BONUS_BALL_DESC);
		return scanner.nextLine();
	}
}
