package kr.codesquad.application;

import kr.codesquad.domain.Lotteries;
import kr.codesquad.domain.PurchaseAmount;
import kr.codesquad.domain.Winning;
import kr.codesquad.generator.LotteryNumberGenerator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LotteryApplication {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void run() {
		PurchaseAmount purchaseAmount = getPurchaseAmountFromUser();
		Lotteries lotteries = generateLotteries(purchaseAmount.getCountOfLottery());
		Winning winning = getWinningFromUser();
	}

	private PurchaseAmount getPurchaseAmountFromUser() {
		try {
			return new PurchaseAmount(inputView.getPurchaseAmount());
		} catch (final IllegalArgumentException e) {
			outputView.printExceptionMsg(e);
			return getPurchaseAmountFromUser();
		}
	}

	private Lotteries generateLotteries(final int countOfLottery) {
		Lotteries lotteries = new Lotteries(new LotteryNumberGenerator(), countOfLottery);
		outputView.printLotteries(countOfLottery, lotteries.toString());

		return lotteries;
	}

	private Winning getWinningFromUser() {
		try {
			return new Winning(inputView.getWinning());
		} catch (final IllegalArgumentException e) {
			outputView.printExceptionMsg(e);
			return getWinningFromUser();
		}
	}
}
