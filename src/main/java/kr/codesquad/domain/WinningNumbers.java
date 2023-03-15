package kr.codesquad.domain;

import java.util.List;

public class WinningNumbers {
	private final List<Ball> winingNumbers;

	public WinningNumbers(List<Ball> winingNumbers) {
		this.winingNumbers = winingNumbers;
	}

	public Prize checkWinningNumbers(Ticket ticket) {
		List<Ball> ballNumbers = ticket.getBallNumbers();
		int matchCount = (int)ballNumbers.stream()
			.filter(winingNumbers::contains)
			.count();
		return Prize.createByMatchCount(matchCount);
	}
}
