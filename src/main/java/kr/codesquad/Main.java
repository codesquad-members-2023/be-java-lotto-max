package kr.codesquad;

import kr.codesquad.domain.LottoGame;
import kr.codesquad.view.InputManager;

public class Main {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new InputManager());
        lottoGame.playGame();
    }
}
