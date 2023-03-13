package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Winning {

	private static final int LOTTERY_MIN_NUMBER = 1;
	private static final int LOTTERY_MAX_NUMBER = 45;
	private static final int NUMBER_OF_LOTTERY_NUMBERS = 6;

	private final List<Integer> winningNumbers;

	public Winning(final String winning) {
		validate(winning);
		this.winningNumbers = convertToList(winning.split(","));
	}

	private void validate(final String winning) {
		List<Integer> winningNumbers = convertToList(winning.split(","));
		validateNumberOfLotteryNumbers(winningNumbers);
		validateNumberRange(winningNumbers);
	}

	private List<Integer> convertToList(final String[] tokens) {
		return Arrays.stream(tokens)
			.map(number -> Integer.parseInt(number.trim()))
			.sorted()
			.collect(Collectors.toUnmodifiableList());
	}

	private void validateNumberOfLotteryNumbers(final List<Integer> winningNumbers) {
		if (winningNumbers.size() != NUMBER_OF_LOTTERY_NUMBERS) {
			throw new IllegalArgumentException("[ERROR] 당첨번호의 개수는 6개여야 합니다.");
		}
	}

	private void validateNumberRange(final List<Integer> winningNumbers) {
		Optional<Integer> illegalNumber = winningNumbers.stream()
			.filter(number -> number < LOTTERY_MIN_NUMBER || number > LOTTERY_MAX_NUMBER)
			.findFirst();
		illegalNumber.ifPresent(number -> {
			throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다. 입력한 번호 : " + number);
		});
	}

	public List<Integer> getWinnings() {
		return winningNumbers.stream()
			.collect(Collectors.toUnmodifiableList());
	}
}
