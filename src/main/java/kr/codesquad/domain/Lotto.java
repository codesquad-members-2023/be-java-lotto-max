package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoLine> lotto = new ArrayList<>();

    public Lotto(int countOfLotto) {
        for (int i = 0; i < countOfLotto; i++) {
            lotto.add(new LottoLine());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoLine lottoLine : lotto) {
            sb.append(lottoLine + "\n");
        }
        return sb.toString();
    }

}
