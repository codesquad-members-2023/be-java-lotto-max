package kr.codesquad.view;

import java.util.List;

import kr.codesquad.domain.LottoResult;
import kr.codesquad.domain.Ticket;

public class OutputManager {
	public void printTickets(int quantity, List<Ticket> tickets) {
		System.out.println(quantity + "개를 구매했습니다.");
		tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
	}

	public void printLottoResult(LottoResult lottoResult) {
		System.out.println("\n당첨 통계\n"
			+ "---------");
		System.out.println(lottoResult.calculateStatistics());
	}
}
