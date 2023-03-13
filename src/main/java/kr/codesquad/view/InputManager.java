package kr.codesquad.view;

import java.util.Scanner;

public class InputManager {

	public static final String ASK_PURCHASE_AMOUNT_DESC = "구입금액을 입력해 주세요.";
	public static final String DIGIT_ERROR_MESSAGE = "숫자를 입력해 해주세요";
	public static final String UNIT_ERROR_MESSAGE = "1000원 단위로 입력해 해주세요";

	public int askPurchaseAmount() {
		System.out.println(ASK_PURCHASE_AMOUNT_DESC);
		Scanner scanner = new Scanner(System.in);
		String purchaseAmountInput = scanner.nextLine();
		validPurchaseAmount(purchaseAmountInput);
		scanner.close();
		return Integer.parseInt(purchaseAmountInput);
	}

	private void validPurchaseAmount(String purchaseAmountInput) {
		if (!purchaseAmountInput.matches("[1-9][0-9]*")) {
			throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
		}
		if (Integer.parseInt(purchaseAmountInput) % 1000 != 0) {
			throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
		}
	}
}
