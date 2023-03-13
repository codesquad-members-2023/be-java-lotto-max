package kr.codesquad.view;

import java.util.List;
import kr.codesquad.model.Lotto;

public class OutputView {

    private static final String LOTTO_LEFT_BRACKET = "[";
    private static final String LOTTO_RIGHT_BRACKET = "]";

    /**
     * 구입한 로또 정보(개수, 로또)를 출력하는 메서드
     * @param lottoCount 구입 개수
     * @param lottos 구입한 로또
     */
    public static void printPurchaseInfo(int lottoCount, List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
        StringBuilder lottosPrinter = new StringBuilder();
        lottos.forEach(lotto ->
                lottosPrinter.append(printLotto(lotto))
                        .append("\n"));
        System.out.println(lottosPrinter);
    }

    /**
     * 구입한 로또 1개를 format하여 반환하는 메서드
     */
    private static String printLotto(Lotto lotto) {
        return LOTTO_LEFT_BRACKET
                + lotto.toString()
                + LOTTO_RIGHT_BRACKET;
    }
}
