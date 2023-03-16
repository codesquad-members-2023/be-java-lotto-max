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

class InputWiningNumbersManagerTest {

	@DisplayName("당첨 번호를 입력하면 당첨 번호 객체를 option에 담고 반환한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6", "45,1,23,2,3,4", "1,2,3,4,5,45"})
	void askWiningNumbersSuccess(String input) {
		InputWiningNumbersManager inputManager = setInput(input);
		assertThat(inputManager.askClient()).isPresent().contains(
			new WinningNumbers(InputWiningNumbersManager.convertWiningNumbers(input)));
	}

	@DisplayName("당첨 번호를 잘못 입력하면 empty option 반환한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,50", "4fasfas,1,23,2,3,4", "1,2,3,4,5"})
	void askWiningNumbersIfFail(String input) {
		InputWiningNumbersManager inputManager = setInput(input);
		assertThat(inputManager.askClient()).isEmpty();
	}

	private InputWiningNumbersManager setInput(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		return new InputWiningNumbersManager();
	}

}
