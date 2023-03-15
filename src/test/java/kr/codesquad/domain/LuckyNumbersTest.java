package kr.codesquad.domain;

import kr.codesquad.view.LottoInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LuckyNumbersTest {
    @DisplayName("유효한 당첨 번호인지 확인하는 테스트")
    @Test
    public void validateLuckyNumbersTest() {
        String[] answer1 = {"1", "2", "3", "4", "5", "6"};
        String[] answer2 = {"1", "2", "3"};
        String[] answer3 = {"50", "2", "3", "4", "5", "6"};
        String[] answer4 = {"A", "2", "3", "4", "5", "6"};

        boolean result1 = LottoInput.checkLuckyNumbers(answer1);
        boolean result2 = LottoInput.checkLuckyNumbers(answer2);
        boolean result3 = LottoInput.checkLuckyNumbers(answer3);
        boolean result4 = LottoInput.checkLuckyNumbers(answer4);

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
    }
}
