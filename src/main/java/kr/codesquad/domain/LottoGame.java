package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import kr.codesquad.view.input.InputBonusBallManger;
import kr.codesquad.view.input.InputManger;
import kr.codesquad.view.input.InputManualLottoCountManager;
import kr.codesquad.view.input.InputManualLottoNumbersManager;
import kr.codesquad.view.input.InputPurchaseAmountManager;
import kr.codesquad.view.input.InputWiningNumbersManager;
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
		List<Ticket> manualTickets = askManualLottoNumbers(manualLottoCount);
		List<Ticket> autoTickets = generateTickets(quantity - manualLottoCount);
		printTickets(quantity, autoTickets);
		WinningNumbers winningNumbers = askWinningNumbers();
		Ball bonus = askBonusBall(winningNumbers);
		printLottoResult(purchaseAmount, autoTickets, winningNumbers, bonus);
	}

	private List<Ticket> askManualLottoNumbers(int manualLottoCount) {
		if (manualLottoCount == 0) {
			return List.of();
		}
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		List<Ticket> result = new ArrayList<>();
		InputManger<Ticket> inputManger = new InputManualLottoNumbersManager();
		while (result.size() != manualLottoCount){
			result.add(getTicket(inputManger));
		}

		return result;
	}

	private static Ticket getTicket(InputManger<Ticket> inputManger) {
		Optional<Ticket> ticket = inputManger.askClient();
		while (ticket.isEmpty()) {
			ticket = inputManger.askClient();
		}
		return ticket.get();
	}

	private int askManualLottoCount(int quantity) {
		InputManualLottoCountManager inputManualLottoCountManager = new InputManualLottoCountManager();
		Optional<Integer> optionalCount = inputManualLottoCountManager.askClient(quantity);
		while (optionalCount.isEmpty()) {
			optionalCount = inputManualLottoCountManager.askClient(quantity);
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
