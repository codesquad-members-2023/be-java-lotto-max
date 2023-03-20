package kr.codesquad.view;

import kr.codesquad.domain.Intersection;
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

    public void printStatistic(HashMap<Intersection, Integer> statistics, String profitRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        for (Intersection intersection : Intersection.values()) {
            System.out.println(intersection.intersectionSize + "개 일치 (" + intersection.price + "원) - " + statistics.get(intersection) + "개");
        }
        System.out.println("총 수익률은 " + profitRate + "% 입니다.");
    }

    public void printErrorMsg() {
        System.out.println("올바르지 않은 숫자입니다. 다시 입력해주세요.");
    }
}
