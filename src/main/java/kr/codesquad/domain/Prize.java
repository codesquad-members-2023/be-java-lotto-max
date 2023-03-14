package main.java.kr.codesquad.domain;

public enum Prize {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    SIX_MATCH(6, 2_000_000_000);

    private final int matchingNumbers;
    private final int winningAmount;

    Prize(int matchingNumbers, int winningAmount) {
        this.matchingNumbers = matchingNumbers;
        this.winningAmount = winningAmount;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
