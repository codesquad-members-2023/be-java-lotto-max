package kr.codesquad.generator;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class LotteryNumberGenerator implements Generator {

	private static final Random RANDOM = new Random();
	private static final int LOTTERY_MAX_NUMBER = 45;
	private static final int NUMBER_OF_LOTTERY_NUMBERS = 6;

	@Override
	public List<Integer> generateLottoNumbers() {
		Set<Integer> numbers = new HashSet<>();

		while (numbers.size() != NUMBER_OF_LOTTERY_NUMBERS) {
			numbers.add(RANDOM.nextInt(LOTTERY_MAX_NUMBER) + 1);
		}

		return numbers.stream()
			.sorted()
			.collect(Collectors.toUnmodifiableList());
	}
}
