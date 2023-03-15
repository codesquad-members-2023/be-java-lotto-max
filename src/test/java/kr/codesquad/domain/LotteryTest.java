package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.codesquad.dto.CorrectNumberDto;

class LotteryTest {

	@DisplayName("로또가 주어지고 해당 로또가 당첨번호와 몇 개가 일치하고 보너스번호를 포함하는지 검증한다.")
	@Test
	void givenLottery_whenCountCorrectNumber_thenReturnsCorrectNumberDto() {
		// given
		Lottery lottery = new Lottery(() -> List.of(1, 2, 3, 4, 5, 6));
		List<Integer> winning = List.of(1, 2, 3, 4, 5, 7);
		int bonusNumber = 6;

		// when
		CorrectNumberDto correctNumberDto = lottery.countCorrectNumber(winning, bonusNumber);

		// then
		assertAll(
			() -> assertThat(correctNumberDto.getCorrectCount()).isEqualTo(5),
			() -> assertThat(correctNumberDto.isCorrectWithBonusNumber()).isTrue()
		);
	}
}