package kr.codesquad.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.codesquad.domain.Result;

public class ResultDto {

	private final Map<Result, Integer> resultStatic;
	private final double rateOfProfit;

	public ResultDto(final List<Result> results, final double rateOfProfit) {
		resultStatic = new HashMap<>();
		calculateResults(results);
		this.rateOfProfit = rateOfProfit;
	}

	private void calculateResults(final List<Result> results) {
		Arrays.stream(Result.values())
			.forEach(result -> resultStatic.put(result, 0));
		results.forEach(result -> resultStatic.computeIfPresent(result, (k, v) -> v + 1));
	}

	public int getCorrectCount(final Result result) {
		return resultStatic.get(result);
	}

	public double getRateOfProfit() {
		return rateOfProfit;
	}
}
