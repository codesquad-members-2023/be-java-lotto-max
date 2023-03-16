package kr.codesquad.view;

import static kr.codesquad.domain.LottoBalls.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import kr.codesquad.domain.Ball;
import kr.codesquad.domain.WinningNumbers;

class InputManagerValidatorTest {

	@DisplayName("중복 번호 일 때 에러 발생")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	void validIsDuplicationFail(int value) {
		WinningNumbers winningNumbers = setTestWinningNUmbersFrom1To6();
		assertThatThrownBy(() -> InputManagerValidator.validIsDuplication(winningNumbers, value)).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("중복 코드 일력시 에러 발생")
	@ParameterizedTest
	@ValueSource(ints = {0, 8, 9})
	void validIsDuplicationSuccess(int value) {
		WinningNumbers winningNumbers = setTestWinningNUmbersFrom1To6();
		assertThatCode(
			() -> InputManagerValidator.validIsDuplication(winningNumbers, value)).doesNotThrowAnyException();
	}

	private static WinningNumbers setTestWinningNUmbersFrom1To6() {
		List<Ball> balls = IntStream.range(1, 7)
			.mapToObj(Ball::new)
			.collect(Collectors.toList());
		return new WinningNumbers(balls);
	}

	@DisplayName("숫자가 아닐 대 에러를 던진다.")
	@ParameterizedTest
	@ValueSource(strings = {"a", "!", "-"})
	void validIsDigitIfNotDigit(String value) {
		assertThatThrownBy(() -> InputManagerValidator.validIsDigit(value)).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("숫자가 맞을 때 에러를 던지지 않는다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "3", "45"})
	void validIsDigitIfDigit(String value) {
		assertThatCode(() -> InputManagerValidator.validIsDigit(value)).doesNotThrowAnyException();
	}

	@DisplayName("당첨 번호 길이를 아닐 때 에러를 던진다.")
	@ParameterizedTest
	@ValueSource(ints = {4, 7})
	void validWinningNumbersSizeIfNot(int value) {
		assertThatThrownBy(() -> InputManagerValidator.validWinningNumbersSize(value)).isInstanceOf(
			IllegalArgumentException.class);
	}

	@DisplayName("당첨 번호 길이와 일치할 때 에러를 던지지 않는다")
	@Test
	void validWinningNumbersSizeIfRight() {
		assertThatCode(
			() -> InputManagerValidator.validWinningNumbersSize(LOTTO_NUMBERS_LENGTH)).doesNotThrowAnyException();
	}

	@DisplayName("정확한 당첨 번호가 패턴이 아니면 에러를 던진다")
	@ParameterizedTest
	@ValueSource(strings = {"50,30,20,10,5,1","a,10,11,12,13,14","10,9,8,7,6,"})
	void validWiningNumbersThrowError(String winingNumbers) {
		assertThatThrownBy(() -> InputManagerValidator.validWiningNumbers(winingNumbers))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("정확한 당첨 번호가 패턴에 일치 시 에러를 던지지 않는다.")
	@ParameterizedTest
	@ValueSource(strings = {"40,30,20,10,5,1","9,10,11,12,13,14","10,9,8,7,6,1"})
	void validWiningNumbersIfSuccess(String winingNumbers) {
		assertThatCode(() -> InputManagerValidator.validWiningNumbers(winingNumbers))
			.doesNotThrowAnyException();
	}

	@DisplayName("한장의 티켓의 금액의 배수가 아닐 때 에러를 던진다.")
	@ParameterizedTest
	@ValueSource(strings = {"100", "900", "1100"})
	void validPurchaseAmountThrowError(String value) {
		assertThatThrownBy(() -> InputManagerValidator.validPurchaseAmount(value))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("한장의 티켓의 금액의 배수 일 때 에러를 던지지 않는다.")
	@ParameterizedTest
	@ValueSource(strings = {"1000", "9000", "2000"})
	void validPurchaseAmountIfSuccess(String value) {
		assertThatCode(() -> InputManagerValidator.validPurchaseAmount(value))
			.doesNotThrowAnyException();
	}
}
