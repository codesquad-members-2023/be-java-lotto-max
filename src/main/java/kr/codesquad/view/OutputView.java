package kr.codesquad.view;

public class OutputView {
    public OutputView() {
    }

    public void outputRequestLottoPurchaseMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void outputLottoAmountNumber(int lottoAmount) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }
}
