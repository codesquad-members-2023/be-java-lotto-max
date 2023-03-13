package kr.codesquad.view;

import java.util.Scanner;

public class View {
	public static Scanner scanner = new Scanner(System.in);
	public static Integer countLotto(){
		System.out.println("구입 금액을 입력해주세요.");
		return scanner.nextInt();
	}

	public static Integer bonusNumber(){
		System.out.println("보너스 볼을 입력해 주세요.");
		return scanner.nextInt();
	}

	public static String getLotto(String outputComment){
		System.out.print(outputComment);
		return scanner.next();
	}
	public static String getManualLotto(){
		return scanner.next();
	}

	public static Integer manualLottoCount(){
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return scanner.nextInt();
	}

	public static void printLottoCount(Integer count){
		System.out.println(count+"개를 구입하였습니다.");
	}
	public static void printLotto(String lotto){
		System.out.println(lotto);
	}
	public static void printLottoResult(String result){
		System.out.println("당첨 통계\n" + "---------");
		System.out.println(result);
	}
	public static void printErrorMessage(String errorMessage){
		System.out.println("오류 : "+errorMessage);
	}
}
