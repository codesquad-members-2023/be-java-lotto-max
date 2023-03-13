package kr.codesquad.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import kr.codesquad.domain.Lotto;

public class Validation {
	public final static Integer LottoNumberCount = 6;
	public final static Integer MinLottoNumber =0;
	public final static Integer MaxLottoNumber =46;
	public final static Integer MoneyUnit  = 1000;

	public static void validateCountLotto(Integer count) throws Exception {
		if(count%MoneyUnit>0){
			throw new Exception(ErrorMessage.NOT_MULTIPLE_OF_THOUSAND.getErrorMessage());
		}
	}
	public static void validateInputLotto(String lotto) throws Exception{
		Arrays.stream(lotto.split(","))
			.map(String::trim)
			.forEach(num -> {
				try {
					Integer.parseInt(num);
				} catch (NumberFormatException e) {
					throw new RuntimeException(new Exception(ErrorMessage.NOT_INTEGER_NUMBER.getErrorMessage()));
				}
			});
	}
	public static void validateLottoNumberRange(String lotto) throws Exception{
		Arrays.stream(lotto.split(","))
			.map(String::trim)
			.forEach(num -> {
				if(Integer.parseInt(num)<MinLottoNumber || Integer.parseInt(num)>MaxLottoNumber){
					throw new RuntimeException(new Exception(ErrorMessage.NUMBER_OVER_OR_UNDER_LOTTO_NUMBER.getErrorMessage()));
				}
			});
	}

	public static void validateWinningLottoCount(String lotto) throws Exception{
		List<Integer> winningLotto = Arrays.stream(lotto.split(","))
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		if(winningLotto.size()!=LottoNumberCount){
			throw new Exception(ErrorMessage.INVALID_LOTTO_NUMBERS_SIZE.getErrorMessage());
		}
	}

	public static void validateBonusNumberRange(Integer bonusNumber)throws Exception{
		if(bonusNumber<MinLottoNumber || bonusNumber>MaxLottoNumber){
			throw (new Exception(ErrorMessage.NUMBER_OVER_OR_UNDER_LOTTO_NUMBER.getErrorMessage()));
		}
	}
	public static void validateWinningLotteryHasBonusNumber(Integer bonusNumber, Lotto lotto)throws Exception{
		if(lotto.includeBonusNumber(bonusNumber)){
			throw new Exception(ErrorMessage.NOT_INCLUDE_BONUS_NUMBER_IN_LOTTO.getErrorMessage());
		}

	}
}
