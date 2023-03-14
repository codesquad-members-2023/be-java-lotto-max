package main.java.kr.codesquad.domain;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class TicketMaker {

    private ArrayList<Ticket> tickets = new ArrayList<>();


    public TicketMaker(int ticketCount){
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        this.createTickets(ticketCount, lottoNumberGenerator);
    }

    private void createTickets(int ticketCount, LottoNumberGenerator lottoNumberGenerator) {
        for (int i = 0; i < ticketCount; i++){
            tickets.add(new Ticket(lottoNumberGenerator.createLottoNumber()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(tickets.size() + "개를 구매했습니다.\n");
        for(Ticket ticket: tickets){
            sb.append(ticket.toString()).append("\n");
        }

        return sb.toString();
    }

    public Result createResult() {
        return new Result(this.tickets, this.amount);
    }
}
