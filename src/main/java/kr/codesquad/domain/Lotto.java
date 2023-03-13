package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	List<Integer> lotto;
	public Lotto(List<Integer> lotto){
		this.lotto = lotto;
	}
	public Lotto(String lotto){
		this.lotto = Arrays.stream(lotto.split(","))
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}
	public Integer countSameNumbers(Lotto other) {
		return Math.toIntExact(lotto.stream()
			.filter(other.lotto::contains)
			.count());
	}
	public Boolean includeBonusNumber(Integer bonusNumber){
		return lotto.contains(bonusNumber);
	}

	@Override
	public String toString(){
		return lotto.toString();
	}
}
