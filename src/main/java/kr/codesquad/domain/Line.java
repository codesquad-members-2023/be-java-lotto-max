package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Line {
    public ArrayList<Integer> numbers;

    public Line() {
        numbers = makeLine();
    }

    private ArrayList<Integer> makeLine() {
        HashSet<Integer> line = new HashSet<>();
        Random random = new Random();
        while (line.size() != 6) {
            line.add(random.nextInt(45) + 1);//todo : 의문점? Collections.shuffle()은 1~45를 다 넣고 뽑아야하는데 더 비효율적이지 않나?
        }
        ArrayList<Integer> list = new ArrayList<>(line);
        Collections.sort(list);
        return list;
    }
}
