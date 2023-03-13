package main.java.kr.codesquad.domain;

import main.java.kr.codesquad.viewer.Input;
import main.java.kr.codesquad.viewer.Output;

import java.io.IOException;

public class LottoGame {


    public void start() throws IOException {
        Input input = new Input();
        Output output = new Output();
        TicketMaker ticketMaker = new TicketMaker(input.getBuyAmount());
        output.printTicketNumber(ticketMaker.getTicekts().size());
        Result result = new Result(ticketMaker.getTickets(), ticketMaker.getAmount());
        output.printResult(result.toString);
    }
}
