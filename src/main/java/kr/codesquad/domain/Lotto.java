package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private List<LottoLine> lotto = new ArrayList<>();

    public Lotto(int countOfLotto) {
        for (int i = 0; i < countOfLotto; i++) {
            lotto.add(new LottoLine());
        }
    }

    public Map<Integer, Integer> checkWinningResult(List<Integer> winningNumbers) {
        Map<Integer, Integer> winningResult = new HashMap<>();
        for (Prize prize : Prize.values()) {
            winningResult.put(prize.getCountOfMatch(), 0);
        }

        for (LottoLine lottoLine : lotto) {
            winningResult = putWinningCount(lottoLine.checkWinningCount(winningNumbers), winningResult);
        }

        return winningResult;
    }

    private Map<Integer, Integer> putWinningCount(int winningCount, Map<Integer, Integer> winningResult) {
        if (winningCount < 3) {
            return winningResult;
        }

        winningResult.put(winningCount, winningResult.get(winningCount) + 1);
        return winningResult;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoLine lottoLine : lotto) {
            sb.append(lottoLine + "\n");
        }
        return sb.toString();
    }

}
