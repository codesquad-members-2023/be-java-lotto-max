package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCustomerTest {
    @DisplayName("손님의 구입 금액 이하로 살 수 있는 로또를 모두 사는지 확인한다.")
    @Test
    public void CustomerPurchaseLottoTest() {
        String answer1 = "3000";
        String answer2 = "2500";
        LottoCustomer lottoCustomer1 = new LottoCustomer();
        LottoCustomer lottoCustomer2 = new LottoCustomer();

        lottoCustomer1.putCustomerPurchaseAmount(answer1);
        lottoCustomer2.putCustomerPurchaseAmount(answer2);
        lottoCustomer1.decideNumberOfLotto();
        lottoCustomer2.decideNumberOfLotto();

        System.out.println(lottoCustomer1);
        System.out.println();
        System.out.println(lottoCustomer2);
    }
}
