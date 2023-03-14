package kr.codesquad.domain;

import java.util.ArrayList;

public class LottoCustomer {
    private final int purchaseAmount;
    private ArrayList<Lotto> lotto = new ArrayList<>();

    public LottoCustomer(String answer) {
        this.purchaseAmount = validatePurchaseAmount(answer);
    }

    private int validatePurchaseAmount(String answer) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        if(purchaseAmount <= 0) {
            throw new IllegalArgumentException();
        }
        return purchaseAmount;
    }
}
