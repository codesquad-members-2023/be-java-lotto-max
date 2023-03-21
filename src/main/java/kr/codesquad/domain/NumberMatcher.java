package kr.codesquad.domain;

import java.util.List;
import java.util.Set;

public class NumberMatcher {

    public int operate(List<Ticket> ticketList, Set<Integer> winningNumList) {
        int numberOfMatchNums = 0;
        for (Ticket ticket : ticketList) {
            scanTicket(ticket, winningNumList, numberOfMatchNums);
        }
        return numberOfMatchNums;
    }

    private void scanTicket(Ticket ticket, Set<Integer> winningNumList, int numberOfMatchNums) {
        for (int eachTicketNums : ticket.quickPickNumbers) {
            if (winningNumList.contains(eachTicketNums)) numberOfMatchNums++;
        }
    }
}
