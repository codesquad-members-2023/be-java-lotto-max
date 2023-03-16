package kr.codesquad.model;

/**
 * 로또 숫자 1개를 의미하는 객체
 */
public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateNumber(int lottoNumber) {
        if (lottoNumber > LottoNumber.MAX_NUMBER || lottoNumber < LottoNumber.MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber compare) {
        return Integer.compare(this.lottoNumber, compare.lottoNumber);
    }
}
