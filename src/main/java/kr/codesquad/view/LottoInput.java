package kr.codesquad.view;

import kr.codesquad.domain.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class LottoInput {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final InputValidator inputValidator = new InputValidator();

    public LottoInput() {
    }

    public int inputLottoPurchaseMoney() throws IOException {
        System.out.println("구입 금액을 입력해 주세요.");
        return inputValidator.validateInputLottoPurchaseMoney(br);
    }

    public List<Integer> inputWinningNumbers() throws IOException {
        System.out.println("당첨 번호를 입력해 주세요.");
        return inputValidator.validateInputWinningNumbers(br);
    }

    public int inputBonus() throws IOException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return inputValidator.validateInputBonus(br);
    }
}
