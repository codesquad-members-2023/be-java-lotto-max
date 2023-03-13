package kr.codesquad.model;

import kr.codesquad.message.ErrorMessage;

/*
 * 로또 구입 금액을 의미하는 객체
 */
public class Money {

    public static final int LOTTO_PRICE_UNIT = 1000;

    private final int money;

    public Money(int money) {
        validateRange(money);
        validateUnit(money);
        this.money = money;
    }

    private void validateRange(int money) {
        if (money < LOTTO_PRICE_UNIT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.toString());
        }
    }

    private void validateUnit(int money) {
        if (money % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.toString());
        }
    }
}
