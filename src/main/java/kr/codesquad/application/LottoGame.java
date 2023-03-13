package kr.codesquad.application;

import java.util.List;
import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.LottoCalculator;
import kr.codesquad.domain.LottoMarket;
import kr.codesquad.domain.LottoResult;
import kr.codesquad.util.Validation;
import kr.codesquad.view.View;

public class LottoGame {
	LottoMarket lottoMarket;
	List<Lotto> purchasedLotto;
	LottoCalculator lottoCalculator;
	Lotto winningLotto;
	LottoResult lottoResult;

	public LottoGame(){
		lottoCalculator = new LottoCalculator();
		lottoMarket = new LottoMarket();
		purchasedLotto = lottoMarket.buyLotto();
		printPurchasedLotto();
		getWinningLotto();
		lottoResult = lottoCalculator.calculateLottoAndAddResult(purchasedLotto, winningLotto, getValidateBonusNumber());

	}

	public void getWinningLotto(){
		this.winningLotto=new Lotto(getValidateLotto("당첨 번호를 입력해주세요\n"));
	}

	public void printPurchasedLotto(){
		View.printLottoCount(purchasedLotto.size());
		purchasedLotto.forEach(lotto -> View.printLotto(lotto.toString()));
	}

	public void run(){
		lottoResult.printResults();
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

	public static String getValidateLotto(String outputComment){
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

}
