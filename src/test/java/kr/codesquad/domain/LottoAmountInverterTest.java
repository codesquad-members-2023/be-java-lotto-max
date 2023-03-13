package kr.codesquad.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoAmountInverterTest {
    @Test
    public void testInvertMoneyToAmount() {
        LottoAmountInverter lottoAmountInverter = new LottoAmountInverter();
        assertThat(lottoAmountInverter.invertMoneyToAmount(10000)).isEqualTo(10);
        assertThat(lottoAmountInverter.invertMoneyToAmount(303)).isEqualTo(-1);
    }
}