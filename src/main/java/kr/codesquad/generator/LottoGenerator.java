package kr.codesquad.generator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import kr.codesquad.domain.Lotto;

public class LottoGenerator {
	public final static Integer LottoNumberCount = 6;
	public Lotto makeLotto(){
		List<Integer> randomNumberList = new Random().ints(1, 44)
			.distinct()
			.limit(LottoNumberCount)
			.sorted()
			.boxed()
			.collect(Collectors.toList());
		return new Lotto(randomNumberList);
	}

	public List<Lotto> purchaseLotto(Integer count){
		return Stream.generate(this::makeLotto).limit(count).collect(Collectors.toList());
	}

}
