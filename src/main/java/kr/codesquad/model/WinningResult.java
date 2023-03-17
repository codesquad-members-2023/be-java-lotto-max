package kr.codesquad.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kr.codesquad.config.Ranking;

/**
 * 로또 당첨 결과를 의미하는 객체
 */
public class WinningResult {

    private final WinningLotto winningLotto;
    private final Lottos lottos;
    public final Map<Ranking, Long> statistics = new EnumMap<>(Ranking.class);

    public WinningResult(WinningLotto winningLotto, Lottos lottos) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
        initData();
        putRankingData();
    }

    public Map<Ranking, Long> getStatistics() {
        return Collections.unmodifiableMap(statistics);
    }

    // TODO: EnumMap의 value를 모두 0 초기화할 수 있는 방법?? 아니면 RankingData 넣을 때 getOrDefault 사용?
    private void initData() {
        Stream.of(Ranking.values()).forEach(ranking ->
                statistics.put(ranking, 0L));
    }

    /**
     * 당첨 순위별 로또 개수를 계산해서 저장하는 메서드
     */
    private void putRankingData() {
        statistics.putAll(lottos.getLottos().stream()
                .map(this::rankingOf)
                .filter(ranking -> ranking != Ranking.NO_RANK)
                .collect(Collectors.groupingBy(ranking -> ranking, Collectors.counting()))
        );
    }

    /**
     * 로또의 당첨 순위를 리턴하는 메서드
     * @param lotto 구입한 로또
     * @return 당첨 순위
     */
    private Ranking rankingOf(Lotto lotto) {
        int matchCount = winningLotto.countMatches(lotto);
        boolean matchesBonusNumber = winningLotto.matchesBonusNumber(lotto);
        return Ranking.rankOf(matchCount, matchesBonusNumber);
    }

    public double getProfitRate() {
        long earned = statistics.entrySet().stream()
                .mapToLong(entry -> entry.getKey().prize * entry.getValue())
                .sum();
        return (double) earned / (lottos.size() * Money.LOTTO_PRICE_UNIT) - 1; // Money가 갖고 있는 정보인데 굳이 계산해야 할까
    }
}
