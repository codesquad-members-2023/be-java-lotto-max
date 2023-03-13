package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import kr.codesquad.view.InputManager;
import kr.codesquad.view.OutputManager;

public class LottoGame {

	private final InputManager inputManager;

	public LottoGame(InputManager inputManager) {
		this.inputManager = inputManager;
	}

	public void playGame() {
		int purchaseAmount = askPurchaseAmount();
		int quantity = purchaseAmount / BallConfig.TICKET_PRICE;
		List<Ticket> tickets = generateTickets(quantity);
		printTickets(quantity, tickets);
		WinningNumbers winningNumbers = askWinningNumbers();
		Player player = new Player(purchaseAmount, tickets);
	}

	private WinningNumbers askWinningNumbers() {
		try {
			List<Integer> askWiningNumbers = inputManager.askWiningNumbers();
			List<Ball> winningNumbers = askWiningNumbers.stream()
				.map(Ball::new)
				.collect(Collectors.toList());
			return new WinningNumbers(winningNumbers);
		} catch (Exception e) {
			e.printStackTrace();
			return askWinningNumbers();
		}
	}

	private static void printTickets(int quantity, List<Ticket> tickets) {
		OutputManager outputManager = new OutputManager();
		outputManager.printTickets(quantity, new ArrayList<>(tickets));
	}

	private static List<Ticket> generateTickets(int quantity) {
		LottoManger lottoManger = new LottoManger();
		return lottoManger.generateTickets(quantity);
	}

	private int askPurchaseAmount() {
		try {
			return inputManager.askPurchaseAmount();
		} catch (Exception e) {
			e.printStackTrace();
			return askPurchaseAmount();
		}
	}
}
