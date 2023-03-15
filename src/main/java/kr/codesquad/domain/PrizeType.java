package main.java.kr.codesquad.domain;

public enum PrizeType {

    FIRST_PRIZE(2_000_000_000, 6),

    SECOND_PRIZE(1_500_000, 5),

    THIRD_PRIZE(50_000, 4),

    FOURTH_PRIZE(5_000, 3);


    private int prizeAmount;
    private int matchingNumberCount;

    PrizeType(int prizeAmount, int matchingNumberCount) {
        this.prizeAmount = prizeAmount;
        this.matchingNumberCount = matchingNumberCount;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

}
