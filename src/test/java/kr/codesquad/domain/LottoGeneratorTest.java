package kr.codesquad.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("LottoGenerator 테스트")
class LottoGeneratorTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    @DisplayName("구입 금액을 받아 로또 개수를 반환한다.")
    public void testInvertMoneyToAmount() {
        int lottoPurchaseMoney = 5000;
        int expectedAmount = 5;

        assertThat(lottoGenerator.invertMoneyToAmount(lottoPurchaseMoney)).isEqualTo(expectedAmount);
    }

    @Test
    @DisplayName("생성된 로또 개수에 맞게 로또 리스트를 생성한다.")
    public void testGenerateLottoLists() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int lottoAmount = 5;

        List<List<Integer>> generatedLottoLists = lottoGenerator.generateLottoLists(lottoAmount);
        assertThat(generatedLottoLists.size()).isEqualTo(lottoAmount);

        for (List<Integer> lottoList : generatedLottoLists) {
            assertThat(lottoList.size()).isEqualTo(6);
            for (int number : lottoList) {
                assertThat(number >= 1 && number <= 45).isTrue();
            }
        }
    }
}