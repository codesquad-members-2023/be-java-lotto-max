package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public InputView() {
    }

    public int InputLottoPurchaseMoney() throws IOException {
        // 숫자를 입력하면 예외 발생
        return Integer.parseInt(br.readLine());
    }
}
