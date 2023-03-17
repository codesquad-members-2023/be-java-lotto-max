package kr.codesquad.config;

import java.util.stream.Stream;

/**
 * 로또 당첨 조건을 저장한 Enum
 */
public enum Ranking {

    RANK1(6, false, 2_000_000_000),
    RANK2(5, true,30_000_000),
    RANK3(5, false,  1_500_000),
    RANK4(4, false, 50_000),
    RANK5(3, false, 5_000),
    NO_RANK(0, false, 0);

    public final int winningCondition;
    public final boolean matchesBonusNumber;
    public final int prize;

    Ranking(int winningCondition, boolean matchesBonusNumber, int prize) {
        this.winningCondition = winningCondition;
        this.matchesBonusNumber = matchesBonusNumber;
        this.prize = prize;
    }

    /**
     * 로또 번호 일치 개수, 보너스 번호 일치 여부를 확인해 당첨 등수를 계산하는 메서드
     * @param winningCondition 로또 번호 일치 개수
     * @param matchesBonusNumber 보너스 번호 일치 여부
     * @return 로또 당첨 등수
     */
    public static Ranking rankOf(int winningCondition, boolean matchesBonusNumber) {
        return Stream.of(Ranking.values())
                .filter(ranking ->
                        ranking.winningCondition == winningCondition
                                && ranking.matchesBonusNumber == matchesBonusNumber)
                .findAny()
                .orElse(NO_RANK);
    }
}
