package kr.codesquad.domain;

import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class Lotto {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public Lotto() {
    }

    public void start() throws IOException {
        outputView.outputRequestLottoPurchaseMoney();
        inputView.InputLottoPurchaseMoney();
    }
}
