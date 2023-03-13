package kr.codesquad.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Prize {
	FIRST(6, 2000000000), SECOND(5, 1500000), THIRD(4, 50000), FOURTH(3, 5000), NONE(0, 0);

	private final int matchCount;
	private final int prizeMoney;

	Prize(int matchCount, int prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public static Prize create(int matchCount) {
		Prize[] values = Prize.values();
		Optional<Prize> any = Arrays.stream(values)
			.filter(value -> value.getMatchCount() == matchCount)
			.findAny();
		return any.orElse(NONE);
	}

	public static List<Prize> getWinningPrize() {
		return Arrays.stream(Prize.values())
			.filter(prize -> prize != Prize.NONE)
			.sorted(Collections.reverseOrder())
			.collect(Collectors.toList());
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}
}
