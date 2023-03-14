package kr.codesquad;

import kr.codesquad.domain.LottoAmountInverter;
import kr.codesquad.domain.LottoGenerator;
import kr.codesquad.domain.LottoWinningStatisticsManager;
import kr.codesquad.view.LottoInput;
import kr.codesquad.view.LottoOutput;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LottoManager {
    public LottoManager() {
    }

    public void start() throws IOException {
        // 입출력 인스턴스 생성
        LottoInput lottoInput = new LottoInput();
        LottoOutput lottoOutput = new LottoOutput();

        // 구입 금액
        int purchaseAmount = lottoInput.InputLottoPurchaseMoney();
        int lottoAmount = new LottoAmountInverter().invertMoneyToAmount(purchaseAmount);
        lottoOutput.noticeLottoAmountNumber(lottoAmount);

        // 로또 발급
        List<List<Integer>> lottoLists = new LottoGenerator().generateLottoLists(lottoAmount);
        lottoOutput.printLotto(lottoLists);

        // 당첨 번호
        List<Integer> winningNumbers = lottoInput.InputWinningNumbers();
        // 보너스 볼
        int bonusNumber = lottoInput.InputBonus();

        // 당첨 통계
        LottoWinningStatisticsManager lottoWinningStatisticsManager = new LottoWinningStatisticsManager(bonusNumber);
        Map<Integer, Integer> matchingNumbersMap = lottoWinningStatisticsManager.checkMatchingNumbers(lottoLists, winningNumbers);
        int bonusCount = lottoWinningStatisticsManager.getBonusCount();
        lottoOutput.noticeMatchingFormat(matchingNumbersMap, bonusCount);
        lottoOutput.noticeTotalYield(lottoWinningStatisticsManager.calculateTotalYield(purchaseAmount, matchingNumbersMap, bonusCount));
    }
}
