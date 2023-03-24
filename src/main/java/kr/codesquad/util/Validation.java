package kr.codesquad.util;

import java.util.Set;

public class Validation {
    public final int minimumPrice = 1000;
    public final int numOfWinningNums = 6;
    public boolean isMinimumPrice(int payment) {
        return payment % minimumPrice == 0;
    }

    public boolean isValidNums(Set<Integer> winningNumList) {
        return isNotDuplicated(winningNumList) && isInRange(winningNumList);
    }

    public boolean isNotDuplicated(Set<Integer> winningNumList) {
        return winningNumList.size() == numOfWinningNums;
    }

    public boolean isInRange(Set<Integer> winningNumList) {
        return winningNumList.stream().allMatch(num -> num > 0 && num <= 45);
    }
}
