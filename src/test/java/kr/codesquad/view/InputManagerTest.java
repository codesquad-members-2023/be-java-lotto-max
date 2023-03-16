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

import kr.codesquad.domain.WinningNumbers;

class InputManagerTest {

	@DisplayName("당첨 번호 입력 성공")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6", "45,1,23,2,3,4", "1,2,3,4,5,45"})
	void askWiningNumbersSuccess(String input) {
		InputManager inputManager = setInput(input);
		assertThat(inputManager.askWiningNumbers().orElseThrow()).isEqualTo(
			new WinningNumbers(InputManager.convertWiningNumbers(input)));
	}

	private InputManager setInput(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		return new InputManager();
	}
}
