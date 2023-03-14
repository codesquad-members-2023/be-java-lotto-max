package kr.codesquad.domain;

public class LottoAmountInverter {
    public LottoAmountInverter() {
    }

    public int invertMoneyToAmount(int lottoPurchaseMoney) {
        if (lottoPurchaseMoney % 1000 != 0) {
            return -1;
        }

        return lottoPurchaseMoney / 1000;
    }
}
