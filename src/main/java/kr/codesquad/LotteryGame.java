package kr.codesquad;

import kr.codesquad.domain.LotteryEntry;
import kr.codesquad.domain.QuickPick;
import kr.codesquad.util.Conversion;
import kr.codesquad.util.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static kr.codesquad.view.InputInfo.payForLotto;
import static kr.codesquad.view.InputInfo.pickWinningNumber;
import static kr.codesquad.view.OutputInfo.printLotteryNumbers;
import static kr.codesquad.view.OutputInfo.printNumOfTicket;

public class LotteryGame {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws IOException {
        Validation validation = new Validation();
        int numberOfTicket = payForLotto(br, validation) / validation.minimumPrice;
        printNumOfTicket(numberOfTicket);
        QuickPick quickPick = new QuickPick();
        LotteryEntry lotteryEntry = new LotteryEntry(quickPick, numberOfTicket);
        printLotteryNumbers(lotteryEntry.stringifyTicketList());
        Conversion matcher = new Conversion();
        pickWinningNumber(br, validation, matcher);
    }

}
