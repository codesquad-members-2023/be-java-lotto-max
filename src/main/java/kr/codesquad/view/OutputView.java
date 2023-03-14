package kr.codesquad.view;

import kr.codesquad.domain.Line;

import java.util.ArrayList;
import java.util.HashMap;

public class OutputView {
    public void init() {
        System.out.println("\n---로또 게임---\n");
    }

    public void printOrder(int count, ArrayList<Line> lottoList) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(count).append("개를 구매했습니다.\n");
        for (Line line : lottoList) {
            sb.append(line.numbers).append("\n");
        }
        System.out.println(sb);
    }

    public void printStatistic(HashMap<Integer,Integer> statistics, String profitRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5,000원) - " + statistics.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + statistics.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + statistics.get(5) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + statistics.get(6) + "개");
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    public void printErrorMsg() {
        System.out.println("올바르지 않은 숫자입니다. 다시 입력해주세요.");
    }
}
