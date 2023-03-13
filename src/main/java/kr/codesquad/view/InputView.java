package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public InputView() {
    }

    public int InputLottoPurchaseMoney() throws IOException {
        // 숫자를 입력하면 예외 발생
        return Integer.parseInt(br.readLine());
    }

    public List<Integer> InputWinningNumbers() throws IOException {
        return Arrays.stream(br.readLine().split("\\s*,\\s*"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
