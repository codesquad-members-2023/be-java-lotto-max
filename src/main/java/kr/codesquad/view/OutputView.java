package kr.codesquad.view;

import java.util.Map;
import kr.codesquad.config.Ranking;
import kr.codesquad.model.Lottos;

public class OutputView {

    private static final String STATISTICS_FORMAT = "%d개 일치 (%d원) - %d개\n";
    private static final String RANK2_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개\n";

    public static void printError(String message) {
        System.out.println(message);
    }

    /**
     * 구입한 로또 정보(개수, 로또)를 출력하는 메서드
     * @param lottoCount 구입 개수
     * @param lottos 구입한 로또
     */
    public static void printPurchaseInfo(int lottoCount, Lottos lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
        System.out.println(lottos.toString());
    }

    /**
     * 로또 당첨 통계를 출력하는 메서드
     * @param winningResult 당첨 결과
     * @param profitRates 수익률
     */
    public static void printWinningStatistics(Map<Ranking, Long> winningResult, double profitRates) {
        System.out.println("당첨 통계/n" + "-".repeat(10));
        StringBuilder statistics = new StringBuilder();
        winningResult.forEach((ranking, result) ->
                statistics.append(singleRankStatisticOf(ranking, result))
        );
        System.out.print(statistics);
        System.out.printf("총 수익률은 %.2f%%입니다.%n", profitRates);
    }

    private static String singleRankStatisticOf(Ranking ranking, Long countOfMatches) {
        if (ranking == Ranking.RANK2) {
            return String.format(RANK2_FORMAT,
                    ranking.winningCondition, ranking.prize, countOfMatches);
        }
        return String.format(STATISTICS_FORMAT,
                ranking.winningCondition, ranking.prize, countOfMatches);
    }
}
