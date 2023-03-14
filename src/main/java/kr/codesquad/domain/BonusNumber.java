package kr.codesquad.domain;

import java.util.List;

public class BonusNumber {

	private final int value;

	public BonusNumber(final String value, final List<Integer> winning) {
		validate(value, winning);
		this.value = Integer.parseInt(value);
	}

	private void validate(final String value, final List<Integer> winning) {
		int bonusNumber = Integer.parseInt(value);
		if (bonusNumber < 1 || bonusNumber > 45) {
			throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45사이의 숫자여야 합니다.");
		}
		if (winning.contains(bonusNumber)) {
			throw new IllegalArgumentException("[ERROR] 당첨번호와 중복된 보너스 번호는 주어지지 않습니다.");
		}
	}

	public int getBonusNumber() {
		return value;
	}
}
