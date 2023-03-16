package kr.codesquad.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import kr.codesquad.domain.Ball;
import kr.codesquad.domain.WinningNumbers;

class InputBonusBallTest {

	@DisplayName("보너스 번호를 정확히 입력시 Ball객체를 optional에 담아서 return한다.")
	@ParameterizedTest
	@ValueSource(strings = {"7", "45"})
	void inputBonusBallIfSuccess(String bonusNumber) {
		InputBonusBall inputBonusBall = setInput(bonusNumber);
		Optional<Ball> ball = inputBonusBall.askClient(setTestWinningNumbersFrom1To6());
		assertThat(ball).isPresent().contains(new Ball(Integer.parseInt(bonusNumber)));
	}

	@DisplayName("보너스 번호를 잘못 입력시 빈 optional를 return한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "3", "4", "5", "6", "0", "ddd", "46"})
	void inputBonusBallIfFail(String bonusNumber) {
		InputBonusBall inputBonusBall = setInput(bonusNumber);
		Optional<Ball> ball = inputBonusBall.askClient(setTestWinningNumbersFrom1To6());
		assertThat(ball).isEmpty();
	}

	private static WinningNumbers setTestWinningNumbersFrom1To6() {
		List<Ball> balls = IntStream.range(1, 7)
			.mapToObj(Ball::new)
			.collect(Collectors.toList());
		return new WinningNumbers(balls);
	}

	private InputBonusBall setInput(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		OutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		return new InputBonusBall();
	}

}
