package kr.codesquad.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int countOfMatch;
    private final int winningMoney;
    private int containNumber;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.containNumber = 0;
    }

    public static void checkContainNumber(int countOfMatch) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            increaseContainNumber(rank, countOfMatch);
        }
    }

    private static void increaseContainNumber(Rank rank, int countOfMatch) {
        if (rank.countOfMatch == countOfMatch) {
            rank.containNumber++;
        }
    }

    public static void printLottoStats(LottoCustomer lottoCustomer) {
        Rank[] ranks = values();
        double sum = 0;
        for (Rank rank : ranks) {
            System.out.println(rank.countOfMatch + "개 일치 ("
                    + rank.winningMoney + ")- " + rank.containNumber + "개");
            sum += rank.containNumber * rank.winningMoney;
        }
        System.out.println("총 수익률은 " + sum / lottoCustomer.getPurchaseAmount() * 100 + "% 입니다.");
    }
}
