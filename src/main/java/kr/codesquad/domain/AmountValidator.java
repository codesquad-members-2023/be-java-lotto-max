package main.java.kr.codesquad.domain;

public class AmountValidator {
    //구매 금액 검증


    public int validateAmount(int ticketPrice, String inputAmount) {
        try{
            int amount = Integer.parseInt(inputAmount);
        } catch (Exception e){
            throw new IllegalArgumentException("Please enter an Integer");
        }

        if(Integer.parseInt(inputAmount) % ticketPrice != 0){
            throw new IllegalArgumentException("Please enter an amount that is multiple of "+ ticketPrice);
        }
        return Integer.parseInt(inputAmount);
    }
}
