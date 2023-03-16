package kr.codesquad.view.input;

import static kr.codesquad.domain.BallConfig.*;
import static kr.codesquad.view.input.InputManagerValidator.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import kr.codesquad.domain.Ball;
import kr.codesquad.domain.WinningNumbers;

public class InputWiningNumbersManager implements InputManger<WinningNumbers> {

	public static final String ASK_WINNING_NUMBERS_DESC = "지난 주 당첨 번호를 입력해 주세요.";
	public static final String SPLIT_DELIMITER = ",";

	@Override
	public Optional<WinningNumbers> askClient() {
		try {
			Scanner scanner = new Scanner(System.in);
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

}
