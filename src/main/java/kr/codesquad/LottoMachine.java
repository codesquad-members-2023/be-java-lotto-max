package kr.codesquad;

import kr.codesquad.domain.LottoPapers;
import kr.codesquad.view.InputView;

import java.util.List;

public class LottoMachine {
    void run() {
        InputView inputView = new InputView();
        int purchaseCnt = inputView.buyLotto();
        LottoPapers lottoPapers = new LottoPapers(purchaseCnt);
        List<Integer> winNumbers = inputView.getWinNumbers();
        lottoPapers.showLottoStats(winNumbers, purchaseCnt * 1000);
    }

}
