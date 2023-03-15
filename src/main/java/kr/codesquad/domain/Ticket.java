package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Ticket {

	private final List<Ball> ballNumbers;

	public Ticket(List<Ball> ballNumbers) {
		this.ballNumbers = ballNumbers;
	}

	public String getNumbers() {
		return ballNumbers.toString();
	}

	public List<Ball> getBallNumbers() {
		return new ArrayList<>(ballNumbers);
	}
}
