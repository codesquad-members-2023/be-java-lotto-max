package kr.codesquad.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

	@DisplayName("돈의 구입하려고 하는 수량을 return한다")
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 5, 6})
	void getQuantity(int count) {
		Money money = new Money(count * LottoConfig.TICKET_PRICE);
		Assertions.assertThat(money.getQuantity()).isEqualTo(count);
	}

}
