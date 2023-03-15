package kr.codesquad.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoResult {

	public static final String EARNING_RATE_RESULT_DESC = "총 수익률은 %.2f%%입니다.";
	public static final long VALUE_ZERO = 0L;
	public static final int ONE_HUNDRED = 100;
	public static final String MATCH_RESULT_DESC = "%d개 일치 (%d원) - %d개\n";
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
		statistics.append(earningRate);
		return statistics.toString();
	}

	private String calculateEarningRate() {
		Optional<Long> winningPrizeSum = matchResult.entrySet().stream()
			.map(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
			.reduce(Long::sum);
		Long sum = winningPrizeSum.orElse(VALUE_ZERO);
		float earningRate = ((float)sum - purchaseAmount) / purchaseAmount * ONE_HUNDRED;
		return String.format(EARNING_RATE_RESULT_DESC, earningRate);
	}

	private void addResult(StringBuilder statistics, Prize prize) {
		statistics.append(String.format(MATCH_RESULT_DESC,
			prize.getMatchCount(),
			prize.getPrizeMoney(),
			matchResult.getOrDefault(prize, VALUE_ZERO)));
	}
}
