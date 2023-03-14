package main.java.kr.codesquad.domain;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class WinningNumbers {

    ArrayList<Integer> winningNumbers = new ArrayList<>();

    public WinningNumbers(String input) {
        this.assignWinningNumbers(input);
    }
    

    private void assignWinningNumbers(String input) {
        StringTokenizer st = new StringTokenizer(input, ",");
        while(st.hasMoreTokens()){
            this.winningNumbers.add(Integer.parseInt(st.nextToken()));
        }
    }
}
