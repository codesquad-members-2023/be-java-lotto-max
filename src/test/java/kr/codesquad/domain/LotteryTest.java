package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kr.codesquad.dto.CorrectNumberDto;

class LotteryTest {

	@DisplayName("로또 번호가 주어지고 Lottery 객체를 생성할 때 Lottery 객체 생성에 성공한다.")
	@Test
	void givenLotteryNumber_whenCreatesLottery_thenCreatesLottery() {
		// given
		String lotteryNumber = "1, 2, 15, 23, 32, 45";

		// when & then
		assertThatCode(() -> new Lottery(lotteryNumber))
			.doesNotThrowAnyException();
	}

	@DisplayName("6개보다 적은 숫자의 로또 번호가 주어지면 Lottery 객체를 생성할 때 예외를 던진다.")
	@Test
	void givenLessThanSixLotteryNumber_whenCreatesLottery_thenThrowsException() {
		// given
		String lessThanSixLotteryNumber = "1, 2, 3, 4, 5";

		// when & then
		assertThatThrownBy(() -> new Lottery(lessThanSixLotteryNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또는 여섯 개의 숫자로 이루어져야 합니다.");
	}

	@DisplayName("1~45 사이의 숫자가 아닌 로또번호가 주어지면 예외를 던진다.")
	@Test
	void givenInvalidRangeLotteryNumber_whenCreatesLottery_thenThrowsException() {
		// given
		String lessRangeLotteryNumber = "0, 1, 2, 3, 4, 5";
		String greaterRangeLotteryNumber = "1, 2, 3, 4, 5, 46";

		// when & then
		assertAll(
			() -> assertThatThrownBy(() -> new Lottery(lessRangeLotteryNumber))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 로또의 번호는 1~45사이의 숫자여야 합니다. 입력한 번호 : 0"),
			() -> assertThatThrownBy(() -> new Lottery(greaterRangeLotteryNumber))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("[ERROR] 로또의 번호는 1~45사이의 숫자여야 합니다. 입력한 번호 : 46")
		);
	}

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