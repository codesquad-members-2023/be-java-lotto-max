package kr.codesquad.message;

import kr.codesquad.model.Money;

/**
 * 에러 메시지 내용을 저장한 Enum
 */
public enum ErrorMessage {

    EMPTY_INPUT_ERROR("입력 값이 비어있습니다."),
    INVALID_INPUT_TYPE("로또 구입 금액은 숫자만 입력 가능합니다."),
    INVALID_MONEY(String.format("로또 구입 금액은 %d원 단위로 입력 가능합니다.", Money.LOTTO_PRICE_UNIT));

    private static final String ERROR = "[ERROR] ";

    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR + message;
    }
}
