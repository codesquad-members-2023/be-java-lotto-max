package kr.codesquad.domain;

import java.util.Arrays;
import java.util.Collections;

public enum Rank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    private final int countOfMatch;
    private final int winningMoney;
    private final boolean bonusBall;
    private int countOfLotto;

    Rank(int countOfMatch, int winningMoney, boolean bonusBall) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.bonusBall = bonusBall;
        this.countOfLotto = Config.ZERO;
    }

    public static void checkContainNumber(int countOfMatch, boolean bonusBall) {
        Arrays.stream(values()).forEach(s -> increaseContainNumber(s, countOfMatch, bonusBall));
    }

    private static void increaseContainNumber(Rank rank, int countOfMatch, boolean bonusBall) {
        if (rank.countOfMatch == countOfMatch && rank.bonusBall == bonusBall) {
            rank.countOfLotto++;
        }
    }

    public static double calculateTotalWinAmount() {
        Rank[] ranks = values();
        double sum = Config.ZERO;
        for (Rank rank : ranks) {
            sum += rank.countOfLotto * rank.winningMoney;
        }
        return sum;
    }

    public static void printLottoStats() {
        Arrays.stream(values())
                .sorted(Collections.reverseOrder())
                .forEach(rank -> System.out.println(rank.countOfMatch
                        + "개 일치 " + ((rank.bonusBall)? ", 보너스 볼 일치 ": "")
                        + "(" + rank.winningMoney + "원)- " + rank.countOfLotto + "개"));
    }
}
