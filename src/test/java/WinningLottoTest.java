import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoTest {
    @Test
    @DisplayName("로또 추첨 결과 테스트")
    void matchLotto_test() {
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(){
            @Override
            this.balls =
        };
    }
}
