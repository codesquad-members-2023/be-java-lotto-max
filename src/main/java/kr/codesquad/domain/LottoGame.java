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
        lottoCustomer.purchaseLotto();
        LottoOutput.printLotto(lottoCustomer);

        ArrayList<Integer> luckyNumbers = LottoInput.inputLuckyNumber();
        Collections.sort(luckyNumbers);

        lottoCustomer.checkLuckyNumbers(luckyNumbers);
        LottoOutput.printLottoStats(lottoCustomer);
    }

    private void checkPurchaseAmount(LottoCustomer lottoCustomer, boolean validPurchaseAmount) throws IOException {
        while (!validPurchaseAmount) {
            String purchaseAmount = LottoInput.inputAnswer(Config.ASK_PURCHASE_AMOUNT_NUMBER);
            validPurchaseAmount = LottoInput.inputPurchaseAmount(lottoCustomer, purchaseAmount);
        }
    }
}
