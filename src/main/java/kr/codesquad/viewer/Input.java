package main.java.kr.codesquad.viewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    public Object getBuyAmount() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();
        return input;
    }
}
