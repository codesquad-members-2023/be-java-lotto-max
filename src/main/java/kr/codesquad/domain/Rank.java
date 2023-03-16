package kr.codesquad.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int countOfMatch;
    private final int winningMoney;
    private int countOfLotto;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.countOfLotto = Config.ZERO;
    }

    public static void checkContainNumber(int countOfMatch) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            increaseContainNumber(rank, countOfMatch);
        }
    }

    private static void increaseContainNumber(Rank rank, int countOfMatch) {
        if (rank.countOfMatch == countOfMatch) {
            rank.countOfLotto++;
        }
    }

    public static double calculateTotalWinAmount() {
        Rank[] ranks = values();
        double sum = Config.ZERO;
        for (Rank rank : ranks) {
            System.out.println(rank.countOfMatch + "개 일치 ("
                    + rank.winningMoney + ")- " + rank.countOfLotto + "개");
            sum += rank.countOfLotto * rank.winningMoney;
        }
        return sum;
    }
}
