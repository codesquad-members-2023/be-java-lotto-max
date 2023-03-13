package kr.codesquad.domain;

import static kr.codesquad.domain.BallConfig.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBalls {
	public static final int LOTTO_NUMBERS_LENGTH = 6;
	private final List<Ball> lottoBalls;

	public LottoBalls() {
		lottoBalls = IntStream.range(MIN_BALL_NUMBER, MAX_BALL_NUMBER_ADD_ONE)
			.mapToObj(Ball::new)
			.collect(Collectors.toList());
	}

	public List<Ball> generateRandom() {
		Collections.shuffle(lottoBalls);
		return lottoBalls.stream()
			.limit(LOTTO_NUMBERS_LENGTH)
			.collect(Collectors.toList());
	}
}
