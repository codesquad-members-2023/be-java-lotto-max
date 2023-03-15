package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("LottoAmountInverter 테스트")
class LottoAmountInverterTest {
    @Test
    @DisplayName("구입 금액으로 로또의 개수 변환하는 테스트")
    public void testInvertMoneyToAmount() {
        LottoAmountInverter lottoAmountInverter = new LottoAmountInverter();
        assertThat(lottoAmountInverter.invertMoneyToAmount(10000)).isEqualTo(10);
        assertThat(lottoAmountInverter.invertMoneyToAmount(303)).isEqualTo(-1);
    }
}