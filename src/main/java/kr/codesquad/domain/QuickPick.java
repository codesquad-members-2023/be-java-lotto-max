package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickPick {

    public List<Integer> create() {
        List<Integer> numberList = new ArrayList<>();
        shuffleNumbers(numberList);
        return pickSixNumbers(numberList);
    }

    public void shuffleNumbers(List<Integer> numberList) {
        for(int i = 1; i <= 45; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
    }

    public List<Integer> pickSixNumbers(List<Integer> numberList) {
        List<Integer> pickedNums = numberList.subList(0, 6);
        Collections.sort(pickedNums);
        return pickedNums;
    }
}
