package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Lottery {
    public ArrayList<Line> lottoList;
    public ArrayList<Integer> winningNumbers;
    public int bonusNumber;
    private final int price;
    public int count;
    private final HashMap<Intersection, Integer> statistics = new HashMap<>();
    public final int lotteryPrice = 1000;

    public Lottery(int price) {
        lottoList = new ArrayList<>();
        this.price = price;
        count = price / lotteryPrice;
    }

    public void putLottoLines() {
        for (int i = 0; i < count; i++) {
            lottoList.add(new Line());
        }
    }

    public HashMap<Intersection, Integer> getStatistics() {
        ArrayList<Intersection> intersectionList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            intersectionList.add(getIntersection(i));
        }
        for (Intersection intersection : Intersection.values()) {
            statistics.put(intersection, Collections.frequency(intersectionList, intersection));
        }
        return statistics;
    }

    private Intersection getIntersection(int index) {
        List<Integer> line = new ArrayList<>(lottoList.get(index).numbers);
        boolean bonusInclusion = line.contains(bonusNumber);
        line.retainAll(winningNumbers);
        return Intersection.valueOf(line.size(), bonusInclusion);
    }

    public String calculateRateOfReturn() {
        long sum = 0;
        for (Intersection intersection : Intersection.values()) {
            sum += intersection.price * statistics.get(intersection);
        }
        double rate = (double) (sum - price) / price * 100;
        return String.format("%.2f", rate);
    }
}