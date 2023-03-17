package kr.codesquad.domain;

import java.util.List;

public class WinningLotto {
    private final int bonus;
    private final List<Integer> balls;

    public WinningLotto(List<Integer> balls, int bonus) {
        this.balls = balls;
        this.bonus = bonus;
    }
}
