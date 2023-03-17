package kr.codesquad.view;

import kr.codesquad.domain.LottoCustomer;
import kr.codesquad.domain.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoInputTest {
    @DisplayName("손님의 구입 금액 입력에 따른 결과 확인")
    @Test
    public void InputLottoTest() {
        LottoCustomer lottoCustomer = new LottoCustomer();
        boolean result1 = Validator.checkPurchaseAmount(lottoCustomer, "3000");
        boolean result2 = Validator.checkPurchaseAmount(lottoCustomer, "a");
        boolean result3 = Validator.checkPurchaseAmount(lottoCustomer, "0");

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
    }
}
