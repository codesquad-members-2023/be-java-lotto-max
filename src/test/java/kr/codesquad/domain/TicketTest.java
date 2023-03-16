package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TicketTest {

	@DisplayName("Ticket의 getNumers로 티켓의 로또 번호를 문자로 받는다.")
	@Test
	void getNumbers() {
		List<Ball> balls = IntStream.range(1, 7)
			.mapToObj(Ball::new)
			.collect(Collectors.toList());
		Ticket ticket = new Ticket(balls);
		assertThat(ticket.getNumbers())
			.isEqualTo(balls.toString());
	}

	@DisplayName("Ticket 생성시 중복번호와 번호 수량을 체크한다.")
	@ParameterizedTest
	@ValueSource(ints = {6, 8})
	void createTicket(int range) {
		List<Ball> balls = IntStream.range(1, range)
			.mapToObj(Ball::new)
			.collect(Collectors.toList());
		assertThatThrownBy(() -> new Ticket(balls))
			.isInstanceOf(IllegalArgumentException.class);
		List<Ball> duplicateBalls = IntStream.range(1, 6)
			.mapToObj(Ball::new)
			.collect(Collectors.toList());
		duplicateBalls.add(new Ball(1));
		assertThatThrownBy(() -> new Ticket(duplicateBalls))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
