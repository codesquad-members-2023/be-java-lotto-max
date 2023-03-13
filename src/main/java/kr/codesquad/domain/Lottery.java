package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Lottery {
    public ArrayList<Line> lottoList;
    public ArrayList<Integer> winningNumbers;
    public int price;
    public int count;
    public HashMap<Integer, Integer> statistics = new HashMap<>();

    public Lottery(int price) {
        lottoList = new ArrayList<>();
        this.price = price;
        count = price / 1000;
    }

    public void putLottoLine() {
        for (int i = 0; i < count; i++) {
            lottoList.add(new Line());
        }
    }

    public HashMap<Integer, Integer> getStatistics() {
        ArrayList<Integer> countOfCommonNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            countOfCommonNumbers.add(getCountOfCommonNumbers(i));
        }
        for (int i = 3; i <= 6; i++) {
            statistics.put(i, Collections.frequency(countOfCommonNumbers, i));
        }
        return statistics;
    }

    private int getCountOfCommonNumbers(int index) {
        List<Integer> line = new ArrayList<>(lottoList.get(index).numbers);
        line.retainAll(winningNumbers);
        return line.size();
    }

    public String calculateRateOfReturn() {
        long sum = (5000L * statistics.get(3)) + (50000L * statistics.get(4)) + (1500000L * statistics.get(5)) + (2000000000L * statistics.get(6));
        double rate = (double) (sum - price) / price * 100;
        return String.format("%.2f", rate);
    }
}