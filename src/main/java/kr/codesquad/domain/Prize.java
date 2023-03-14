package main.java.kr.codesquad.domain;

public class Prize {
    private final int winningAmount;
    private final int conditionCount;

    public Prize(int winningAmount, int conditionCount) {
        this.winningAmount = winningAmount;
        this.conditionCount = conditionCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
