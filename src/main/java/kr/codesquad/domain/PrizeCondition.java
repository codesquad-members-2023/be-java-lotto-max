package main.java.kr.codesquad.domain;

import java.util.ArrayList;

public abstract class PrizeCondition {
    //추상 클래스 - 책임: 당첨 조건 확인 + 금액 반환
    protected static final int NO_PRIZE = 0;


     abstract protected int returnPrize(ArrayList<Integer> winningNumbers, ArrayList<Integer> ticketNumber);

    abstract protected boolean checkCondition(ArrayList<Integer> winningNumbers, ArrayList<Integer> ticketNumber);

     @Override
     public abstract String toString();


}

