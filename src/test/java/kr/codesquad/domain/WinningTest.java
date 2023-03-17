package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("Winning 테스트")
class WinningTest {
    @Test
    @DisplayName("Enum의 num을 입력하면 money가 성공적으로 가져와지는지 테스트")
    void getMoney() {
        assertThat(Winning.getMoney(3, false)).isEqualTo(5000);
        assertThat(Winning.getMoney(4, false)).isEqualTo(50000);
        assertThat(Winning.getMoney(5, false)).isEqualTo(1500000);
        assertThat(Winning.getMoney(5, true)).isEqualTo(30000000);
        assertThat(Winning.getMoney(6, false)).isEqualTo(2000000000);
    }
}