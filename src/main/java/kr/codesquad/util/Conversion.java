package kr.codesquad.util;

import java.util.*;

public class Conversion {

    public Set<Integer> storeWinningNums(String winningNums) {
        Set<Integer> winningNumList = new HashSet<>();
        String[] nums = winningNums.split(",");
        for(String num : nums) {
            winningNumList.add(Integer.valueOf(num.trim()));
        }
        return winningNumList;
    }
}
