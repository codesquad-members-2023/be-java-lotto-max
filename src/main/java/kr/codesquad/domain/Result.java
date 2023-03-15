package kr.codesquad.domain;

public enum Result {

	THREE_CORRECT(5_000, "3개 일치 (5000원)- "),
	FOUR_CORRECT(50_000, "4개 일치 (50000원)- "),
	FIVE_CORRECT(1_500_000, "5개 일치 (1500000원)- "),
	FIVE_CORRECT_WITH_BONUS(30_000_000, "5개 일치, 보너스 볼 일치(30000000원)- "),
	ALL_CORRECT(2_000_000_000, "6개 일치 (2000000000원)- "),
	OTHER(0, "");

	private final int winningAmount;
	private final String resultInfoMsg;

	Result(final int winningAmount, final String resultInfoMsg) {
		this.winningAmount = winningAmount;
		this.resultInfoMsg = resultInfoMsg;
	}

	public int getWinningAmount() {
		return winningAmount;
	}

	public String getResultInfoMsg() {
		return resultInfoMsg;
	}

	public static Result getResult(final int correctCount, boolean isCorrectWithBonusNumber) {
		if (correctCount == 3) {
			return THREE_CORRECT;
		}
		if (correctCount == 4) {
			return FOUR_CORRECT;
		}
		if (correctCount == 5 && isCorrectWithBonusNumber) {
			return FIVE_CORRECT_WITH_BONUS;
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
