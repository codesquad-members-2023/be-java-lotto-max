import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.LottoPrize;
import kr.codesquad.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {
    @Test
    @DisplayName("로또 추첨 결과 테스트")
    void matchLotto_test() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningLotto.matchLotto(lotto).get()).isEqualTo(LottoPrize.First);
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        assertThat(winningLotto.matchLotto(lotto).get()).isEqualTo(LottoPrize.Second);
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        assertThat(winningLotto.matchLotto(lotto).get()).isEqualTo(LottoPrize.Third);
        lotto = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        assertThat(winningLotto.matchLotto(lotto).get()).isEqualTo(LottoPrize.Fourth);
        lotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        assertThat(winningLotto.matchLotto(lotto).get()).isEqualTo(LottoPrize.Fifth);
    }

}
