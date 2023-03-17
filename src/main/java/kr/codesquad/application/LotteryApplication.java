package kr.codesquad.application;

import java.util.List;

import kr.codesquad.domain.BonusNumber;
import kr.codesquad.domain.Lotteries;
import kr.codesquad.domain.PurchaseAmount;
import kr.codesquad.domain.Result;
import kr.codesquad.domain.Winning;
import kr.codesquad.dto.ResultDto;
import kr.codesquad.generator.LotteryNumberGenerator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LotteryApplication {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void run() {
		PurchaseAmount purchaseAmount = getPurchaseAmountFromUser();
		int countOfManualLottery = getCountOfManualLottery();
		Lotteries lotteries = generateLotteries(purchaseAmount.getCountOfLottery(), countOfManualLottery);
		Winning winning = getWinningFromUser();
		BonusNumber bonusNumber = getBonusNumberFromUser(winning.getWinnings());

		List<Result> results = lotteries.getResults(winning.getWinnings(), bonusNumber.getBonusNumber());
		printResults(results, calculateRateOfProfit(results, purchaseAmount.getPurchaseAmount()));
	}

	private PurchaseAmount getPurchaseAmountFromUser() {
		try {
			return new PurchaseAmount(inputView.getPurchaseAmount());
		} catch (final IllegalArgumentException e) {
			outputView.printExceptionMsg(e);
			return getPurchaseAmountFromUser();
		}
	}

	private int getCountOfManualLottery() {
		return Integer.parseInt(inputView.getCountOfManualLottery());
	}

	private Lotteries generateLotteries(final int totalCountOfLottery, final int countOfManualLottery) {
		final int countOfAutoLottery = totalCountOfLottery - countOfManualLottery;
		List<String> manualLotteries = inputView.getManualLotteries(countOfManualLottery);

		Lotteries lotteries = new Lotteries(new LotteryNumberGenerator(), manualLotteries, countOfAutoLottery);
		outputView.printLotteries(countOfManualLottery, countOfAutoLottery, lotteries.toString());

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

	private BonusNumber getBonusNumberFromUser(final List<Integer> winning) {
		try {
			return new BonusNumber(inputView.getBonusNumber(), winning);
		} catch (final IllegalArgumentException e) {
			outputView.printExceptionMsg(e);
			return getBonusNumberFromUser(winning);
		}
	}

	private double calculateRateOfProfit(final List<Result> results, final int purchaseAmount) {
		final int totalWinningAmount = results.stream()
			.mapToInt(Result::getWinningAmount)
			.sum();
		double rateOfProfit = 100 - ((double)totalWinningAmount / purchaseAmount) * 100;
		if (rateOfProfit <= 100) {
			return -rateOfProfit;
		}
		return rateOfProfit;
	}

	private void printResults(final List<Result> results, final double rateOfProfit) {
		outputView.printWinningStatistics(new ResultDto(results, rateOfProfit));
	}
}
