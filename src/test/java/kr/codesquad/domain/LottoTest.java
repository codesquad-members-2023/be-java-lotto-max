package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @DisplayName("로또 번호가 랜덤으로 생성되는지 확인하는 테스트")
    @Test
    public void LottoCreateTest() {
        Lotto lotto1 = new Lotto();
        Lotto lotto2 = new Lotto();
        Lotto lotto3 = new Lotto();

        System.out.println(lotto1);
        System.out.println(lotto2);
        System.out.println(lotto3);

        assertThat(lotto1.toString()).isNotEqualTo(lotto2.toString());
        assertThat(lotto2.toString()).isNotEqualTo(lotto3.toString());
    }
}
