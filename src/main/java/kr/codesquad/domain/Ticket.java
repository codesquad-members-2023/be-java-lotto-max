package kr.codesquad.domain;

import java.util.List;

public class Ticket {

	private final List<Ball> ballNumbers;

	public Ticket(List<Ball> ballNumbers) {
		initCheck(ballNumbers);
		this.ballNumbers = ballNumbers;
	}

	private static void initCheck(List<Ball> winingNumbers) {
		long count = winingNumbers.stream().distinct().count();
		if (count != LottoBalls.LOTTO_NUMBERS_LENGTH) {
			throw new IllegalArgumentException("중복 된 번호는 허용하지 않습니다.");
		}
	}

	public String getNumbers() {
		return ballNumbers.toString();
	}

	public long checkWinningNumbers(List<Ball> winingNumbers) {
		return ballNumbers.stream()
			.filter(winingNumbers::contains)
			.count();
	}

	public boolean contains(Ball bonusBall) {
		return ballNumbers.contains(bonusBall);
	}
}
