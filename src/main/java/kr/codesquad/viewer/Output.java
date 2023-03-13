package main.java.kr.codesquad.viewer;

public class Output {

    public void printTicketNumber(int ticketNumber) {
        System.out.println(ticketNumber + "개를 구매했습니다.");
    }

    public void printResult(String result) {
        System.out.println("당첨 통계" + "\n" + "------\n" + result);
    }
}
