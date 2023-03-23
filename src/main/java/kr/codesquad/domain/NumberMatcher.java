package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NumberMatcher {

    public List<Integer> operate(List<Ticket> ticketList, Set<Integer> winningNumList) {
        List<Integer> numberOfMatchList = new ArrayList<>();
        for (Ticket ticket : ticketList) {
            scanTicket(ticket, winningNumList, numberOfMatchList);
        }
        return numberOfMatchList;
    }

    private void scanTicket(Ticket ticket, Set<Integer> winningNumList, List<Integer> numberOfMatchList) {
        int count = 0;
        for (int eachTicketNums : ticket.quickPickNumbers) {
            if (winningNumList.contains(eachTicketNums)) count++;
        }
        numberOfMatchList.add(count);
    }
}
