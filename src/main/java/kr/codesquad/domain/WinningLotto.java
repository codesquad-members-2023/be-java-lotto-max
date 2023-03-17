package kr.codesquad.domain;

import java.util.List;
import java.util.Optional;

public class WinningLotto {
    private final int bonus;
    private final List<Integer> balls;

    public WinningLotto(List<Integer> balls, int bonus) {
        this.balls = balls;
        this.bonus = bonus;
    }

    public Optional<LottoPrize> matchLotto(Lotto lotto) {
        int matches = this.balls.stream()
                .mapToInt(num -> lotto.contains(num) ? 1 : 0)
                .sum();
        boolean isBonus = lotto.contains(this.bonus);
        return LottoPrize.getLottoPrize(matches, isBonus);
    }
}
