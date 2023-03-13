package kr.codesquad.generator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryNumberGeneratorTest {

	private final LotteryNumberGenerator sut = new LotteryNumberGenerator();

	@DisplayName("랜덤한 로또번호가 6개, 1~45사이의 숫자로 생성되는지 확인한다.")
	@Test
	void givenNothing_whenGenerateLotteryNumbers_thenReturnsLotteryNumbers() {
		// given
		// when
		List<Integer> lotteryNumbers = sut.generateLottoNumbers();

		// then
		assertAll(
			() -> assertThat(lotteryNumbers).hasSize(6),
			() -> lotteryNumbers.forEach(number -> assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45))
		);
	}
}