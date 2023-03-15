package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import kr.codesquad.dto.CorrectNumberDto;
import kr.codesquad.generator.Generator;

public class Lottery {

	private final List<Integer> lotteryNumbers;

	public Lottery(final String lotteryNumbers) {
		this.lotteryNumbers = Arrays.stream(lotteryNumbers.split(","))
			.map(number -> Integer.parseInt(number.trim()))
			.collect(Collectors.toUnmodifiableList());
	}

	public Lottery(final Generator generator) {
		this.lotteryNumbers = generator.generateLottoNumbers();
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
