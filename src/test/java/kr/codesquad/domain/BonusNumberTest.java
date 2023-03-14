package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

	@DisplayName("올바른 숫자 문자열이 주어질 때 BonusNumber 객체 생성에 성공한다.")
	@Test
	void givenStringValue_whenCreatesBonusNumber_thenCreatesBonusNumber() {
		// given
		String value = "7";
		List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);

		// when & then
		assertThatCode(() -> new BonusNumber(value, winning))
			.doesNotThrowAnyException();
	}

	@DisplayName("당첨번호와 중복된 숫자가 주어지면 예외가 발생한다.")
	@Test
	void givenDuplicatedStringValue_whenCreatesBonusNumber_thenThrowsException() {
		// given
		String value = "6";
		List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);

		// when & then
		assertThatThrownBy(() -> new BonusNumber(value, winning))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 당첨번호와 중복된 보너스 번호는 주어지지 않습니다.");
	}

	@DisplayName("1~45 사이의 숫자가 아닌 숫자가 주어지면 예외가 발생한다.")
	@Test
	void givenInvalidRangeStringValue_whenCreatesBonusNumber_thenThrowsException() {
		// given
		String lessValue = "0";
		String greaterValue = "46";
		List<Integer> winning = List.of(1, 2, 3, 4, 5, 6);

		// when & then
		assertAll(
			() -> assertThatThrownBy(() -> new BonusNumber(greaterValue, winning))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 보너스 번호는 1~45사이의 숫자여야 합니다."),
			() -> assertThatThrownBy(() -> new BonusNumber(lessValue, winning))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 보너스 번호는 1~45사이의 숫자여야 합니다.")
		);
	}
}
