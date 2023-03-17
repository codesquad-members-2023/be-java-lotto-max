package kr.codesquad.domain;

import java.util.Objects;

public class Money {

	public static final int ONE_HUNDRED = 100;
	public static final String EARNING_RATE_RESULT_DESC = "총 수익률은 %.2f%%입니다.";

	private final int value;

	public Money(int value) {
		this.value = value;
	}

	public int getQuantity() {
		return value / LottoConfig.TICKET_PRICE;
	}

	public String getEarningRate(Long sum) {
		float earningRate = ((float)sum - value) / value * ONE_HUNDRED;
		return String.format(EARNING_RATE_RESULT_DESC, earningRate);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Money))
			return false;
		Money money = (Money)o;
		return value == money.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
