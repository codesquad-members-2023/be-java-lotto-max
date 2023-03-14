package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Lotto {
    private ArrayList<Integer> luckyNumbers = new ArrayList<>();

    public void createLuckyNumbers(String answer) {
        int[] numbers = new int[6];
        try {
            String[] strings = answer.replaceAll(" ", "").split(",");
            for (int i = 0; i < strings.length; i++) {
                numbers[i] = Integer.parseInt(strings[i]);
                if(numbers[i] <= 0 || numbers[i] > 45) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        luckyNumbers = (ArrayList<Integer>) Arrays.stream(numbers).boxed().collect(Collectors.toList());
    }
}
