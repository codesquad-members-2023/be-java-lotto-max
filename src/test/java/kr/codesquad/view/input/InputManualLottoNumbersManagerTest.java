package kr.codesquad.view.input;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import kr.codesquad.domain.Ball;
import kr.codesquad.domain.Ticket;

class InputManualLottoNumbersManagerTest {

	@DisplayName("정확히 입력값은 Optional에 감싸고 return한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6", "10,20,30,40,45,41"})
	void askClientIfRight(String input) {
		InputManualLottoNumbersManager inputManualLottoNumbersManager = setInput(input);
		Optional<Ticket> ticket = inputManualLottoNumbersManager.askClient();
		assertThat(ticket).isPresent();
		assertThat(ticket.get()).hasFieldOrPropertyWithValue("ballNumbers",Arrays.stream(input.split(","))
			.map(Integer::parseInt)
			.map(Ball::new)
			.collect(Collectors.toList()));
	}


	@DisplayName("잘못된 입력값은 Optional.empty return한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6,7", "10,20,30,40,45,46","1,2,3,4,5"})
	void askClientIfWrong(String input) {
		InputManualLottoNumbersManager inputManualLottoNumbersManager = setInput(input);
		Optional<Ticket> ticket = inputManualLottoNumbersManager.askClient();
		assertThat(ticket).isEmpty();
	}

	private InputManualLottoNumbersManager setInput(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		return new InputManualLottoNumbersManager();
	}
}
