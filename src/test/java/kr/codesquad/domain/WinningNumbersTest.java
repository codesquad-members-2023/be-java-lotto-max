package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

	@DisplayName("티켓의 당첨번호와 비교한다.")
	@Test
	void checkWinningNumbers() {
		List<Ball> oneToSix = IntStream.range(1, 7)
			.mapToObj(Ball::new)
			.collect(Collectors.toList());
		List<Ball> twoToSeven = IntStream.range(2, 8)
			.mapToObj(Ball::new)
			.collect(Collectors.toList());

		WinningNumbers winningNumbers = new WinningNumbers(oneToSix);
		Ticket ticketOneToSix = new Ticket(oneToSix);
		Ticket ticketTowToSeven = new Ticket(twoToSeven);

		assertThat(winningNumbers.checkWinningNumbers(ticketOneToSix,new Ball(8))).isEqualTo(Prize.FIRST);
		assertThat(winningNumbers.checkWinningNumbers(ticketTowToSeven, new Ball(20))).isEqualTo(Prize.SECOND);
		assertThat(winningNumbers.checkWinningNumbers(ticketTowToSeven, new Ball(7))).isEqualTo(Prize.BONUS);

	}
}
