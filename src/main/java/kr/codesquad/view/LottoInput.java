package kr.codesquad.view;

import kr.codesquad.domain.LottoCustomer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoInput {
    public static String inputAnswer(int index) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] question = {"구입금액을 입력해 주세요."
                , "당첨 번호를 입력해 주세요."};
        System.out.println(question[index]);
        return br.readLine();
    }

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

    public static ArrayList<Integer> inputLuckyNumber() throws IOException {
        boolean validLuckyNumbers = false;
        String[] answer = new String[6];
        while (!validLuckyNumbers) {
            answer = inputAnswer(1).replaceAll(" ", "").split(",");
            validLuckyNumbers = checkLuckyNumbers(answer);
        }
        return (ArrayList<Integer>) Arrays.stream(answer)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static boolean checkLuckyNumbers(String[] answer) {
        try {
            createLuckyNumbers(answer);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("정수가 아닙니다.");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("로또 번호는 1 ~ 45 사이의 수 6개로 이루어져야 합니다.");
            return false;
        }
    }

    public static void createLuckyNumbers(String[] answer) {
        try {
            validateLuckyNumbers(answer);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private static void validateLuckyNumbers(String[] strings) {
        if(strings.length != 6) {
            throw new IllegalArgumentException();
        }
        for (String string : strings) {
            limitLuckyNumbers(Integer.parseInt(string));
        }
    }

    private static void limitLuckyNumbers(int luckyNumber) {
        if(luckyNumber <= 0 || luckyNumber > 45) {
            throw new IllegalArgumentException();
        }
    }
}
