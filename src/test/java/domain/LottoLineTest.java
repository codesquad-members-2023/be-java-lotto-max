package domain;

import kr.codesquad.domain.LottoLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoLineTest {

    @Test
    @DisplayName("로또의 한 라인이 중복 없이 6개 생성되는지 확인한다.")
    public void lottoLineTest() {
        for (int i = 0; i < 10; i++) {
            LottoLine lottoLine = new LottoLine();
            String lottoLineString = lottoLine.toString();

            lottoLineString = lottoLineString.replace("[", "").replace(" ", "").replace("]", "");
            String[] splitStr = lottoLineString.split(",");
            Set<String> set = new HashSet<>();
            for (String str : splitStr) {
                set.add(str);
            }
            assertThat(set.size()).isEqualTo(6);
        }
    }
}
