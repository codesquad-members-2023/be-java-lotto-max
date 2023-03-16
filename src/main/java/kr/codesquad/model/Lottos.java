package kr.codesquad.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 여러 개를 의미하는 객체
 */
public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
