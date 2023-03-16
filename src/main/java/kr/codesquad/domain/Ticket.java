package main.java.kr.codesquad.domain;


import java.util.ArrayList;

public class Ticket {
    //책임: 검증?

    ArrayList<Integer> lottoNumbers;

    public Ticket(ArrayList<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;

    }

    public ArrayList<Integer>  getNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer n : lottoNumbers){
            sb.append(n).append(", ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");

        return sb.toString();
    }


}
