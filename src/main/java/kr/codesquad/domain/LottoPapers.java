package kr.codesquad.domain;

import java.text.DecimalFormat;
import java.util.*;

public class LottoPapers {
    private List<Lotto> papers;

    public LottoPapers(int purchaseCnt) {
        this.papers = new ArrayList<>();
        for(int cnt = 0; cnt < purchaseCnt; cnt++) {
            this.papers.add(new Lotto());
        }
    }

    public void showLottoStats(WinningLotto winningLotto, int price) {
        System.out.println("\r\n당첨 통계");
        System.out.println("---------");
        Map<LottoPrize, Integer> lottoResults = new HashMap<>();
        for(Lotto lotto : papers) {
            putLottoResults(lottoResults, winningLotto, lotto);
        }
        long totalRevenue = threeBallMatches(winNumbers);
        totalRevenue += fourBallMatches(winNumbers);
        totalRevenue += fiveBallMatches(winNumbers);
        totalRevenue += sixBallMatches(winNumbers);
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("총 수익률은 " + df.format((double)(totalRevenue - price) / price * 100) + "%입니다.");
    }

    private void putLottoResults(Map<LottoPrize, Integer> lottoResults, WinningLotto winningLotto, Lotto lotto) {
        Optional<LottoPrize> opLottoPrize = winningLotto.matchLotto(lotto);
        if (opLottoPrize.isEmpty()) {
            return;
        }
        LottoPrize lottoPrize = opLottoPrize.get();
        lottoResults.put(lottoPrize, lottoResults.getOrDefault(lottoPrize, 0) + 1);
    }

    private long sixBallMatches(List<Integer> winNumbers) {
        int count = this.papers.stream()
                .mapToInt(lotto -> lotto.countMatch(winNumbers) == 6 ? 1 : 0)
                .sum();
        System.out.println("6개 일치 (2000000000원)- " + count + "개");
        return 2000000000 * count;
    }

    private long fiveBallMatches(List<Integer> winNumbers) {
        int count = this.papers.stream()
                .mapToInt(lotto -> lotto.countMatch(winNumbers) == 5 ? 1 : 0)
                .sum();
        System.out.println("5개 일치 (1500000원)- " + count + "개");
        return 1500000 * count;
    }

    private long fourBallMatches(List<Integer> winNumbers) {
        int count = this.papers.stream()
                .mapToInt(lotto -> lotto.countMatch(winNumbers) == 4 ? 1 : 0)
                .sum();
        System.out.println("4개 일치 (50000원)- " + count + "개");
        return 50000 * count;
    }

    private long threeBallMatches(List<Integer> winNumbers) {
        int count = this.papers.stream()
                .mapToInt(lotto -> lotto.countMatch(winNumbers) == 3 ? 1 : 0)
                .sum();
        System.out.println("3개 일치 (5000원)- " + count + "개");
        return 5000 * count;
    }
}
