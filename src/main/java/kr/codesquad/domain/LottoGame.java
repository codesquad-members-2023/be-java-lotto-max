package main.java.kr.codesquad.domain;

public class LottoGame {


    public void start() {
        Input input = new Input();
        TicketMaker ticketMaker = new TicketMaker(input.getBuyAmount());
        Result result = new Result(ticketMaker.getTickets(), ticketMaker.getAmount());
        Output output = new Output();
        output.printResult(result.toString);
    }
}
