package kr.codesquad.domain;

public enum Result {

	THREE_CORRECT(5_000),
	FOUR_CORRECT(50_000),
	FIVE_CORRECT(1_500_000),
	ALL_CORRECT(2_000_000_000),
	OTHER(0);

	private final int winningAmount;

	Result(int winningAmount) {
		this.winningAmount = winningAmount;
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
