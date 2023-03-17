package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import kr.codesquad.dto.CorrectNumberDto;
import kr.codesquad.generator.Generator;

public class Lottery {

	private static final String DELIMITER_COMMA = ",";

	private final List<Integer> lotteryNumbers;

	public Lottery(final String lotteryNumbers) {
		validate(lotteryNumbers);
		this.lotteryNumbers = Arrays.stream(lotteryNumbers.split(DELIMITER_COMMA))
			.map(number -> Integer.parseInt(number.trim()))
			.collect(Collectors.toUnmodifiableList());
	}

	public Lottery(final Generator generator) {
		this.lotteryNumbers = generator.generateLottoNumbers();
	}

	private void validate(final String lotteryNumbers) {
		String[] numbers = lotteryNumbers.split(DELIMITER_COMMA);
		if (numbers.length != 6) {
			throw new IllegalArgumentException("[ERROR] 로또는 여섯 개의 숫자로 이루어져야 합니다.");
		}
		Arrays.stream(numbers)
			.map(String::trim)
			.mapToInt(Integer::parseInt)
			.filter(number -> number < 1 || number > 45)
			.findFirst()
			.ifPresent(number -> {
				throw new IllegalArgumentException("[ERROR] 로또의 번호는 1~45사이의 숫자여야 합니다. 입력한 번호 : " + number);
			});
	}

	public CorrectNumberDto countCorrectNumber(final List<Integer> winning, final int bonusNumber) {
		int correctCount = (int)lotteryNumbers.stream()
			.filter(winning::contains)
			.count();
		boolean isCorrectWithBonusNumber = lotteryNumbers.contains(bonusNumber);
		return new CorrectNumberDto(correctCount, isCorrectWithBonusNumber);
	}

	@Override
	public String toString() {
		StringBuilder lotteryBuilder = new StringBuilder();
		lotteryBuilder.append("[");
		lotteryNumbers
			.forEach(number -> lotteryBuilder.append(number).append(", "));
		lotteryBuilder.replace(lotteryBuilder.length() - 2, lotteryBuilder.length(), "]\n");
		return lotteryBuilder.toString();
	}
}
