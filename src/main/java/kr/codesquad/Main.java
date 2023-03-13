package kr.codesquad;

import kr.codesquad.domain.Lotto;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Lotto lotto = new Lotto();
        lotto.start();
    }
}