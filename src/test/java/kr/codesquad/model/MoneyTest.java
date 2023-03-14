package kr.codesquad.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import kr.codesquad.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @ParameterizedTest
    @DisplayName("1000원 미만일 때 예외 발생")
    @ValueSource(ints = {999, 0, -1})
    void rangeTest(int input) {
        // Exception 테스트 방법1:
        assertThrows(IllegalArgumentException.class, () -> new Money(input));

        // Exception 테스트 방법2:
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);

        // Exception 테스트 방법3:
//        Exception e = catchException(() -> new Money(input));
        Throwable e = assertThrows(IllegalArgumentException.class, () -> new Money(input));

        assertThat(e).isInstanceOf(IllegalArgumentException.class);
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.INVALID_MONEY.toString());
    }

    @ParameterizedTest
    @DisplayName("1000원 단위가 아닐 때 예외 발생")
    @ValueSource(ints = {1999, 1500})
    void unitTest(int input) {
        assertThrows(IllegalArgumentException.class, () -> new Money(input));
    }

}
