package main.java.kr.codesquad.viewer;

import main.java.kr.codesquad.domain.Ticket;

import java.util.ArrayList;

public class Output {

    public void printTicketNumber(ArrayList<Ticket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Ticket ticket : tickets){
            System.out.println(ticket.toString());
        }
    }

    public void printResult(String result) {
        System.out.println("당첨 통계" + "\n" + "------\n" + result);
    }
}
