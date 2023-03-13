package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {

	@DisplayName("올바른 당첨번호가 주어지면 Winning 객체 생성에 성공한다.")
	@Test
	void givenStringValue_whenCreatesWinning_thenCreatesWinning() {
		// given
		String value = "1, 2, 3, 4, 5, 6";

		// when & then
		assertThatCode(() -> new Winning(value))
			.doesNotThrowAnyException();
	}

	@DisplayName("6개가 아닌 당첨번호가 주어지면 예외를 던진다.")
	@Test
	void givenNotNumberOfSixWinningNumbers_whenCreatesWinning_thenThrowsException() {
		// given
		String greaterThanSix = "1, 2, 3, 4, 5, 6, 7";
		String lessThanSix = "1, 2, 3, 4, 5";

		// when & then
		assertAll(
			() -> assertThatThrownBy(() -> new Winning(greaterThanSix))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 당첨번호의 개수는 6개여야 합니다."),
			() -> assertThatThrownBy(() -> new Winning(lessThanSix))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 당첨번호의 개수는 6개여야 합니다.")
		);
	}

	@DisplayName("1~45 사이의 숫자가 아닌 당첨번호가 주어지면 예외를 던진다.")
	@Test
	void givenInvalidRangeWinningNumbers_whenCreateWinning_thenThrowsException() {
		// given
		String value = "1, 2, 3, 4, 5, 46";

		// when & then
		assertThatThrownBy(() -> new Winning(value))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다. 입력한 번호 : 46");
	}
}
