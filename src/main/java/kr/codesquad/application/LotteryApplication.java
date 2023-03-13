package kr.codesquad.application;

import kr.codesquad.domain.PurchaseAmount;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LotteryApplication {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void run() {
		PurchaseAmount purchaseAmount = getPurchaseAmountFromUser();
	}

	private PurchaseAmount getPurchaseAmountFromUser() {
		try {
			return new PurchaseAmount(inputView.getPurchaseAmount());
		} catch (final IllegalArgumentException e) {
			outputView.printExceptionMsg(e);
			return getPurchaseAmountFromUser();
		}
	}
}
