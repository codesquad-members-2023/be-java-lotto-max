package kr.codesquad.domain;

import java.util.List;

public class Player {

	private final int purchaseAmount;
	private final List<Ticket> tickets;
	public Player(int purchaseAmount, List<Ticket> tickets) {
		this.purchaseAmount = purchaseAmount;
		this.tickets = tickets;
	}

}
