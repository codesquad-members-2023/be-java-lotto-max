package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import kr.codesquad.generator.Generator;

public class Lotteries {

	private final List<Lottery> lotteries;

	public Lotteries(final Generator generator, List<String> manualLotteries, int countOfLottery) {
		this.lotteries = manualLotteries.stream()
			.map(Lottery::new)
			.collect(Collectors.toList());
		this.lotteries.addAll(IntStream.range(0, countOfLottery)
			.mapToObj(cnt -> new Lottery(generator))
			.collect(Collectors.toUnmodifiableList()));
	}

	public List<Result> getResults(final List<Integer> winning, final int bonusNumber) {
		return lotteries.stream()
			.map(lottery -> lottery.countCorrectNumber(winning, bonusNumber))
			.map(dto -> Result.getResult(dto.getCorrectCount(), dto.isCorrectWithBonusNumber()))
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
