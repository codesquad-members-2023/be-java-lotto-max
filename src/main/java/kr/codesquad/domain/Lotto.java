package kr.codesquad.domain;

import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;
import java.util.List;

public class Lotto {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public Lotto() {
    }

    public void start() throws IOException {
        outputView.outputRequestLottoPurchaseMoney();
        int lottoPurchaseMoney = inputView.InputLottoPurchaseMoney();
        LottoAmountInverter lottoAmountInverter = new LottoAmountInverter();
        int lottoAmount = lottoAmountInverter.invertMoneyToAmount(lottoPurchaseMoney);
        outputView.outputLottoAmountNumber(lottoAmount);

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<List<Integer>> lottoLists = lottoGenerator.generateLottoLists(lottoAmount);
        outputView.outputLotto(lottoLists);
    }
}
