package kr.codesquad.domain;

import java.util.Arrays;

public enum Winning {

    THREE(3, 5000, false),
    FOUR(4, 50000, false),
    // 메서드 작성
    FIVE(5, 1500000, false),
    FIVE_BONUS(5, 30000000, true),
    SIX(6, 2000000000, false);


    private final int num;
    private final int money;
    private final boolean isBonus;

    Winning(int num, int money, boolean isBonus) {
        this.num = num;
        this.money = money;
        this.isBonus = isBonus;
    }

    public static int getMoney(int num, boolean isBonus) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.num == num && winning.isBonus == isBonus)
                .findFirst()
                .map(winning -> winning.money)
                .orElse(0);
    }
}
