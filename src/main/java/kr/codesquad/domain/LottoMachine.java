package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

	public static final int START_INCLUSIVE = 0;

	List<Ticket> generateTickets(int quantity) {
		LottoBalls lottoBalls = new LottoBalls();
		return IntStream.range(START_INCLUSIVE, quantity)
			.mapToObj(i -> new Ticket(lottoBalls.generateRandom()))
			.collect(Collectors.toList());
	}
}
