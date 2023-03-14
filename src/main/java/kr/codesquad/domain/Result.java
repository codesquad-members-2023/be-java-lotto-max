package kr.codesquad.domain;

public enum Result {

	THREE_CORRECT(3, 5_000),
	FOUR_CORRECT(4, 50_000),
	FIVE_CORRECT(5, 1_500_000),
	ALL_CORRECT(6, 2_000_000_000),
	OTHER(0, 0);

	private final int value;
	private final int winningAmount;

	Result(final int value, final int winningAmount) {
		this.value = value;
		this.winningAmount = winningAmount;
	}

	public int getValue() {
		return value;
	}

	public int getWinningAmount() {
		return winningAmount;
	}

	public static Result getResult(final int correctCount) {
		if (correctCount == 3) {
			return THREE_CORRECT;
		}
		if (correctCount == 4) {
			return FOUR_CORRECT;
		}
		if (correctCount == 5) {
			return FIVE_CORRECT;
		}
		if (correctCount == 6) {
			return ALL_CORRECT;
		}
		return OTHER;
	}
}
