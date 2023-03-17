package kr.codesquad.view.input;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputManualLottoCountManagerTest {

	@DisplayName("수동 구매 할 로또 수량을 잘못 입력시 Optional.Empty return")
	@ParameterizedTest
	@CsvSource(value = {"4,3", "dd,3", "-1,4"})
	void askClientIfIsWrong(String input, int quantity) {
		InputManualLottoCountManager inputManualLottoCountManager = setInput(input);
		Optional<Integer> optionalCount = inputManualLottoCountManager.askClient(quantity);
		Assertions.assertThat(optionalCount).isEmpty();
	}

	@DisplayName("수동 구매 할 로또 수량을 정확히 입력시 값을 Optional에 답고 return")
	@ParameterizedTest
	@CsvSource(value = {"4,5", "3,3", "0,4"})
	void askClientIfIsRight(String input, int quantity) {
		InputManualLottoCountManager inputManualLottoCountManager = setInput(input);
		Optional<Integer> optionalCount = inputManualLottoCountManager.askClient(quantity);
		Assertions.assertThat(optionalCount).isPresent().contains(Integer.valueOf(input));
	}

	private InputManualLottoCountManager setInput(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		return new InputManualLottoCountManager();
	}
}
