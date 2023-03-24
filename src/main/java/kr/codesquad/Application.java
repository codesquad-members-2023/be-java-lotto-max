package kr.codesquad;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        LotteryGame lotteryGame = new LotteryGame();
        lotteryGame.run();
    }
}