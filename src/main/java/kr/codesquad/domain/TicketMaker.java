package main.java.kr.codesquad.domain;

import java.util.ArrayList;

public class TicketMaker {
    //책임: 티켓 생성

    private ArrayList<Ticket> tickets = new ArrayList<>();


    public TicketMaker(int ticketCount){
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        this.createTickets(ticketCount, lottoNumberGenerator);
    }

    //로또 번호 생성자로 번호를 받아 티켓 개수 만큰 티켓 생성
    private void createTickets(int ticketCount, LottoNumberGenerator lottoNumberGenerator) {
        for (int i = 0; i < ticketCount; i++){
            tickets.add(new Ticket(lottoNumberGenerator.generateLottoNumbers()));
        }
    }


    //각 티켓 정보 출력
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(tickets.size() + "개를 구매했습니다.\n");
        for(Ticket ticket: tickets){
            sb.append(ticket.toString()).append("\n");
        }

        return sb.toString();
    }

    public ArrayList<Ticket> getTickets() {
        return this.tickets;
    }
}
