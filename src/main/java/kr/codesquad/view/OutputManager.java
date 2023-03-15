package kr.codesquad.view;

import java.util.List;

import kr.codesquad.domain.LottoResult;
import kr.codesquad.domain.Ticket;

public class OutputManager {

	public static final String QUANTITY_DESC = "개를 구매했습니다.";
	public static final String RESULT_DESC = "\n당첨 통계\n---------";

	public void printTickets(int quantity, List<Ticket> tickets) {
		System.out.println(quantity + QUANTITY_DESC);
		tickets.forEach(ticket -> System.out.println(ticket.getNumbers()));
	}

	public void printLottoResult(LottoResult lottoResult) {
		System.out.println(RESULT_DESC);
		System.out.println(lottoResult.calculateStatistics());
	}
}
