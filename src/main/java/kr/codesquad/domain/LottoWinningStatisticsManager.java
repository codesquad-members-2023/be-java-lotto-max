package kr.codesquad.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoWinningStatisticsManager {
    private final int bonusNumber;
    private int bonusCount = 0;

    public LottoWinningStatisticsManager(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Map<Integer, Integer> checkMatchingNumbers(List<List<Integer>> lottoLists, List<Integer> winningNumbers) {
        Map<Integer, Integer> matchingNumbersMap = generateMatchingNumbersMap();
        for (List<Integer> lottoList : lottoLists) {
            int cnt = countWinningNumbers(lottoList, winningNumbers);
            regenerateMatchingNumbersMap(matchingNumbersMap, cnt);
        }

        return matchingNumbersMap;
    }

    private Map<Integer, Integer> generateMatchingNumbersMap() {
        return IntStream.rangeClosed(3, 6)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> 0));
    }

    private int countWinningNumbers(List<Integer> lottoList, List<Integer> winningNumbers) {
        int cnt = (int) lottoList.stream()
                .filter(winningNumbers::contains)
                .count();

        countBonusNumber(lottoList, cnt);

        return cnt;
    }

    private void countBonusNumber(List<Integer> lottoList, int cnt) {
        if (cnt == 4 && lottoList.contains(bonusNumber)) {
            bonusCount++;
        }
    }

    public int getBonusCount() {
        return bonusCount;
    }

    private void regenerateMatchingNumbersMap(Map<Integer, Integer> matchingNumbersMap, int cnt) {
        if (cnt >= 3 && cnt <= 6) {
            matchingNumbersMap.put(cnt, matchingNumbersMap.get(cnt) + 1);
        }
    }

    public double calculateTotalYield(int purchaseAmount, Map<Integer, Integer> matchingNumbersMap) {
        int totalAmount = generateTotalAmount(matchingNumbersMap);
        return (double) (totalAmount + bonusCount * Winning.getMoney(5) * 20 - purchaseAmount) / purchaseAmount * 100;
    }

    private int generateTotalAmount(Map<Integer, Integer> matchingNumbersMap) {
        return IntStream.rangeClosed(3, 6)
                .filter(i -> matchingNumbersMap.get(i) > 0)
                .map(i -> matchingNumbersMap.get(i) * Winning.getMoney(i))
                .sum();
    }
}
