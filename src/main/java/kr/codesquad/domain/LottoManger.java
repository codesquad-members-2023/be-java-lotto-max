package kr.codesquad.domain;

import java.util.List;

public class LottoManger {
	public List<Ticket> generateTickets(int quantity) {
		LottoMachine lottoMachine = new LottoMachine();
		return lottoMachine.generateTicket(quantity);
	}
}
