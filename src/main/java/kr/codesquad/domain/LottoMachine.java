package kr.codesquad.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
	List<Ticket> generateTicket(int quantity) {
		LottoBalls lottoBalls = new LottoBalls();
		return IntStream.range(0, quantity)
			.mapToObj(i -> new Ticket(lottoBalls.generateRandom()))
			.collect(Collectors.toList());
	}
}
