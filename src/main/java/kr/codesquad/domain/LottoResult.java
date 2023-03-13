package kr.codesquad.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoResult {

	private final Map<Prize, Long> matchResult;
	private final int purchaseAmount;

	private LottoResult(int purchaseAmount, Map<Prize, Long> matchResult) {
		this.matchResult = matchResult;
		this.purchaseAmount = purchaseAmount;
	}

	public static LottoResult create(int purchaseAmount, List<Ticket> tickets, WinningNumbers winningNumbers) {
		Map<Prize, Long> matchResult = tickets.stream()
			.map(winningNumbers::checkWinningNumbers)
			.filter(prize -> prize != Prize.NONE)
			.collect(Collectors.groupingBy(prize -> prize, Collectors.counting()));
		return new LottoResult(purchaseAmount, matchResult);
	}

	public String calculateStatistics() {
		StringBuilder statistics = new StringBuilder();
		List<Prize> validPrizes = Prize.getWinningPrize();
		validPrizes.forEach(prize -> addResult(statistics, prize));
		String earningRate = calculateEarningRate();
		statistics.append("총 수익률은 ")
			.append(earningRate)
			.append("%입니다.");
		return statistics.toString();
	}

	private String calculateEarningRate() {
		Optional<Long> winningPrizeSum = matchResult.entrySet().stream()
			.map(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
			.reduce(Long::sum);
		Long sum = winningPrizeSum.orElse(0L);
		float earningRate = ((float)sum - purchaseAmount) / purchaseAmount * 100;
		return String.format("%.2f", earningRate);
	}

	private void addResult(StringBuilder statistics, Prize prize) {
		Long fourth = matchResult.getOrDefault(prize, 0L);
		statistics.append(prize.getMatchCount())
			.append("개 일치 (")
			.append(prize.getPrizeMoney())
			.append("원) - ")
			.append(fourth)
			.append("개\n");

	}
}
