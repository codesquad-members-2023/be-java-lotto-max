package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

import kr.codesquad.view.InputManager;
import kr.codesquad.view.OutputManager;

public class LottoGame {

	public void playGame() {
		int purchaseAmount = askPurchaseAmount();

		int quantity = purchaseAmount / BallConfig.TICKET_PRICE;
		List<Ticket> tickets = generateTickets(quantity);

		printTickets(quantity,tickets);

		Player player = new Player(purchaseAmount, tickets);

	}

	private static void printTickets(int quantity, List<Ticket> tickets) {
		OutputManager outputManager = new OutputManager();
		outputManager.printTickets(quantity,new ArrayList<>(tickets));
	}

	private static List<Ticket> generateTickets(int quantity) {
		LottoManger lottoManger = new LottoManger();
		return lottoManger.generateTickets(quantity);
	}

	private int askPurchaseAmount() {
		InputManager inputManager = new InputManager();
		try {
			return inputManager.askPurchaseAmount();
		} catch (Exception e) {
			e.printStackTrace();
			return askPurchaseAmount();
		}
	}
}
