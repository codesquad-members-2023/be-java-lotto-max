package kr.codesquad.view;

import kr.codesquad.message.ErrorMessage;

public class InputValidator {

    public static void validateHasInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT_ERROR.toString());
        }
    }

    public static void validateSeparatedByDelimiter(String input, String delimiter) {
        if (!input.contains(delimiter)) {
            throw new IllegalArgumentException();
        }
    }
}
