package kr.codesquad.view;

import kr.codesquad.domain.LottoCustomer;
import kr.codesquad.domain.Rank;

public class LottoOutput {
    public static void printLotto(LottoCustomer lottoCustomer) {
        System.out.println(lottoCustomer.getLotteriesSize() + "개를 구매했습니다.");
        System.out.println(lottoCustomer);
    }

    public static void printLottoStats(LottoCustomer lottoCustomer) {
        System.out.println("당첨 통계");
        System.out.println("--------------------------------");
        Rank.printLottoStats(lottoCustomer);
    }
}
