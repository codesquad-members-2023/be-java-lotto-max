package kr.codesquad.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoResult {

	public static final long VALUE_ZERO = 0L;

	public static final String MATCH_RESULT_DESC = "%d개 일치 (%d원) - %d개\n";
	private static final String BONUS_MATCH_RESULT_DESC = "%d개 일치,보너스 볼 일치 (%d원) - %d개\n";
	private final Map<Prize, Long> matchResult;
	private final Money purchaseAmount;

	LottoResult(Money purchaseAmount, Map<Prize, Long> matchResult) {
		this.matchResult = matchResult;
		this.purchaseAmount = purchaseAmount;
	}

	public static LottoResult create(Money purchaseAmount, List<Ticket> tickets, WinningNumbers winningNumbers,
		Ball bonus) {
		Map<Prize, Long> matchResult = tickets.stream()
			.map(ticket -> winningNumbers.checkWinningNumbers(ticket, bonus))
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
		return purchaseAmount.getEarningRate(sum);
	}

	private void addResult(StringBuilder statistics, Prize prize) {
		statistics.append(String.format(getFormat(prize),
			prize.getMatchCount(),
			prize.getPrizeMoney(),
			matchResult.getOrDefault(prize, VALUE_ZERO)));
	}

	private String getFormat(Prize prize) {
		if (prize == Prize.BONUS) {
			return BONUS_MATCH_RESULT_DESC;
		}
		return MATCH_RESULT_DESC;
	}
}
