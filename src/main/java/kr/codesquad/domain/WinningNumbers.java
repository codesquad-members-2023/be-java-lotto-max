package kr.codesquad.domain;

import java.util.List;
import java.util.Objects;

public class WinningNumbers {
	private final List<Ball> winingNumbers;

	public WinningNumbers(List<Ball> winingNumbers) {
		this.winingNumbers = winingNumbers;
	}

	public Prize checkWinningNumbers(Ticket ticket,Ball bonusBall) {
		List<Ball> ballNumbers = ticket.getBallNumbers();
		int matchCount = (int)ballNumbers.stream()
			.filter(winingNumbers::contains)
			.count();
		boolean containBonus = ballNumbers.contains(bonusBall);
		return Prize.createByMatchCount(matchCount,containBonus);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof WinningNumbers))
			return false;
		WinningNumbers that = (WinningNumbers)o;
		return Objects.equals(winingNumbers, that.winingNumbers);
	}

	@Override
	public int hashCode() {
		return Objects.hash(winingNumbers);
	}

	public boolean containsBallNumber(Ball bonusNumber) {
		return winingNumbers.contains(bonusNumber);
	}

	public boolean containsBallNumber(int bonusNumber) {
		return winingNumbers.stream()
			.anyMatch(ball -> ball.getNumber() == bonusNumber);
	}
}
