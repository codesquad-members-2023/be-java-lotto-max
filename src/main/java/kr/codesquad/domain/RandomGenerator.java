package kr.codesquad.domain;

import java.util.Random;

public class RandomGenerator {

    private final Random random = new Random();

    public int generateRandomNumber() {
        return random.nextInt(46);
    }
}
