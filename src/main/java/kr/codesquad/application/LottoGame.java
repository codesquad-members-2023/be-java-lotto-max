package kr.codesquad.application;

import kr.codesquad.domain.Lottery;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public Lottery lottery;

    public void executeLottoGame() {
        outputView.init();

        inputView.printRequestPrice();
        makeLottery();
        outputView.printOrder(lottery.count, lottery.lottoList);

        inputView.printRequestWinningNumbers();
        setWinningNumbers();
        inputView.printRequestBonusNumber();
        setBonusBall();

        outputView.printStatistic(lottery.getStatistics(), lottery.calculateRateOfReturn());
    }

    private void makeLottery() {
        try {
            lottery = new Lottery(inputView.getIntegerInput());
            lottery.putLottoLines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            new OutputView().printErrorMsg();
            makeLottery();
        }
    }

    private void setWinningNumbers() {
        try {
            lottery.winningNumbers = inputView.getNumbersInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //todo : 갯수가 6개인지, 숫자가 입력되었는지, 1~45 사이의 숫자가 중복없이 입력되었는지 판별
        //todo : 0 일 경우 구매하지 않았다는 메세지 출력
    }

    public void setBonusBall() {
        try {
            lottery.bonusNumber = inputView.getIntegerInput();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            new OutputView().printErrorMsg();
            setBonusBall();
        }
    }
}
