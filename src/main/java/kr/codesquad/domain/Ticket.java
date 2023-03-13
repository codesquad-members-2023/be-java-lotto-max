package main.java.kr.codesquad.domain;

import com.mysql.cj.exceptions.ClosedOnExpiredPasswordException;

import java.util.ArrayList;

public class Ticket {

    ArrayList<Integer> lottoNumbers;

    public Ticket(ArrayList<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;

    }
}
