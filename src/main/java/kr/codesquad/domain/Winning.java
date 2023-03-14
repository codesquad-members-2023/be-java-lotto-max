package kr.codesquad.domain;

import java.util.Arrays;

public enum Winning {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);


    private final int num;
    private final int money;

    Winning(int num, int money) {
        this.num = num;
        this.money = money;
    }

    public static int getMoney(int num) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.num == num)
                .findFirst()
                .map(winning -> winning.money)
                .orElse(0);
    }
}
