package kr.codesquad.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningTest {
    @Test
    void getMoney() {
        assertThat(Winning.getMoney(3)).isEqualTo(5000);
        assertThat(Winning.getMoney(4)).isEqualTo(50000);
        assertThat(Winning.getMoney(5)).isEqualTo(1500000);
        assertThat(Winning.getMoney(6)).isEqualTo(2000000000);
    }
}