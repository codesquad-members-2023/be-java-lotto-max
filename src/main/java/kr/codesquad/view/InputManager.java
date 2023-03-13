package kr.codesquad.view;

import static kr.codesquad.domain.BallConfig.*;

import java.util.Scanner;

public class InputManager {

	public static final String ASK_PURCHASE_AMOUNT_DESC = "구입금액을 입력해 주세요.";
	public static final String DIGIT_ERROR_MESSAGE = "숫자를 입력해 해주세요";
	public static final String UNIT_ERROR_MESSAGE = TICKET_PRICE +"원 단위로 입력해 해주세요";
	public static final String DIGIT_PATTERN = "[1-9][0-9]*";

	public int askPurchaseAmount() {
		System.out.println(ASK_PURCHASE_AMOUNT_DESC);
		Scanner scanner = new Scanner(System.in);
		String purchaseAmountInput = scanner.nextLine();
		validPurchaseAmount(purchaseAmountInput);
		scanner.close();
		return Integer.parseInt(purchaseAmountInput);
	}

	private void validPurchaseAmount(String purchaseAmountInput) {
		if (!purchaseAmountInput.matches(DIGIT_PATTERN)) {
			throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
		}
		if (Integer.parseInt(purchaseAmountInput) % TICKET_PRICE != 0) {
			throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
		}
	}
}
