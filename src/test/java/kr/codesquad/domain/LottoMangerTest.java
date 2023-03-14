package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMangerTest {

	@DisplayName("수량만큼 티켓을 생성한다.")
	@ParameterizedTest
	@ValueSource(ints = {3, 10, 25, 36})
	void generateTickets(int quantity) {
		LottoManger lottoManger = new LottoManger();
		List<Ticket> tickets = lottoManger.generateTickets(quantity);
		assertThat(tickets.size()).isEqualTo(quantity);
	}

}
