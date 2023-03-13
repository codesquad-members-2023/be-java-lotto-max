package kr.codesquad.domain;

import java.util.List;

import kr.codesquad.generator.LotteryNumberGenerator;

public class Lottery {

	private final List<Integer> lotteryNumbers;

	public Lottery(final LotteryNumberGenerator generator) {
		this.lotteryNumbers = generator.generateLottoNumbers();
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
