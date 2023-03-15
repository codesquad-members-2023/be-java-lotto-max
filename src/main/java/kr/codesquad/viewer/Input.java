package main.java.kr.codesquad.viewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    //유저가 입력한 금액을 String으로 리턴한다.
    public String getPurchaseAmount() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        return input;
    }

    public String getWinningNumbers() throws IOException {
        System.out.println("당첨 번호를 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        return input;
    }
}
