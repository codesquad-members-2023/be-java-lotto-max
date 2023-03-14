package kr.codesquad.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Nested
@DisplayName("LottoGenerator 테스트")
class LottoGeneratorTest {
    @Test
    @DisplayName("로또 생성이 잘 됐는지 확인하는 테스트")
    void testGenerateLottoLists() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int lottoAmount = 5;
        List<List<Integer>> lottoLists = lottoGenerator.generateLottoLists(lottoAmount);
        // lottoLists의 사이즈가 예상 사이즈와 같은지 확인
        assertThat(lottoLists.size()).isEqualTo(lottoAmount);

        for (List<Integer> lottoList : lottoLists) {
            // lottoList의 사이즈가 6인지 확인
            assertThat(lottoList.size()).isEqualTo(6);
            // lottoList의 각 요소가 1부터 45까지인지 확인
            for (Integer number : lottoList) {
                assertThat(number).isBetween(1, 45);
            }
            // 오름차순 정렬됐는지 확인
            assertThat(lottoList).isSorted();
        }
    }
}