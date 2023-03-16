package kr.codesquad.view.input;

import static kr.codesquad.domain.LottoConfig.*;
import static kr.codesquad.view.input.InputManagerValidator.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import kr.codesquad.domain.Ball;
import kr.codesquad.domain.Ticket;

public class InputManualLottoNumbersManager implements InputManger<Ticket> {

	public static final String SPLIT_DELIMITER = ",";

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

	@Override
	public Optional<Ticket> askClient() {
		try {
			Scanner scanner = new Scanner(System.in);
			String winningNumbersString = scanner.nextLine();
			validWiningNumbers(winningNumbersString);
			List<Ball> winningNumbers = convertWiningNumbers(winningNumbersString);
			return Optional.of(new Ticket(winningNumbers));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
