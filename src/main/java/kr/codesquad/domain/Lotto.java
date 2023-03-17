package kr.codesquad.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> balls;

    public Lotto() {
        List<Integer> balls = new ArrayList<>();
        for(int i = 1; i < 46; i++) {
            balls.add(i);
        }
        Collections.shuffle(balls);
        this.balls = balls.subList(0, 6);
        Collections.sort(this.balls);
        System.out.println(this.balls);
    }

    @Override
    public String toString() {
        return "[" +
                this.balls.stream()
                        .map(i -> i.toString())
                        .reduce((o1, o2) -> o1 + ", " + o2)
                + "]";
    }

    public boolean contains(int num) {
        return this.balls.contains(num);
    }
}
