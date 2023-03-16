package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import kr.codesquad.view.InputManager;
import kr.codesquad.view.OutputManager;

public class LottoGame {

	private final InputManager inputManager;
	private final LottoManger lottoManger;
	private final OutputManager outputManager;

	public LottoGame() {
		this.inputManager = new InputManager();
		this.lottoManger = new LottoManger();
		this.outputManager = new OutputManager();
	}

	public void playGame() {
		Money purchaseAmount = askPurchaseAmount();
		int quantity = purchaseAmount.getQuantity(BallConfig.TICKET_PRICE);
		List<Ticket> tickets = generateTickets(quantity);
		printTickets(quantity, tickets);
		WinningNumbers winningNumbers = askWinningNumbers();
		Ball bonus = askBonusBall(winningNumbers);
		printLottoResult(purchaseAmount, tickets, winningNumbers,bonus);
	}

	private Money askPurchaseAmount() {
		Optional<Money> optionalMoney = inputManager.askPurchaseAmount();
		while (optionalMoney.isEmpty()) {
			optionalMoney = inputManager.askPurchaseAmount();
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
		Optional<WinningNumbers> optionalWinningNumbers = inputManager.askWiningNumbers();
		while (optionalWinningNumbers.isEmpty()) {
			optionalWinningNumbers = inputManager.askWiningNumbers();
		}
		return optionalWinningNumbers.get();
	}

	private Ball askBonusBall(WinningNumbers winningNumbers) {
		Optional<Ball> optionalBonusBall = inputManager.askBonusBall(winningNumbers);
		while (optionalBonusBall.isEmpty()) {
			optionalBonusBall = inputManager.askBonusBall(winningNumbers);
		}
		return optionalBonusBall.get();
	}

	private void printLottoResult(Money purchaseAmount, List<Ticket> tickets, WinningNumbers winningNumbers, Ball bonus) {
		Player player = new Player(purchaseAmount, tickets);
		LottoResult lottoResult = lottoManger.checkPlayerTickets(player, winningNumbers,bonus);
		outputManager.printLottoResult(lottoResult);
	}
}
