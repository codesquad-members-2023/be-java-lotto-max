package kr.codesquad.domain;

import java.util.List;
import java.util.Objects;

public class WinningNumbers {
	private final List<Ball> winingNumbers;

	public WinningNumbers(List<Ball> winingNumbers) {
		initCheck(winingNumbers);
		this.winingNumbers = winingNumbers;
	}

	private static void initCheck(List<Ball> winingNumbers) {
		long count = winingNumbers.stream().distinct().count();
		if (count != LottoBalls.LOTTO_NUMBERS_LENGTH) {
			throw new IllegalArgumentException("중복 된 번호는 허용하지 않습니다.");
		}
	}

	public Prize checkWinningNumbers(Ticket ticket, Ball bonusBall) {
		long matchCount = ticket.checkWinningNumbers(winingNumbers);
		boolean containBonus = ticket.contains(bonusBall);
		return Prize.createByMatchCount(matchCount, containBonus);
	}

	public boolean containsBallNumber(Ball bonusNumber) {
		return winingNumbers.contains(bonusNumber);
	}

	public boolean containsBallNumber(int bonusNumber) {
		return winingNumbers.stream()
			.anyMatch(ball -> ball.getNumber() == bonusNumber);
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
}
