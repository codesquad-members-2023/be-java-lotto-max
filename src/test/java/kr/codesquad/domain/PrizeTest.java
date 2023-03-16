package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {

	@DisplayName("MathCount 입력하면 대응한 Prize 타입을 만들어준다")
	@ParameterizedTest
	@CsvSource({"2,NONE", "0,NONE", "3,FOURTH", "4,THIRD", "5,SECOND", "6,FIRST"})
	void createByMatchCount(int match, Prize prize) {
		assertThat(Prize.createByMatchCount(match, false)).isEqualTo(prize);
	}

	@DisplayName("NONE 타입 뺴고 Prize를 순서대로 받는다.")
	@Test
	void getWinningPrize() {
		assertThat(Prize.getWinningPrize()).containsOnly(Prize.FIRST, Prize.BONUS, Prize.SECOND, Prize.THIRD,
			Prize.FOURTH);
	}
}
