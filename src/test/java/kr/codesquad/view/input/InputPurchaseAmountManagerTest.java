package kr.codesquad.view.input;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import kr.codesquad.domain.Money;

class InputPurchaseAmountManagerTest {

	InputManger<Money> inputManager;

	@DisplayName("로또 구입금액 입력 요청 - 숫자가 아닐 때")
	@ParameterizedTest
	@ValueSource(strings = {" ", "string", "string123"})
	void askPurchaseAmountDigitError(String input) {
		inputManager = setInput(input);
		Optional<Money> optionalInteger = inputManager.askClient();
		assertThat(optionalInteger).isEmpty();
	}

	@DisplayName("로또 구입금액 입력 요청 - 1000원 단위가 아닐 때")
	@ParameterizedTest
	@ValueSource(strings = {"1100", "900"})
	void askPurchaseAmountUnitError(String input) {
		inputManager = setInput(input);
		Optional<Money> optionalInteger = inputManager.askClient();
		assertThat(optionalInteger).isEmpty();
	}

	@DisplayName("로또 구입금액 입력 요청 - 정상 입력")
	@ParameterizedTest
	@ValueSource(strings = {"1000", "2000"})
	void askPurchaseAmountSuccess(String input) {
		inputManager = setInput(input);
		Optional<Money> optionalInteger = inputManager.askClient();
		assertThat(optionalInteger).isPresent().hasValue(new Money(Integer.parseInt(input)));
	}

	@DisplayName("당첨 번호 입력 패턴이 에러")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,6,7", "f,ff,f,f,f", "1,2,3,4,5"})
	void askWiningNumbersPatternError(String input) {
		inputManager = setInput(input);
		Optional<Money> optionalInteger = inputManager.askClient();
		assertThat(optionalInteger).isEmpty();
	}

	@DisplayName("당첨 번호 중복 범위 초과 에러")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4,5,5", "0,1,23,2,3,4", "1,2,3,4,5,46"})
	void askWiningNumbersDuplicateOrRangeError(String input) {
		inputManager = setInput(input);
		Optional<Money> optionalInteger = inputManager.askClient();
		assertThat(optionalInteger).isEmpty();
	}

	private InputManger<Money> setInput(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		return inputManager = new InputPurchaseAmountManager();
	}

}
