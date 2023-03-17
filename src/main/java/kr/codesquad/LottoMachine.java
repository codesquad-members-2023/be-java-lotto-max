package kr.codesquad;

import kr.codesquad.domain.LottoPapers;
import kr.codesquad.domain.WinningLotto;
import kr.codesquad.view.InputView;

import java.util.List;

public class LottoMachine {
    void run() {
        InputView inputView = new InputView();
        int purchaseCnt = inputView.buyLotto();
        LottoPapers lottoPapers = new LottoPapers(purchaseCnt);
        WinningLotto winningLotto = inputView.getWinningLotto();

        lottoPapers.showLottoStats(winningLotto, purchaseCnt * 1000);
    }

}
