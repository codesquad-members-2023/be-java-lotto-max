package main.java.kr.codesquad.viewer;

import main.java.kr.codesquad.domain.Ticket;

import java.util.ArrayList;

public class Output {

    public void printTicketNumber(String ticketsInformation) {
        System.out.println(ticketsInformation);
    }

    public void printResult(String result) {
        System.out.println("당첨 통계" + "\n" + "------\n" + result);
    }
}
