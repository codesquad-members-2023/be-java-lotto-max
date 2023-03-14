package main.java.kr.codesquad.domain;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class TicketMaker {



    private ArrayList<Ticket> tickets = new ArrayList<>();

    private int amount;

    public TicketMaker(String inputAmount){
        this.amount = Integer.parseInt(inputAmount);
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        this.createTickets(this.amount, lottoNumberGenerator);
    }

    private void createTickets(int Amount, LottoNumberGenerator lottoNumberGenerator) {
        for (int i = 0; i < Amount/this.ticketPrice; i++){
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
