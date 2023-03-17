package kr.codesquad.domain;

import kr.codesquad.view.LottoInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LuckyNumbersTest {
    @DisplayName("유효한 당첨 번호인지 확인하는 테스트")
    @Test
    public void validateLuckyNumbersTest() {
        Validator validator = new Validator();
        Set<String> answer1 = new HashSet<>(Set.of("1", "2", "3", "4", "5", "6"));
        Set<String> answer2 = new HashSet<>(Set.of("1", "2", "3"));
        Set<String> answer3 = new HashSet<>(Set.of("50", "2", "3", "4", "5", "6"));
        Set<String> answer4 = new HashSet<>(Set.of("A", "2", "3", "4", "5", "6"));
        Set<String> answer5 = new HashSet<>(Set.of("1", "3", "4", "5", "6"));
        answer5.add("1");

        boolean result1 = validator.checkLuckyNumbers(answer1);
        boolean result2 = validator.checkLuckyNumbers(answer2);
        boolean result3 = validator.checkLuckyNumbers(answer3);
        boolean result4 = validator.checkLuckyNumbers(answer4);
        boolean result5 = validator.checkLuckyNumbers(answer5);

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
        assertThat(result5).isFalse();
    }
}
