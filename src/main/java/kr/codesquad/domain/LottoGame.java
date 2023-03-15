package kr.codesquad.domain;

import kr.codesquad.view.LottoInput;
import kr.codesquad.view.LottoOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class LottoGame {
    public void start() throws IOException {
        LottoCustomer lottoCustomer = new LottoCustomer();
        boolean validPurchaseAmount = false;

        checkPurchaseAmount(lottoCustomer, validPurchaseAmount);
        lottoCustomer.purchaseNumberOfLotto();
        LottoOutput.printLotto(lottoCustomer);

        ArrayList<Integer> luckyNumbers = LottoInput.inputLuckyNumber();
        Collections.sort(luckyNumbers);
    }

    private void checkPurchaseAmount(LottoCustomer lottoCustomer, boolean validPurchaseAmount) throws IOException {
        while (!validPurchaseAmount) {
            String answer = LottoInput.inputAnswer(0);
            validPurchaseAmount = LottoInput.inputPurchaseAmount(lottoCustomer, answer);
        }
    }
}
