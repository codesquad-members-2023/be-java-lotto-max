package kr.codesquad.view;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.LottoCustomer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LottoInput {
    public static boolean inputPurchaseAmount(LottoCustomer lottoCustomer, String answer) {
        try {
            lottoCustomer.putCustomerPurchaseAmount(answer);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("정수가 아닙니다.");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("구입 금액은 0보다 커야합니다.");
            return false;
        }
    }

    public static boolean inputLuckyNumber(Lotto lotto) throws IOException {
        try {
//            createLuckyNumbers(inputAnswer(1));
            return true;
        } catch (NumberFormatException e) {
            System.out.println("정수가 아닙니다.");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("로또 번호는 1~45 사이의 수여야 합니다.");
            return false;
        }
    }
    public static String inputAnswer(int index) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] question = {"구입금액을 입력해 주세요."
                , "당첨 번호를 입력해 주세요."};
        System.out.println(question[index]);
        return br.readLine();
    }
}
