package kr.codesquad.domain;

import java.util.Objects;

public class Ball {

	public static final String BALL_NUMBER_RANGE_ERROR = "로또번호의 범위를 벗어났습니다.";
	private final int number;

	public Ball(int number) {
		if (number < LottoConfig.MIN_BALL_NUMBER || number > LottoConfig.MAX_BALL_NUMBER) {
			throw new IllegalArgumentException(BALL_NUMBER_RANGE_ERROR);
		}
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Ball))
			return false;
		Ball ball = (Ball)o;
		return getNumber() == ball.getNumber();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNumber());
	}
}
