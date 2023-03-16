package kr.codesquad.view;

import kr.codesquad.domain.LottoCustomer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

public class LottoInputTest {
    @DisplayName("손님의 구입 금액 입력에 따른 결과 확인")
    @Test
    public void InputLottoTest() throws IOException {
        LottoCustomer lottoCustomer = new LottoCustomer();
        boolean result1 = LottoInput.inputPurchaseAmount(lottoCustomer, "3000");
        boolean result2 = LottoInput.inputPurchaseAmount(lottoCustomer, "a");
        boolean result3 = LottoInput.inputPurchaseAmount(lottoCustomer, "0");

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
    }
}
