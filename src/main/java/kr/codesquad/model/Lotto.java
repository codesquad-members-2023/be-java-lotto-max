package kr.codesquad.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또를 의미하는 객체
 */
public class Lotto {

    public static final int SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        validateNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumber(List<Integer> lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber > MAX_NUMBER || lottoNumber < MIN_NUMBER) { // TODO: 리팩터링 필요
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
