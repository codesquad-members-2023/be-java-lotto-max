package kr.codesquad.view;

import kr.codesquad.util.Conversion;
import kr.codesquad.util.Validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;

public class InputInfo {

    public static int payForLotto(BufferedReader br, Validation validation) throws IOException {
        System.out.println("구입 금액을 입력해 주세요.");
        int payment = Integer.parseInt(br.readLine());
        while(!validation.isMinimumPrice(payment)) {
            System.out.println("최소 금액은 " + validation.minimumPrice + "원 입니다. 다시 입력해주세요.");
            payment = Integer.parseInt(br.readLine());
        }
        return payment;
    }

    public static Set<Integer> pickWinningNumber(BufferedReader br, Validation validation, Conversion matcher) throws IOException {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNums = br.readLine();
        while (!validation.isValidNums(matcher.storeWinningNums(winningNums))) {
            System.out.println("잘못 입력하셨습니다. 1~45 중 중복되지 않는 숫자 6개를 입력해주세요. \n숫자는 쉼표로 구분해주세요.");
            winningNums = br.readLine();
        }
        return matcher.storeWinningNums(winningNums);
    }

}
