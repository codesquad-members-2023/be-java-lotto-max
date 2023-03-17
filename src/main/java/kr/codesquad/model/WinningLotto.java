package kr.codesquad.model;

import kr.codesquad.config.Ranking;

/**
 * 보너스 번호를 포함한 로또 당첨 번호를 의마하는 객체
 */
public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 구매한 로또 번호와 비교해 몇개의 번호가 일치하는지 확인하는 메서드
     * @param compare 구매한 로또 번호
     * @return 일치하는 개수
     */
    public int countMatches(Lotto compare) {
        return lotto.countMatches(compare);
    }

    /**
     * 구매한 로또 번호의 보너스 번호가 일치하는지 확인하는 메서드
     * @param compare 구매한 로또 번호
     * @return 일치 여부
     */
    public boolean matchesBonusNumber(Lotto compare) {
        return countMatches(compare) == Ranking.RANK2.winningCondition
                && lotto.contains(bonusNumber);
    }
}
