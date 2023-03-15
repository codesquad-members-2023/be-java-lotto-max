package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoLine {
    private final int LOTTO_LENGTH = 6;
    private List<Integer> lottoLine;

    public LottoLine() {
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        lottoLine = numberList.subList(0, LOTTO_LENGTH);
        Collections.sort(lottoLine);
    }

    public int checkWinningCount(List<Integer> winningNumbers) {
        int count = 0;
        for (int num : winningNumbers) {
            if (lottoLine.contains(num)) {
                count++;
            }
        }
        return count;
    }

    public String toString() {
        return lottoLine.toString();
    }

}
