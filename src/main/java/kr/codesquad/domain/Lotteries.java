package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import kr.codesquad.generator.LotteryNumberGenerator;

public class Lotteries {

	private final List<Lottery> lotteries;

	public Lotteries(final LotteryNumberGenerator generator, int countOfLottery) {
		this.lotteries = IntStream.range(0, countOfLottery)
			.mapToObj(cnt -> new Lottery(generator))
			.collect(Collectors.toUnmodifiableList());
	}

	@Override
	public String toString() {
		StringBuilder lotteriesBuilder = new StringBuilder();
		lotteries
			.forEach(lotteriesBuilder::append);

		return lotteriesBuilder.toString();
	}
}
