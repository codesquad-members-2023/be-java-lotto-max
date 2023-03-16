package kr.codesquad.view;

import kr.codesquad.domain.Config;
import kr.codesquad.domain.LottoCustomer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoInput {
    public static String inputAnswer(int index) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] question = {Config.ASK_PURCHASE_AMOUNT
                , Config.ASK_WINNING_NUMBERS
                , Config.ASK_BONUS_BALL};
        System.out.println(question[index]);
        return br.readLine();
    }

    public static boolean inputPurchaseAmount(LottoCustomer lottoCustomer, String answer) {
        try {
            lottoCustomer.putCustomerPurchaseAmount(answer);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(Config.NOT_INTEGER);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(Config.IS_POSITIVE_NUMBER);
            return false;
        }
    }

    public static ArrayList<Integer> inputLuckyNumber() throws IOException {
        boolean validLuckyNumbers = false;
        Set<String> answer = new HashSet<>();
        while (!validLuckyNumbers) {
            answer = Arrays.stream(inputAnswer(Config.ASK_WINNING_NUMBERS_NUMBER)
                    .replaceAll(" ", "")
                    .split(","))
                    .collect(Collectors.toSet());
            validLuckyNumbers = checkLuckyNumbers(answer);
        }
        return (ArrayList<Integer>) answer.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static boolean checkLuckyNumbers(Set<String> answer) {
        try {
            createLuckyNumbers(answer);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(Config.NOT_INTEGER);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(Config.LOTTO_NUMBER_LIMIT);
            return false;
        }
    }

    public static void createLuckyNumbers(Set<String> answer) {
        try {
            validateLuckyNumbers(answer);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    private static void validateLuckyNumbers(Set<String> strings) {
        if(strings.size() != Config.LOTTO_BALL_NUMBER) {
            throw new IllegalArgumentException();
        }
        for (String string : strings) {
            limitLuckyNumbers(Integer.parseInt(string));
        }
    }

    private static void limitLuckyNumbers(int luckyNumber) {
        if(luckyNumber < Config.MIN_LOTTO_NUMBER || luckyNumber > Config.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
