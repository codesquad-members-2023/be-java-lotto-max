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
			.hasMessage(InputManager.DIGIT_ERROR_MESSAGE);
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

	private static InputManager setInput(String input) {
		InputManager inputManager = new InputManager();
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		return inputManager;
	}
}
