package kr.codesquad.util;

public enum ErrorMessage {
	NOT_MULTIPLE_OF_THOUSAND("천원 단위로 입력하세요"),
	NOT_INTEGER_NUMBER("숫자를 입력해주세요."),
	NUMBER_OVER_OR_UNDER_LOTTO_NUMBER("1과 46 사이의 수를 입력해주세요"),
	INVALID_LOTTO_NUMBERS_SIZE("로또 숫자 개수는 6개 입니다."),
	NOT_INCLUDE_BONUS_NUMBER_IN_LOTTO("보너스 번호는 당첨 번호안에 포함되면 안됩니다.");
	private String errorMessage;

	ErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
