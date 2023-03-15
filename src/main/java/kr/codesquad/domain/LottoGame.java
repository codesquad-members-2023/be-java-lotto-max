package kr.codesquad.domain;

import kr.codesquad.view.LottoInput;

import java.io.IOException;

public class LottoGame {
    public void start() throws IOException {
        LottoCustomer lottoCustomer = new LottoCustomer();
        boolean validPurchaseAmount = false;

        validPurchaseAmount(lottoCustomer, validPurchaseAmount);

    }

    private void validPurchaseAmount(LottoCustomer lottoCustomer, boolean validPurchaseAmount) throws IOException {
        while (!validPurchaseAmount) {
            String answer = LottoInput.inputAnswer(0);
            validPurchaseAmount = LottoInput.inputPurchaseAmount(lottoCustomer, answer);
        }
    }
}
