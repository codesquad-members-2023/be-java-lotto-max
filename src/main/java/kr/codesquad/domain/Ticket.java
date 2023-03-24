package kr.codesquad.domain;

import java.util.List;

public class Ticket {

    List<Integer> quickPickNumbers;

    public Ticket(List<Integer> quickPickNumbers) {
        this.quickPickNumbers = quickPickNumbers;
    }

    public String format(Ticket sixNumbers) {
        StringBuilder sb = new StringBuilder();
        int size = sixNumbers.quickPickNumbers.size();
        sb.append("[");
        for(int i = 0; i < size-1; i++) {
            sb.append(sixNumbers.quickPickNumbers.get(i)).append(", ");
        }
        sb.append(sixNumbers.quickPickNumbers.get(size - 1)).append("]");
        return sb.toString();
    }
}
