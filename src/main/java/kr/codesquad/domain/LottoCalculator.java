package kr.codesquad.domain;

public class LottoCalculator {
	public LottoNumber calculateLotto(Lotto purchasedLotto, Lotto winningLotto, Integer bonusNumber){
		Integer sameNumbers = purchasedLotto.countSameNumbers(winningLotto);
		if(sameNumbers==LottoNumber.FIVE.getMatchingNumbers()){
			return getLottoIsBonusOrFive(purchasedLotto,bonusNumber);
		}
		return LottoNumber.getRank(sameNumbers);
	}
	public LottoNumber getLottoIsBonusOrFive(Lotto purchasedLotto, Integer bonusNumber){
		if(purchasedLotto.includeBonusNumber(bonusNumber)){
			return LottoNumber.BONUS;
		}
		return LottoNumber.FIVE;
	}
}
