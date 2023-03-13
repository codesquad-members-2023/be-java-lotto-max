package kr.codesquad.domain;

import static kr.codesquad.application.LottoGame.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import kr.codesquad.generator.LottoGenerator;
import kr.codesquad.util.Validation;
import kr.codesquad.view.View;

public class LottoMarket {
	LottoGenerator lottoGenerator;
	List<Lotto> purchasedLotto;

	public List<Lotto> buyLotto(){
		Integer countLotto = getValidateCountLotto();
		purchasedLotto = getPurchasedManualLotto();
		View.printManualAutoLottoCount(purchasedLotto.size(),countLotto-purchasedLotto.size());
		purchasedLotto.addAll(lottoGenerator.purchaseLotto(countLotto - purchasedLotto.size()));
		return purchasedLotto;
	}
	public List<Lotto> getPurchasedManualLotto(){
		Integer manualLottoCount = View.manualLottoCount();
		return IntStream.range(0, manualLottoCount)
			.mapToObj(i -> new Lotto(getValidateLotto("")))
			.collect(Collectors.toList());
	}

	public LottoMarket(){
		lottoGenerator = new LottoGenerator();
		purchasedLotto = new ArrayList<>();
	}
	public Integer getValidateCountLotto(){
		Integer count =0;
		try{
			count = View.countLotto();
			Validation.validateCountLotto(count);
		}catch (Exception e){
			View.printErrorMessage(e.getMessage());
			getValidateCountLotto();
		}
		return count/1000;
	}
}
