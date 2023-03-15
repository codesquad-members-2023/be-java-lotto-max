package main.java.kr.codesquad.domain;

import main.java.kr.codesquad.viewer.LottoInput;
import main.java.kr.codesquad.viewer.LottoOutput;

import java.io.IOException;

public class LottoGame {


    public void start() throws IOException {
        LottoInput input = new LottoInput();
        LottoOutput output = new LottoOutput();
        Amount amount = new Amount(input.getPurchaseAmount());
        TicketMaker ticketMaker = new TicketMaker(amount.calculateTicketCount());
        output.printTicketNumber(ticketMaker.toString());
        WinningNumbers winningNumbers = new WinningNumbers(input.getWinningNumbers());
        StatisticMaker statisticMaker = new StatisticMaker(winningNumbers.getNumbers(), ticketMaker.getTickets(), amount);
        output.printResult(statisticMaker.toString());
    }
}
