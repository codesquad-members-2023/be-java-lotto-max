package kr.codesquad.view;

import java.util.Optional;
import java.util.Scanner;

public class InputManualLottoCountManager {

	public Optional<Integer> askClient(int quantity) {
		try {
			System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
			Scanner scanner = new Scanner(System.in);
			String countString = scanner.nextLine();
			InputManagerValidator.validIsDigit(countString);
			int count = Integer.parseInt(countString);
			InputManagerValidator.validInRange(quantity, count);
			return Optional.of(count);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
