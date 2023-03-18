package kr.codesquad.view;

import kr.codesquad.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseCnt = Integer.parseInt(this.scanner.nextLine()) / 1000;
        System.out.println(purchaseCnt + "개를 구매했습니다.");
        return purchaseCnt;
    }

    public WinningLotto getWinningLotto() {
        System.out.println("\r\n지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> lotto = Arrays.stream(this.scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = Integer.parseInt(this.scanner.nextLine());
        return new WinningLotto(lotto, bonus);
    }
}
