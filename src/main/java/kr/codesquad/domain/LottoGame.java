package main.java.kr.codesquad.domain;

import main.java.kr.codesquad.viewer.Input;
import main.java.kr.codesquad.viewer.Output;

import java.io.IOException;

public class LottoGame {


    public void start() throws IOException {
        Input input = new Input();
        Output output = new Output();
        Amount amount = new Amount(input.getBuyAmount());
        TicketMaker ticketMaker = new TicketMaker(input.getBuyAmount());
        output.printTicketNumber(ticketMaker.toString());
        Result result = ticketMaker.createResult();
        output.printResult(result.toString);
    }
}
