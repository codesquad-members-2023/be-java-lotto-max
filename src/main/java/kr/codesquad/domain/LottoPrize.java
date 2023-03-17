package kr.codesquad.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrize {
    Fifth(3, false, 5000),
    Fourth(4, false, 50000),
    Third(5, false, 1500000),
    Second(5, true, 30000000),
    First(6, false, 2000000000);

    public final int matchBalls;
    public final boolean bonus;
    public final int reward;

    LottoPrize(int matchBalls, boolean bonus, int reward) {
        this.matchBalls = matchBalls;
        this.bonus = bonus;
        this.reward = reward;
    }

    public static Optional<LottoPrize> getLottoPrize(int matchBalls, boolean bonus) {
        return Arrays.stream(LottoPrize.values())
                .filter(o -> o.matchBalls == matchBalls
                        && o.bonus == bonus)
                .findFirst();
    }
}
