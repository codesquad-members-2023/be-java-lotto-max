package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

	@DisplayName("구매금액을 나타내는 문자열이 주어졌을 때 정상적으로 PurchaseAmount 객체를 만드는지 확인한다.")
	@Test
	void givenStringValue_whenCreatePurchaseAmount_thenCreatesPurchaseAmount() {
		// given
		String value = "14000";

		// when & then
		assertThatCode(() -> new PurchaseAmount(value))
			.doesNotThrowAnyException();
	}

	@DisplayName("구매금액이 1000미만으로 주어졌을 때 예외를 던지는지 확인한다.")
	@Test
	void givenLessThanThousand_whenCreatePurchaseAmount_thenThrowsException() {
		// given
		String value = "999";

		// when & then
		assertThatThrownBy(() -> new PurchaseAmount(value))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 최소 구매 금액은 1000원 이상입니다.");
	}

	@DisplayName("숫자가 아닌 문자열이 주어졌을 때 예외를 던지는지 확인한다.")
	@Test
	void givenNotNumberStringValue_whenCreatePurchaseAmount_thenThrowsException() {
		// given
		String value = "100a";

		// when & then
		assertThatThrownBy(() -> new PurchaseAmount(value))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 잘못된 형식의 입력입니다.");
	}
}
