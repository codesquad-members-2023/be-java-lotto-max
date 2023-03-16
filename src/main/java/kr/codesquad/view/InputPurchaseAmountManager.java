package kr.codesquad.view;

import static kr.codesquad.view.InputManagerValidator.*;

import java.util.Optional;
import java.util.Scanner;

import kr.codesquad.domain.Money;

public class InputPurchaseAmountManager implements InputManagerInterface<Money> {
	public static final String ASK_PURCHASE_AMOUNT_DESC = "구입금액을 입력해 주세요.";

	@Override
	public Optional<Money> askClient() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println(ASK_PURCHASE_AMOUNT_DESC);
			String purchaseAmountInput = scanner.nextLine();
			validPurchaseAmount(purchaseAmountInput);
			return Optional.of(new Money(Integer.parseInt(purchaseAmountInput)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
