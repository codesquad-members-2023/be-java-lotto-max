package kr.codesquad.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoWinningStatisticsManager {
    public LottoWinningStatisticsManager() {
    }

    public Map<Integer, Integer> checkMatchingNumbers(List<List<Integer>> lottoLists, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> matchingNumbersMap = generateMatchingNumbersMap();
        for (List<Integer> lottoList : lottoLists) {
            int cnt = findWinningNumbersAndCount(lottoList, winningNumbers, bonusNumber);
            regenerateMatchingNumbersMap(matchingNumbersMap, cnt);
        }

        return matchingNumbersMap;
    }

    private Map<Integer, Integer> generateMatchingNumbersMap() {
        return IntStream.rangeClosed(3, 6)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> 0));
    }

    private int findWinningNumbersAndCount(List<Integer> lottoList, List<Integer> winningNumbers, int bonusNumber) {
        return (int) lottoList.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void regenerateMatchingNumbersMap(Map<Integer, Integer> matchingNumbersMap, int cnt) {
        if (cnt >= 3 && cnt <= 6) {
            matchingNumbersMap.put(cnt, matchingNumbersMap.get(cnt) + 1);
        }
    }

    public double calculateTotalYield(int purchaseAmount, Map<Integer, Integer> matchingNumbersMap) {
        int totalAmount = generateTotalAmount(matchingNumbersMap);
        return (double) (totalAmount - purchaseAmount) / purchaseAmount * 100;
    }

    private int generateTotalAmount(Map<Integer, Integer> matchingNumbersMap) {
        return IntStream.rangeClosed(3, 6)
                .filter(i -> matchingNumbersMap.get(i) > 0)
                .map(i -> matchingNumbersMap.get(i) * Winning.getMoney(i))
                .sum();
    }
}
