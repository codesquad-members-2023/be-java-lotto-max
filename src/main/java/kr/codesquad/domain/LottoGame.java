package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import kr.codesquad.view.InputBonusBallManger;
import kr.codesquad.view.InputManger;
import kr.codesquad.view.InputManualLottoCount;
import kr.codesquad.view.InputPurchaseAmountManager;
import kr.codesquad.view.InputWiningNumbersManager;
import kr.codesquad.view.OutputManager;

public class LottoGame {

	private final LottoManger lottoManger;
	private final OutputManager outputManager;

	public LottoGame() {
		this.lottoManger = new LottoManger();
		this.outputManager = new OutputManager();
	}

	public void playGame() {
		Money purchaseAmount = askPurchaseAmount();
		int quantity = purchaseAmount.getQuantity(BallConfig.TICKET_PRICE);
		int manualLottoCount = askManualLottoCount(quantity);

		List<Ticket> tickets = generateTickets(quantity - manualLottoCount);
		printTickets(quantity, tickets);
		WinningNumbers winningNumbers = askWinningNumbers();
		Ball bonus = askBonusBall(winningNumbers);
		printLottoResult(purchaseAmount, tickets, winningNumbers, bonus);
	}

	private int askManualLottoCount(int quantity) {
		InputManualLottoCount inputManualLottoCount = new InputManualLottoCount();
		Optional<Integer> optionalCount = inputManualLottoCount.askClient(quantity);
		while (optionalCount.isEmpty()) {
			optionalCount = inputManualLottoCount.askClient(quantity);
		}
		return optionalCount.get();
	}

	private Money askPurchaseAmount() {
		InputPurchaseAmountManager inputPurchaseAmountManager = new InputPurchaseAmountManager();
		Optional<Money> optionalMoney = inputPurchaseAmountManager.askClient();
		while (optionalMoney.isEmpty()) {
			optionalMoney = inputPurchaseAmountManager.askClient();
		}
		return optionalMoney.get();
	}

	private List<Ticket> generateTickets(int quantity) {
		return lottoManger.generateTickets(quantity);
	}

	private void printTickets(int quantity, List<Ticket> tickets) {
		outputManager.printTickets(quantity, new ArrayList<>(tickets));
	}

	private WinningNumbers askWinningNumbers() {
		InputManger<WinningNumbers> inputWiningNumbersManager = new InputWiningNumbersManager();
		Optional<WinningNumbers> optionalWinningNumbers = inputWiningNumbersManager.askClient();
		while (optionalWinningNumbers.isEmpty()) {
			optionalWinningNumbers = inputWiningNumbersManager.askClient();
		}
		return optionalWinningNumbers.get();
	}

	private Ball askBonusBall(WinningNumbers winningNumbers) {
		InputBonusBallManger inputBonusBallManger = new InputBonusBallManger();
		Optional<Ball> optionalBonusBall = inputBonusBallManger.askClient(winningNumbers);
		while (optionalBonusBall.isEmpty() || winningNumbers.containsBallNumber(optionalBonusBall.get())) {
			optionalBonusBall = inputBonusBallManger.askClient(winningNumbers);
		}
		return optionalBonusBall.get();
	}

	private void printLottoResult(Money purchaseAmount, List<Ticket> tickets, WinningNumbers winningNumbers,
		Ball bonus) {
		Player player = new Player(purchaseAmount, tickets);
		LottoResult lottoResult = lottoManger.checkPlayerTickets(player, winningNumbers, bonus);
		outputManager.printLottoResult(lottoResult);
	}
}
