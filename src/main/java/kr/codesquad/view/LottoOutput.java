package kr.codesquad.view;

import kr.codesquad.domain.LottoCustomer;

public class LottoOutput {
    public static void printLotto(LottoCustomer lottoCustomer) {
        System.out.println(lottoCustomer.getLotteriesSize() + "개를 구매했습니다.");
        System.out.println(lottoCustomer);
    }
}
