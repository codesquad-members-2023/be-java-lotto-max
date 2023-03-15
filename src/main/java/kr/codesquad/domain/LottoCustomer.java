package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCustomer {
    private int purchaseAmount;
    private final ArrayList<Lotto> lotteries = new ArrayList<>();

    public void putCustomerPurchaseAmount(String answer) {
        this.purchaseAmount = validatePurchaseAmount(answer);
    }

    private int validatePurchaseAmount(String answer) {
        int purchaseAmount = changeInt(answer);
        isPositiveNum(changeInt(answer));
        return purchaseAmount;
    }

    private int changeInt(String answer) {
        try {
            return Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private void isPositiveNum(int purchaseAmount) {
        if(purchaseAmount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void decideNumberOfLotto() {
        int numberOfLotto = purchaseAmount / 1000;
        purchaseAmount -= numberOfLotto * 1000;
        IntStream.range(0, numberOfLotto).forEach(i -> lotteries.add(new Lotto()));
    }

    @Override
    public String toString() {
        return lotteries.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
