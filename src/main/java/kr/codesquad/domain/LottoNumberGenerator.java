package main.java.kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Random;

public class LottoNumberGenerator {

    private Random random = new Random();

    private final int max = 50;

    private final int numberLength = 6;

    public ArrayList<Integer> createLottoNumber() {
        ArrayList<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < numberLength; i++){
            lottoNumbers.add(this.random.nextInt(max + 1));
        }
        return lottoNumbers;
    }
}
