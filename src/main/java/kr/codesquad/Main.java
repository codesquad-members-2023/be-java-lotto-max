package main.java.kr.codesquad;

import main.java.kr.codesquad.domain.LottoGame;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        LottoGame lottoGame = new LottoGame();
        lottoGame.start();
    }
}
