package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;

public final class Player {

	private final int purchaseAmount;
	private final List<Ticket> tickets;
	public Player(int purchaseAmount, List<Ticket> tickets) {
		this.purchaseAmount = purchaseAmount;
		this.tickets = tickets;
	}

	public List<Ticket> getTickets() {
		return tickets.stream().collect(Collectors.toUnmodifiableList());
	}

	public int getPurchaseAmount() {
		return purchaseAmount;
	}
}
