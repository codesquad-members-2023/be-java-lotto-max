package kr.codesquad.view;

public class OutputInfo {
    public static void printNumOfTicket(int numberOfTicket) {
        System.out.println(numberOfTicket + "개를 구매했습니다.");
    }

    public static void printLotteryNumbers(String ticketList) {
        System.out.println(ticketList);
    }

    public static void printLotteryResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n").append("---------\n");

    }
}
