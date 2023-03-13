package kr.codesquad.view;

public class OutputView {

	public void printExceptionMsg(final Exception e) {
		System.out.println(e.getMessage());
	}

	public void printLotteries(final int countOfLottery, final String lotteries) {
		System.out.println(String.format("%d개를 구매했습니다.", countOfLottery));
		System.out.println(lotteries);
	}
}
