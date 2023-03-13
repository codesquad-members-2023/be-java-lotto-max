package kr.codesquad.service;

import java.util.ArrayList;
import java.util.List;
import kr.codesquad.model.Lotto;
import kr.codesquad.model.Money;
import kr.codesquad.util.LottoGenerator;

/**
 * 로또 구입 금액에 따라 로또 발행을 담당하는 객체
 */
public class LottoService {

    Money money;

    public LottoService(Money money) {
        this.money = money;
    }

    public List<Lotto> generateLotto() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.getLottoCount(); i++) {
            Lotto lotto = new Lotto(LottoGenerator.generateNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }
}
