package kr.codesquad.domain;

import kr.codesquad.view.LottoInput;

import java.io.IOException;

public class LottoGame {
    public void start() throws IOException {
        Lotto lotto = new Lotto();
        while (!LottoInput.inputPurchaseAmount()) {}
        while (!LottoInput.inputLuckyNumber(lotto)) {}
    }
}
