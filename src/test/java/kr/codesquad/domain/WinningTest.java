package kr.codesquad.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("Winning 테스트")
class WinningTest {
    @Test
    @DisplayName("Enum의 num을 입력하면 money가 성공적으로 가져와지는지 테스트")
    void getMoney() {
        assertThat(Winning.getMoney(3)).isEqualTo(5000);
        assertThat(Winning.getMoney(4)).isEqualTo(50000);
        assertThat(Winning.getMoney(5)).isEqualTo(1500000);
        assertThat(Winning.getMoney(6)).isEqualTo(2000000000);
    }
}