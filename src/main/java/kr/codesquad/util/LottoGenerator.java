package kr.codesquad.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kr.codesquad.model.Lotto;

/**
 * 1~45 사이의 중복되지 않는 6개의 숫자를 랜덤으로 생성하는 클래스
 */
public class LottoGenerator {

    /**
     * 로또 번호를 랜덤으로 생성하는 메서드
     * @return 1~45 사이의 중복되지 않는 6개의 정수
     */
    public static List<Integer> generateNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() <= Lotto.SIZE) {
            int lottoNumber = generateNumber();
            if (contains(lottoNumbers, lottoNumber)) { // TODO: 리팩토링 필요
                continue;
            }
            lottoNumbers.add(lottoNumber);
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static int generateNumber() {
        return (int) (Math.random() * (Lotto.MAX_NUMBER) + 1);
    }

    private static boolean contains(List<Integer> lottoNumbers, int lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
