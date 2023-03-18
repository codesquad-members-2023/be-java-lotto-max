package kr.codesquad.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import kr.codesquad.model.Lotto;
import kr.codesquad.model.LottoNumber;

/**
 * 1~45 사이의 중복되지 않는 6개의 숫자를 랜덤으로 생성하는 클래스
 */
public class LottoGenerator {

    private static final List<Integer> lottoBall = 
            IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER + 1)
            .boxed()
            .collect(Collectors.toList()
    );

    /**
     * 로또 번호를 랜덤으로 생성하는 메서드
     * @return 1~45 사이의 중복되지 않는 6개의 LottoNumber
     */
    public static List<LottoNumber> draw() {
        Collections.shuffle(lottoBall);
        return lottoBall.stream()
                .limit(Lotto.SIZE)
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toList());
    }

}
