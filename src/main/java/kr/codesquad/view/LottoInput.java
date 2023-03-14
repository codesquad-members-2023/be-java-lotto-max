package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LottoInput {
    public static int inputPurchaseAmount() throws IOException {
        try {
            return Integer.parseInt(input(0));
        } catch (NumberFormatException e) {
            System.out.println("정수가 아닙니다.");
            return Integer.parseInt(input(0));
        }
    }
    private static String input(int index) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] question = {"구입금액을 입력해 주세요."
                , "당첨 번호를 입력해 주세요."};
        System.out.println(question[index]);
        return br.readLine();
    }
}
