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
        printLottoResults(lottoResults, price);
    }

    private void printLottoResults(Map<LottoPrize, Integer> lottoResults, int price) {
        long totalRevenue = 0;
        for(LottoPrize lottoPrize : LottoPrize.values()) {
            int matchCount = lottoResults.getOrDefault(lottoPrize, 0);
            totalRevenue += lottoPrize.reward * matchCount;
            System.out.println(lottoPrize.matchBalls + "개 일치" + isSecondPrize(lottoPrize.bonus)
                    + " (" + lottoPrize.reward + "원)- " + matchCount + "개");
        }
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("총 수익률은 " + df.format((double)(totalRevenue - price) / price * 100) + "%입니다.");
    }

    private String isSecondPrize(boolean bonus) {
        if(bonus) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private void putLottoResults(Map<LottoPrize, Integer> lottoResults, WinningLotto winningLotto, Lotto lotto) {
        Optional<LottoPrize> opLottoPrize = winningLotto.matchLotto(lotto);
        if (opLottoPrize.isEmpty()) {
            return;
        }
        LottoPrize lottoPrize = opLottoPrize.get();
        lottoResults.put(lottoPrize, lottoResults.getOrDefault(lottoPrize, 0) + 1);
    }
}
