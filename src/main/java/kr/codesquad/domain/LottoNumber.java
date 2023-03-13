package kr.codesquad.domain;

import java.util.Arrays;

public enum LottoNumber {
	THREE(3, 5000),
	FOUR(4, 50_000),
	FIVE(5, 1_500_000),
	BONUS(5, 3_000_000),
	SIX(6, 2_000_000_000);

	private final int matchingNumbers;
	private final int prize;

	LottoNumber(int matchingNumbers, int prize) {
		this.matchingNumbers = matchingNumbers;
		this.prize = prize;
	}

	public static Integer getKey(int prize){
		return Arrays.stream(values())
			.filter(statistic -> statistic.prize == prize)
			.findFirst()
			.orElseThrow().prize;
	}
	public static LottoNumber getRank(int numberOfMatch) {
		return Arrays.stream(values())
			.filter(statistic -> statistic.matchingNumbers == numberOfMatch)
			.findFirst()
			.orElseThrow();
	}

	public int getMatchingNumbers() {
		return matchingNumbers;
	}

	public int getPrize() {
		return prize;
	}

	public String toString(){
		if(this.getPrize()==3_000_000){
			return this.getMatchingNumbers() + "개 일치, 보너스 볼 일치 (" + this.getPrize() + ")원 - ";
		}
		return this.getMatchingNumbers() + "개 일치 (" + this.getPrize() + ")원 - ";

	}


}
