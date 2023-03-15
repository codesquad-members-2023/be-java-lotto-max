package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final ArrayList<Integer> lotto;
    private final ArrayList<Integer> numbers = (ArrayList<Integer>) IntStream.rangeClosed(1, 45)
            .boxed().collect(Collectors.toList());

    public Lotto() {
        Collections.shuffle(numbers);
        lotto = (ArrayList<Integer>) numbers.stream().limit(6).collect(Collectors.toList());
        Collections.sort(lotto);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
