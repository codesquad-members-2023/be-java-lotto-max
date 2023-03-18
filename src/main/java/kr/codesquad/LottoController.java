package kr.codesquad;

import kr.codesquad.model.Lotto;
import kr.codesquad.model.LottoNumber;
import kr.codesquad.model.Lottos;
import kr.codesquad.model.Money;
import kr.codesquad.model.WinningLotto;
import kr.codesquad.model.WinningResult;
import kr.codesquad.service.LottoService;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LottoController {

    public void run() {
        Money money = readMoney();

        LottoService lottoService = new LottoService(money);
        Lottos lottos = lottoService.generateLotto();

        OutputView.printPurchaseInfo(money.getLottoCount(), lottos);

        WinningLotto winningLotto = getWinningLottoWithBonusNumber();
        WinningResult winningResult = new WinningResult(winningLotto, lottos);

        OutputView.printWinningStatistics(winningResult.getStatistics(), winningResult.getProfitRate());
    }

    private Money readMoney() {
        try {
            return InputView.readMoney();
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
        }
        return readMoney();
    }

    private WinningLotto getWinningLottoWithBonusNumber() {
        Lotto winningNumber = readWinningNumber();
        try {
            LottoNumber bonusNumber = InputView.readBonusNumber();
            return new WinningLotto(winningNumber, bonusNumber);
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
        }
        return getWinningLottoWithBonusNumber();
    }

    private Lotto readWinningNumber() {
        try {
            return InputView.readWinningNumber();
        } catch (IllegalArgumentException ie) {
            OutputView.printError(ie.getMessage());
        }
        return readWinningNumber();
    }
}
