package kr.codesquad.domain;

import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Lotto {
    public Lotto() {
    }

    public void start() throws IOException {
        // 입출력 인스턴스 생성
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 구입 금액
        outputView.requestLottoPurchaseMoney();
        int purchaseAmount = inputView.InputLottoPurchaseMoney();
        int lottoAmount = new LottoAmountInverter().invertMoneyToAmount(purchaseAmount);
        outputView.noticeLottoAmountNumber(lottoAmount);

        // 로또 발급
        List<List<Integer>> lottoLists = new LottoGenerator().generateLottoLists(lottoAmount);
        outputView.printLotto(lottoLists);

        // 당첨 번호
        outputView.requestWinningNumbers();
        List<Integer> winningNumbers = inputView.InputWinningNumbers();

        // 당첨 통계
        outputView.printFrameOfStatistics();
        LottoWinningStatisticsManager lottoWinningStatisticsManager = new LottoWinningStatisticsManager(lottoLists, winningNumbers);
        Map<Integer, Integer> matchingNumbersMap = lottoWinningStatisticsManager.checkMatchingNumbers();
        outputView.noticeMatchingFormat(matchingNumbersMap);
        outputView.noticeTotalYield(lottoWinningStatisticsManager.calculateTotalYield(purchaseAmount, matchingNumbersMap));
    }
}
