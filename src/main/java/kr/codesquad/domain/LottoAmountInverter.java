package kr.codesquad.domain;

public class LottoAmountInverter {
    private static final int ONE_TICKET = 1000;

    public LottoAmountInverter() {
    }

    // 상수 처리
    public int invertMoneyToAmount(int lottoPurchaseMoney) {
        if (lottoPurchaseMoney % ONE_TICKET != 0) {
            return -1;
        }

        return lottoPurchaseMoney / ONE_TICKET;
    }
}
