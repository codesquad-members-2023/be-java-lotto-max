package main.java.kr.codesquad.domain;

import com.mysql.cj.exceptions.ClosedOnExpiredPasswordException;

import java.util.ArrayList;

public class Ticket {

    ArrayList<Integer> lottoNumbers;

    public Ticket(ArrayList<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;

    }

    public Integer countMatchingNumbers(ArrayList<Integer> lottoResultNumbers) {
        int count = 0;
        for (int n : lottoResultNumbers) {
            if(this.lottoNumbers.contains(n)){
                count++;
            }
        }
        return count;
    }
}
