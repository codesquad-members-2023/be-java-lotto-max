package kr.codesquad.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinningStatisticsManagerTest {
    @Test
    public void testCheckMatchingNumbers() {
        List<List<Integer>> lottoLists = Arrays.asList(
                Arrays.asList(8, 21, 23, 41, 42, 43),
                Arrays.asList(3, 5, 11, 16, 32, 38),
                Arrays.asList(7, 11, 16, 35, 36, 44),
                Arrays.asList(1, 8, 11, 31, 41, 42),
                Arrays.asList(13, 14, 16, 38, 42, 45),
                Arrays.asList(7, 11, 30, 40, 42, 43),
                Arrays.asList(2, 13, 22, 32, 38, 45),
                Arrays.asList(23, 25, 33, 36, 39, 41),
                Arrays.asList(1, 3, 5, 14, 22, 45),
                Arrays.asList(5, 9, 38, 41, 43, 44),
                Arrays.asList(2, 8, 9, 18, 19, 21),
                Arrays.asList(13, 14, 18, 21, 23, 35),
                Arrays.asList(17, 21, 29, 37, 42, 45),
                Arrays.asList(3, 8, 27, 30, 35, 44)
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoWinningStatisticsManager manager = new LottoWinningStatisticsManager(lottoLists, winningNumbers);
        Map<Integer, Integer> matchingNumbersMap = manager.checkMatchingNumbers();

        assertThat(matchingNumbersMap.get(3)).isEqualTo(1);
        assertThat(matchingNumbersMap.get(4)).isEqualTo(0);
        assertThat(matchingNumbersMap.get(5)).isEqualTo(0);
        assertThat(matchingNumbersMap.get(6)).isEqualTo(0);
    }

    @Test
    public void testCalculateTotalYield() {
        List<List<Integer>> lottoLists = Arrays.asList(
                Arrays.asList(8, 21, 23, 41, 42, 43),
                Arrays.asList(3, 5, 11, 16, 32, 38),
                Arrays.asList(7, 11, 16, 35, 36, 44),
                Arrays.asList(1, 8, 11, 31, 41, 42),
                Arrays.asList(13, 14, 16, 38, 42, 45),
                Arrays.asList(7, 11, 30, 40, 42, 43),
                Arrays.asList(2, 13, 22, 32, 38, 45),
                Arrays.asList(23, 25, 33, 36, 39, 41),
                Arrays.asList(1, 3, 5, 14, 22, 45),
                Arrays.asList(5, 9, 38, 41, 43, 44),
                Arrays.asList(2, 8, 9, 18, 19, 21),
                Arrays.asList(13, 14, 18, 21, 23, 35),
                Arrays.asList(17, 21, 29, 37, 42, 45),
                Arrays.asList(3, 8, 27, 30, 35, 44)
        );
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoWinningStatisticsManager manager = new LottoWinningStatisticsManager(lottoLists, winningNumbers);
        Map<Integer, Integer> matchingNumbersMap = manager.checkMatchingNumbers();
        double result = Math.round(manager.calculateTotalYield(14000, matchingNumbersMap) * 100.0) / 100.0;
        assertThat(result).isEqualTo(-64.29);
    }
}