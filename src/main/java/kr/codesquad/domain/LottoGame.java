package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import kr.codesquad.view.OutputManager;
import kr.codesquad.view.input.InputBonusBallManger;
import kr.codesquad.view.input.InputManger;
import kr.codesquad.view.input.InputManualLottoCountManager;
import kr.codesquad.view.input.InputManualLottoNumbersManager;
import kr.codesquad.view.input.InputPurchaseAmountManager;
import kr.codesquad.view.input.InputWiningNumbersManager;

public class LottoGame {

	private static Ticket getTicket(InputManger<Ticket> inputManger) {
		Optional<Ticket> ticket = inputManger.askClient();
		while (ticket.isEmpty()) {
			ticket = inputManger.askClient();
		}
		return ticket.get();
	}

	public void playGame() {
		Money purchaseAmount = askPurchaseAmount();
		int quantity = purchaseAmount.getQuantity();
		int manualLottoCount = askManualLottoCount(quantity);
		List<Ticket> manualTickets = askManualLottoNumbers(manualLottoCount);
		List<Ticket> autoTickets = generateTickets(quantity - manualLottoCount);
		printTickets(quantity, autoTickets);
		WinningNumbers winningNumbers = askWinningNumbers();
		Ball bonus = askBonusBall(winningNumbers);
		printLottoResult(purchaseAmount, autoTickets, manualTickets, winningNumbers, bonus);
	}

	private List<Ticket> askManualLottoNumbers(int manualLottoCount) {
		if (manualLottoCount == 0) {
			return List.of();
		}
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		List<Ticket> result = new ArrayList<>();
		InputManger<Ticket> inputManger = new InputManualLottoNumbersManager();
		while (result.size() != manualLottoCount) {
			result.add(getTicket(inputManger));
		}

		return result;
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
		LottoMachine lottoMachine = new LottoMachine();
		return lottoMachine.generateTickets(quantity);
	}

	private void printTickets(int quantity, List<Ticket> tickets) {
		OutputManager outputManager = new OutputManager();
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

	private void printLottoResult(Money purchaseAmount, List<Ticket> autoTickets, List<Ticket> manualTickets,
		WinningNumbers winningNumbers,
		Ball bonus) {
		Player player = new Player(purchaseAmount, autoTickets);
		player.addTickets(manualTickets);
		LottoResult lottoResult = player.checkTicket(winningNumbers, bonus);
		OutputManager outputManager = new OutputManager();
		outputManager.printLottoResult(lottoResult);
	}
}
