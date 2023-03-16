package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

	@DisplayName("수량만큼 티켓을 생성한다")
	@ParameterizedTest
	@ValueSource(ints = {10, 20, 30})
	void generateTicket(int quantity) {
		LottoMachine lottoMachine = new LottoMachine();
		List<Ticket> tickets = lottoMachine.generateTickets(quantity);
		assertThat(tickets.size()).isEqualTo(quantity);
	}
}
