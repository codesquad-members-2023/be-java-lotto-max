package kr.codesquad.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class InputView {

	private final Scanner sc = new Scanner(System.in);

	public String getPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		return sc.nextLine();
	}

	public String getWinning() {
		System.out.println("당첨 번호를 입력해 주세요.");
		return sc.nextLine();
	}

	public String getBonusNumber() {
		System.out.println("보너스 볼을 입력해주세요.");
		return sc.nextLine();
	}

	public String getCountOfManualLottery() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return sc.nextLine();
	}

	public List<String> getManualLotteries(final int countOfManualLottery) {
		System.out.println("수동으로 구매할 번호를 입력해 주세요.");
		List<String> manualLotteries = new ArrayList<>();
		IntStream.range(0, countOfManualLottery)
			.forEach(idx -> manualLotteries.add(sc.nextLine()));

		return manualLotteries;
	}
}
