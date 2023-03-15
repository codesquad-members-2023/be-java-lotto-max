package main.java.kr.codesquad.viewer;

public class LottoOutput {
    //책임: 출력하기

    public void printTicketNumber(String ticketsInformation) {
        System.out.println(ticketsInformation);
    }

    public void printResult(String result) {
        System.out.println("당첨 통계" + "\n" + "------\n" + result);
    }
}
