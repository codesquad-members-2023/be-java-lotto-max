package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

	@DisplayName("범위를 초과할 경우 예외를 던진다")
	@Test
	void checkRange() {
		assertThatThrownBy(() -> new Ball(LottoConfig.MIN_BALL_NUMBER_MINUS_ONE))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Ball.BALL_NUMBER_RANGE_ERROR);

		assertThatThrownBy(() -> new Ball(LottoConfig.MAX_BALL_NUMBER_ADD_ONE))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(Ball.BALL_NUMBER_RANGE_ERROR);

	}

	@DisplayName("Ball Number가 같으면 Ball도 같다")
	@ParameterizedTest
	@ValueSource(ints = {1, 45, 30})
	void equalSameNumberIfTrue(int number) {
		Ball targetBall = new Ball(number);
		Ball newBall = new Ball(number);
		assertThat(targetBall).isEqualTo(newBall);
	}

	@DisplayName("Ball Number가 다르면 Ball도 다르다")
	@Test
	void equalSameNumberIfNot() {
		Ball targetBall = new Ball(10);
		Ball newBall = new Ball(9);
		assertThat(targetBall).isNotEqualTo(newBall);
	}
}
