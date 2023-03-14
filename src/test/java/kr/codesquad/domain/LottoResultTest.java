package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

	private LottoResult lottoResult;

	@BeforeEach
	void setLottoResult() {
		List<Ball> oneToSix = IntStream.range(1, 7)
			.mapToObj(Ball::new)
			.collect(Collectors.toList());
		Ticket ticketOneToSix = new Ticket(oneToSix);
		List<Ball> twoToSeven = IntStream.range(2, 8)
			.mapToObj(Ball::new)
			.collect(Collectors.toList());
		Ticket ticketTwoToSeven = new Ticket(twoToSeven);
		WinningNumbers winningNumbers = new WinningNumbers(oneToSix);
		lottoResult = LottoResult.create(14000, List.of(ticketOneToSix, ticketTwoToSeven), winningNumbers);
	}

	@DisplayName("로또 결과를 생성")
	@Test
	void create() {
		assertThat(lottoResult).hasFieldOrPropertyWithValue("purchaseAmount", 14000);
		assertThat(lottoResult).hasFieldOrPropertyWithValue("matchResult", Map.of(Prize.FIRST, 1L, Prize.SECOND, 1L));
	}

	@DisplayName("통계 결과를 생성")
	@Test
	void calculateStatistics() {
		assertThat(lottoResult.calculateStatistics()).isEqualTo(
			"3개 일치 (5000원) - 0개\n"
			+ "4개 일치 (50000원) - 0개\n"
			+ "5개 일치 (1500000원) - 1개\n"
			+ "6개 일치 (2000000000원) - 1개\n"
			+ "총 수익률은 14296330.00%입니다.");
	}

}
