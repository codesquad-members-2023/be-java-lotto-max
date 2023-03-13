package kr.codesquad.view;

import java.io.BufferedReader;
import java.io.IOException;

public class Input {
    public String input(BufferedReader br, int index) throws IOException {
        String[] question = {"구입금액을 입력해 주세요."
                , "당첨 번호를 입력해 주세요."};
        System.out.println(question[index]);
        return br.readLine();
    }
}
