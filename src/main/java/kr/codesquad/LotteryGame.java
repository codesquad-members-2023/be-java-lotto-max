package kr.codesquad;

import kr.codesquad.domain.*;
import kr.codesquad.util.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static kr.codesquad.view.InputInfo.payForLotto;
import static kr.codesquad.view.InputInfo.pickWinningNumber;
import static kr.codesquad.view.OutputInfo.*;

public class LotteryGame {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws IOException {
        //금액 입력
        Validation validation = new Validation();
        int payment = payForLotto(br, validation);
        int numberOfTicket = payment / validation.minimumPrice;
        printNumOfTicket(numberOfTicket);

        //자동 번호 생성 및 출력
        QuickPick quickPick = new QuickPick();
        LotteryEntry lotteryEntry = new LotteryEntry(quickPick, numberOfTicket);
        printLotteryNumbers(lotteryEntry.stringifyTicketList());

        //당첨 번호 입력
        Set<Integer> winningNumList = pickWinningNumber(br, validation); //winningNumList 저장

        //당첨금 및 수익률 계산
        NumberMatcher numberMatcher = new NumberMatcher();
        PrizeCalculator prizeCalculator = new PrizeCalculator();
        List<Integer> numberOfMatchList = numberMatcher.operate(lotteryEntry.issue(numberOfTicket), winningNumList);
        Map<Integer, Integer> rankMap = prizeCalculator.operateRank(numberOfMatchList);
        int totalPrize = prizeCalculator.operateProfitability(rankMap);
        double profitability = ((totalPrize - payment) / (double)payment) * 100;

        //당첨금 및 수익률 출력
        printLotteryResult(rankMap, profitability);

    }

}
