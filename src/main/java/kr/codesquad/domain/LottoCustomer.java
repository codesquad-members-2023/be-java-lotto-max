package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCustomer {
    private int purchaseAmount;
    private final ArrayList<Lotto> lotteries = new ArrayList<>();

    public void putCustomerPurchaseAmount(String purchaseAmountStr) {
        this.purchaseAmount = validatePurchaseAmount(purchaseAmountStr);
    }

    private int validatePurchaseAmount(String purchaseAmountStr) {
        int purchaseAmount = changeInt(purchaseAmountStr);
        isPositiveNum(purchaseAmount);
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
        if(purchaseAmount <= Config.ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public void purchaseLotto() {
        IntStream.range(Config.ZERO, getCountOfLotto()).forEach(i -> lotteries.add(new Lotto()));
    }

    public int getCountOfLotto() {
        return purchaseAmount / Config.PRICE_OF_LOTTO;
    }

    public double getEarningsRate(double totalWinAmount) {
        return totalWinAmount / purchaseAmount * Config.PERCENT;
    }

    public void checkLuckyNumbers(ArrayList<Integer> luckyNumbers) {
        lotteries.forEach(s -> s.checkLuckyNumbersContain(luckyNumbers));
    }

    @Override
    public String toString() {
        return lotteries.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(Config.LINE_BREAK));
    }
}
