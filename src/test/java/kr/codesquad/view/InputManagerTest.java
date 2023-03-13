package kr.codesquad.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputManagerTest {

	@DisplayName("로또 구입금액 입력 요청 - 숫자가 아닐 때")
	@ParameterizedTest
	@ValueSource(strings = {" ", "string", "string123"})
	void askPurchaseAmountDigitError(String input) {
		InputManager inputManager = setInput(input);
		assertThatThrownBy(inputManager::askPurchaseAmount).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputManager.DIGIT_PATTERN_ERROR_MESSAGE);
	}

	@DisplayName("로또 구입금액 입력 요청 - 1000원 단위가 아닐 때")
	@ParameterizedTest
	@ValueSource(strings = {"1100", "900"})
	void askPurchaseAmountUnitError(String input) {
		InputManager inputManager = setInput(input);
		assertThatThrownBy(inputManager::askPurchaseAmount).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputManager.UNIT_ERROR_MESSAGE);
	}

	@DisplayName("로또 구입금액 입력 요청 - 정상 입력")
	@ParameterizedTest
	@ValueSource(strings = {"1000", "2000"})
	void askPurchaseAmountSuccess(String input) {
		InputManager inputManager = setInput(input);
		assertThat(inputManager.askPurchaseAmount()).isEqualTo(Integer.parseInt(input));
	}

	@DisplayName("당첨 번호 입력 패턴이 에러")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6,7", "f,ff,f,f,f", "1,2,3,4,5"})
	void askWiningNumbersPatternError(String input) {
		InputManager inputManager = setInput(input);
		assertThatThrownBy(inputManager::askWiningNumbers).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputManager.WINNING_NUMBERS_PATTERN_ERROR_MESSAGE);
	}

	@DisplayName("당첨 번호 중복 범위 초과 에라")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,5", "0,1,23,2,3,4", "1,2,3,4,5,46"})
	void askWiningNumbersDuplicateOrRangeError(String input) {
		InputManager inputManager = setInput(input);
		assertThatThrownBy(inputManager::askWiningNumbers).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(InputManager.WINNING_NUMBERS_DUPLICATE_OR_RANGE_ERROR_MESSAGE);
	}

	@DisplayName("당첨 번호 입력 성공")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6", "45,1,23,2,3,4", "1,2,3,4,5,45"})
	void askWiningNumbersSuccess(String input) {
		InputManager inputManager = setInput(input);
		assertThat(inputManager.askWiningNumbers()).isEqualTo(InputManager.convertWiningNumbers(input));
	}

	private InputManager setInput(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		return new InputManager();
	}
}
