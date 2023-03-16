package kr.codesquad.domain;

import java.util.List;

public class LottoManger {

	public List<Ticket> generateTickets(int quantity) {
		LottoMachine lottoMachine = new LottoMachine();
		return lottoMachine.generateTicket(quantity);
	}

	public LottoResult checkPlayerTickets(Player player, WinningNumbers winningNumbers, Ball bonus) {
		List<Ticket> tickets = player.getTickets();
		Money purchaseAmount = player.getPurchaseAmount();
		return LottoResult.create(purchaseAmount,tickets, winningNumbers,bonus);
	}
}
