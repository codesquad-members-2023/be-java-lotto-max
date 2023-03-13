package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InputView {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int getPriceInput() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public ArrayList<Integer> getNumbersInput() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), ", ");
        Integer[] input = new Integer[6];
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        return new ArrayList<>(Arrays.asList(input));
    }

    public void printRequestPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void printRequestWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요. 번호는 6개이며 \", \"으로 구분합니다. ex) 1, 2, 3, 4, 5, 6");
    }

}
