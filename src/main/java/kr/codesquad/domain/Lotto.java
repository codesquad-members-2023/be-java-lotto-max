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
        winningResult.put(3, 0);
        winningResult.put(4, 0);
        winningResult.put(5, 0);
        winningResult.put(6, 0);

        for (LottoLine lottoLine : lotto) {
            int winningCount = lottoLine.checkWinningCount(winningNumbers);
            if (winningCount > 2) {
                winningResult.put(winningCount, winningResult.get(winningCount) + 1);
            }
        }

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
