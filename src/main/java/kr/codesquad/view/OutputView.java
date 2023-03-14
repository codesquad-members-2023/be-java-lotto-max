package kr.codesquad.view;

import java.util.Arrays;

import kr.codesquad.domain.Result;
import kr.codesquad.dto.ResultDto;

public class OutputView {

	public void printExceptionMsg(final Exception e) {
		System.out.println(e.getMessage());
	}

	public void printLotteries(final int countOfLottery, final String lotteries) {
		System.out.println(String.format("%d개를 구매했습니다.", countOfLottery));
		System.out.println(lotteries);
	}

	public void printWinningStatistics(final ResultDto resultDto) {
		StringBuilder winningStatistics = new StringBuilder();
		winningStatistics.append("당첨 통계\n");
		winningStatistics.append("------------\n");

		Arrays.stream(Result.values())
			.filter(result -> result != Result.OTHER)
			.forEach(result -> winningStatistics.append(String.format("%d개 일치 (%d원) - %d개\n",
				result.getValue(),
				result.getWinningAmount(),
				resultDto.getCorrectCount(result))));
		winningStatistics.append(String.format("총 수익률은 %.2f%% 입니다.\n", resultDto.getRateOfProfit()));

		System.out.println(winningStatistics);
	}
}
