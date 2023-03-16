package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void addTickets() {
		Player player = new Player(new Money(1000), new ArrayList<>());
		Ticket ticket = new Ticket(IntStream.range(1, 7)
			.mapToObj(Ball::new)
			.collect(Collectors.toList()));
		Assertions.assertThat(player.getTicketCount()).isEqualTo(0);
		player.addTickets(List.of(ticket));
		Assertions.assertThat(player.getTicketCount()).isEqualTo(1);
		player.addTickets(List.of(ticket, ticket));
		Assertions.assertThat(player.getTicketCount()).isEqualTo(3);
	}

	@Test
	void checkTicket() {
		Ticket ticket = new Ticket(IntStream.range(1, 7)
			.mapToObj(Ball::new)
			.collect(Collectors.toList()));
		WinningNumbers winningNumbers = new WinningNumbers(IntStream.range(1, 7)
			.mapToObj(Ball::new)
			.collect(Collectors.toList()));
		Player player = new Player(new Money(1000), List.of(ticket));
		LottoResult lottoResult = player.checkTicket(winningNumbers, new Ball(8));
		Assertions.assertThat(lottoResult.calculateStatistics())
			.isEqualTo("3개 일치 (5000원) - 0개\n"
				+ "4개 일치 (50000원) - 0개\n"
				+ "5개 일치 (1500000원) - 0개\n"
				+ "5개 일치,보너스 볼 일치 (30000000원) - 0개\n"
				+ "6개 일치 (2000000000원) - 1개\n"
				+ "총 수익률은 199999904.00%입니다.");
	}
}
