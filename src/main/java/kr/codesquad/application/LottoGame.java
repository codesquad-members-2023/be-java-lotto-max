package kr.codesquad.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.LottoCalculator;
import kr.codesquad.domain.LottoResult;
import kr.codesquad.generator.LottoGenerator;
import kr.codesquad.util.Validation;
import kr.codesquad.view.View;

public class LottoGame {
	LottoGenerator lottoGenerator;
	List<Lotto> purchasedLotto;
	LottoCalculator lottoCalculator;
	Lotto winningLotto;
	Integer bonusNumber;
	LottoResult lottoResult;

	public LottoGame(){
		lottoGenerator = new LottoGenerator();
		lottoCalculator = new LottoCalculator();
		lottoResult = new LottoResult();
		buyLotto();
		getWinningLottoNumber();
		printPurchasedLotto();
	}

	public void buyLotto(){
		Integer countLotto = getValidateCountLotto();
		purchasedLotto = getPurchasedManualLotto();
		purchasedLotto.addAll(lottoGenerator.purchaseLotto(countLotto - purchasedLotto.size()));
	}

	public void getWinningLottoNumber(){
		winningLotto = new Lotto(getValidateLotto("당첨 번호를 입력해주세요\n"));
		bonusNumber = getValidateBonusNumber();
	}
	public void printPurchasedLotto(){
		View.printLottoCount(purchasedLotto.size());
		purchasedLotto.stream().forEach(lotto -> View.printLotto(lotto.toString()));
	}

	public List<Lotto> getPurchasedManualLotto(){
		Integer manualLottoCount = View.manualLottoCount();
		return IntStream.range(0, manualLottoCount)
			.mapToObj(i -> new Lotto(getValidateLotto("")))
			.collect(Collectors.toList());
	}

	public void run(){
		calculateLottoAndAddResult();
		lottoResult.printResults();
	}

	public void calculateLottoAndAddResult(){
		purchasedLotto.stream()
			.filter(lotto -> lotto.countSameNumbers(winningLotto) >= 3)
			.map(lotto -> lottoCalculator.calculateLotto(lotto, winningLotto, bonusNumber))
			.forEach(lottoResult::addResult);
	}



	public Integer getValidateBonusNumber(){
		Integer bonusNumber =0;
		try{
			bonusNumber = View.bonusNumber();
			Validation.validateBonusNumberRange(bonusNumber);
			Validation.validateWinningLotteryHasBonusNumber(bonusNumber,winningLotto);
		} catch (Exception e) {
			View.printErrorMessage(e.getMessage());
			getValidateBonusNumber();
		}
		return bonusNumber;
	}
	public String getValidateLotto(String outputComment){
		String winningLotto = View.getLotto(outputComment);
		try{
			Validation.validateInputLotto(winningLotto);
			Validation.validateLottoNumberRange(winningLotto);
			Validation.validateWinningLottoCount(winningLotto);
		}catch (Exception e){
			View.printErrorMessage(e.getMessage());
			getValidateLotto(outputComment);
		}
		return winningLotto;
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
