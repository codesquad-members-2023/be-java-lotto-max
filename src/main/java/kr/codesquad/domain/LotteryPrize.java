package kr.codesquad.domain;

import java.util.Arrays;

public enum LotteryPrize {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FORTH_PLACE(3, 5000);

    private final int numberOfMatches;
    private final int prize;

    LotteryPrize(int numberOfMatches, int prize) {
        this.numberOfMatches = numberOfMatches;
        this.prize = prize;
    }

    public static LotteryPrize fromNumOfMatches(int numOfMatches) {
        return Arrays.stream(LotteryPrize.values())
                .filter(prize -> prize.getNumberOfMatches() == numOfMatches)
                .findFirst()
                .orElse(null);
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getPrize() {
        return prize;
    }
}
