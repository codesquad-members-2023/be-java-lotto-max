package kr.codesquad.domain;

import java.util.List;

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

	public LottoResult calculateLottoAndAddResult(List<Lotto> purchasedLotto,Lotto winningLotto,Integer bonusNumber){
		LottoResult lottoResult = new LottoResult();
		purchasedLotto.stream()
			.filter(lotto -> lotto.countSameNumbers(winningLotto) >= 3)
			.map(lotto -> calculateLotto(lotto, winningLotto, bonusNumber))
			.forEach(lottoResult::addResult);
		return lottoResult;
	}
}
