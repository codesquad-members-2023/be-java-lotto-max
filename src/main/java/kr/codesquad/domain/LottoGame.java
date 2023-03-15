package main.java.kr.codesquad.domain;

import main.java.kr.codesquad.viewer.LottoInput;
import main.java.kr.codesquad.viewer.LottoOutput;

import java.io.IOException;

public class LottoGame {

    //책임: 뷰어와 도메인 클래스들의 상호작용 관리 + 모듈간에 상호작용도 관리(지양해야 할까?)

    public void start() throws IOException {
        LottoInput input = new LottoInput();
        LottoOutput output = new LottoOutput();

        //구매 금액 입력 받기
        Amount amount = new Amount(input.getPurchaseAmount());

        //티켓 생성
        TicketMaker ticketMaker = new TicketMaker(amount.calculateTicketCount());

        //티켓 정보 출력
        output.printTicketNumber(ticketMaker.toString());

        //당첨 번호 입력 받기
        WinningNumbers winningNumbers = new WinningNumbers(input.getWinningNumbers());

        //통계 만들기
        StatisticMaker statisticMaker = new StatisticMaker(winningNumbers.getNumbers(), ticketMaker.getTickets(), amount);

        //통계 출력
        output.printResult(statisticMaker.toString());
    }
}
