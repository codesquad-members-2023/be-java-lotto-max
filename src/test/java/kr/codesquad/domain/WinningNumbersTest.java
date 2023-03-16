package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

		assertThat(winningNumbers.checkWinningNumbers(ticketOneToSix, new Ball(8))).isEqualTo(Prize.FIRST);
		assertThat(winningNumbers.checkWinningNumbers(ticketTowToSeven, new Ball(20))).isEqualTo(Prize.SECOND);
		assertThat(winningNumbers.checkWinningNumbers(ticketTowToSeven, new Ball(7))).isEqualTo(Prize.BONUS);

	}

	@DisplayName("볼을 포항 여부 체크")
	@ParameterizedTest
	@CsvSource(value = {"6,true", "7,false", "1,true"})
	void containsNumber(int ballNumber, Boolean expect) {
		List<Ball> oneToSix = IntStream.range(1, 7)
			.mapToObj(Ball::new)
			.collect(Collectors.toList());

		WinningNumbers winningNumbers = new WinningNumbers(oneToSix);

		assertThat(winningNumbers.containsBallNumber(ballNumber)).isEqualTo(expect);
		assertThat(winningNumbers.containsBallNumber(new Ball(ballNumber))).isEqualTo(expect);
	}



	@DisplayName("WinningNumbers 생성시 중복번호와 번호 수량을 체크한다.")
	@ParameterizedTest
	@ValueSource(ints = {6, 8})
	void createTicket(int range) {
		List<Ball> balls = IntStream.range(1, range)
			.mapToObj(Ball::new)
			.collect(Collectors.toList());
		assertThatThrownBy(() -> new WinningNumbers(balls))
			.isInstanceOf(IllegalArgumentException.class);
		List<Ball> duplicateBalls = IntStream.range(1, 6)
			.mapToObj(Ball::new)
			.collect(Collectors.toList());
		duplicateBalls.add(new Ball(1));
		assertThatThrownBy(() -> new WinningNumbers(duplicateBalls))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
