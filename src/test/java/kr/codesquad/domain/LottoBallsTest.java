package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBallsTest {

	@DisplayName("서로 다른 Ball을 로또 넘버 길이만큼 생성한다")
	@Test
	void generateRandom() {
		LottoBalls lottoBalls = new LottoBalls();
		List<Ball> balls = lottoBalls.generateRandom();
		long count = balls.stream()
			.distinct()
			.count();
		assertThat(count).isEqualTo(LottoBalls.LOTTO_NUMBERS_LENGTH);
	}
}
