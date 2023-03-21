package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryEntry {

    private final List<Ticket> ticketList = new ArrayList<>();
    private QuickPick quickPick;

    public LotteryEntry(QuickPick quickPick, int numberOfTicket) {
        this.quickPick = quickPick;
        this.issue(numberOfTicket);
    }

    public void issue(int numberOfTicket) {
        for(int i = 0; i < numberOfTicket; i++) {
            ticketList.add(new Ticket(quickPick.create()));
        }
    }

    public String stringifyTicketList() {
        StringBuilder sb = new StringBuilder();
        for(Ticket ticket : ticketList) {
            sb.append(ticket.format(ticket)).append("\n");
        }
        return sb.toString();
    }
}
