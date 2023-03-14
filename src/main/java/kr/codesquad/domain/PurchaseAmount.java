package kr.codesquad.domain;

public class PurchaseAmount {

	private static final int MIN_PURCHASE_AMOUNT_VALUE = 1000;

	private final int value;

	public PurchaseAmount(final String value) {
		validate(value);
		this.value = Integer.parseInt(value);
	}

	private void validate(final String value) {
		try {
			if (Integer.parseInt(value) < MIN_PURCHASE_AMOUNT_VALUE) {
				throw new IllegalArgumentException("[ERROR] 로또 최소 구매 금액은 1000원 이상입니다.");
			}
		} catch (final NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 잘못된 형식의 입력입니다.");
		}
	}

	public int getPurchaseAmount() {
		return value;
	}

	public int getCountOfLottery() {
		return value / MIN_PURCHASE_AMOUNT_VALUE;
	}
}
