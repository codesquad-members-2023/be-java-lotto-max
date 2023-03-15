package kr.codesquad.dto;

public class CorrectNumberDto {

	private final int correctCount;
	private final boolean isCorrectWithBonusNumber;

	public CorrectNumberDto(final int correctCount, final boolean isCorrectWithBonusNumber) {
		this.correctCount = correctCount;
		this.isCorrectWithBonusNumber = isCorrectWithBonusNumber;
	}

	public int getCorrectCount() {
		return correctCount;
	}

	public boolean isCorrectWithBonusNumber() {
		return isCorrectWithBonusNumber;
	}
}
