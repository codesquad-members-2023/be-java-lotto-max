package kr.codesquad.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Prize {
	FIRST(Constants.FIRST_MATCH_COUNT, Constants.FIRST_PRIZE_PRIZE),
	BONUS(Constants.BONUS_NUMBER, Constants.BONUS_PRIZE_MONEY),
	SECOND(Constants.SECOND_MATCH_COUNT, Constants.SECOND_PRIZE_MONEY),
	THIRD(Constants.THIRD_MATCH_COUNT, Constants.THIRD_PRIZE_MONEY),
	FOURTH(Constants.FOURTH_MATCH_COUNT, Constants.FOURTH_PRIZE_MONEY),
	NONE(Constants.NONE_MATCH_COUNT, Constants.NONE_PRIZE_MONEY);

	private final int matchCount;
	private final int prizeMoney;

	Prize(int matchCount, int prizeMoney) {
		this.matchCount = matchCount;
		this.prizeMoney = prizeMoney;
	}

	public static Prize createByMatchCount(int matchCount,boolean containBonus) {
		Prize[] values = Prize.values();
		Optional<Prize> any = Arrays.stream(values)
			.filter(value -> value.getMatchCount() == matchCount)
			.findAny();
		Prize prize = any.orElse(NONE);
		if (prize == SECOND && containBonus ) {
			return Prize.BONUS;
		}
		return prize;
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

	private static class Constants {
		public static final int FIRST_PRIZE_PRIZE = 2000000000;
		public static final int BONUS_PRIZE_MONEY = 30000000;
		public static final int SECOND_PRIZE_MONEY = 1500000;
		public static final int THIRD_PRIZE_MONEY = 50000;
		public static final int FOURTH_PRIZE_MONEY = 5000;
		public static final int NONE_PRIZE_MONEY = 0;
		public static final int FIRST_MATCH_COUNT = 6;
		public static final int BONUS_NUMBER = 5;
		public static final int SECOND_MATCH_COUNT = 5;
		public static final int THIRD_MATCH_COUNT = 4;
		public static final int FOURTH_MATCH_COUNT = 3;
		public static final int NONE_MATCH_COUNT = 0;
	}
}
