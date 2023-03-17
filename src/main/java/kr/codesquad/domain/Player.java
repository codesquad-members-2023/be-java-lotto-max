package kr.codesquad.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Player {

	private final Money purchaseAmount;
	private final List<Ticket> tickets;

	public Player(Money purchaseAmount, List<Ticket> tickets) {
		this.purchaseAmount = purchaseAmount;
		this.tickets = tickets;
	}

	public void addTickets(List<Ticket> manualTickets) {
		tickets.addAll(manualTickets);
	}

	public LottoResult checkTicket(WinningNumbers winningNumbers, Ball bonus) {
		Map<Prize, Long> matchResult = tickets.stream()
			.map(ticket -> winningNumbers.checkWinningNumbers(ticket, bonus))
			.filter(prize -> prize != Prize.NONE)
			.collect(Collectors.groupingBy(prize -> prize, Collectors.counting()));
		return new LottoResult(purchaseAmount, matchResult);
	}

	public int getTicketCount() {
		return tickets.size();
	}
}
