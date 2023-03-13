# 요일별 계획

- 월요일
    - [ ] step-1 구현 후 테스트 코드
    - [ ] 오브젝트 챕터 1 다시 읽기
        - [ ] `charlie`가 추천해준 방식으로 하고, 코드를 다 직접 작성하진 않기
- 화요일
    - [ ] step-2 구현 후 테스트 코드
    - [ ] 오브젝트 챕터 2 다시 읽기
- 수요일
    - [ ] step-3 구현 후 테스트 코드
    - [ ] 오브젝트 챕터 3 읽기
- 목요일
    - [ ] 구현 코드와 테스트 코드 최종 수정
    - [ ] 오브젝트 챕터 4, 5 읽기
- 금요일
    - [ ] 오브젝트 챕터 6, 7, 8 읽기

# step-1 설계

## 로또란?

- 로또를 사본 적도 없고, 앞으로 살 생각도 없어서 룰 조차 몰랐음
- 로또의 당첨 원리: 1부터 45까지 각각 적힌 총 45개 숫자 중 6개를 맞추면 되는 것

## view 패키지

- InputView
    - 구입 금액, 당첨 번호를 입력 받는 클래스
        - 구입 금액: 숫자 입력인데도 1000으로 나누어 떨이지지 않거나, 숫자가 아니면 다시 입력 받도록 처리
        - 당첨 번호: 숫자와 "," 외에 다른 것이 입력받으면 다시 입력받도록 처리
            - `split("\\s*" + "," + "\\s*"))`을 사용하여 ArrayList 배열로 저장
                - 이 배열을 LottoWinningStatisticsManager 클래스에 넘겨줌

<br>

- OutputView
    - 로또, 당첨 통계, 콘솔 출력에 관련된 객체를 호출하여 출력하는 클래스

## domain 패키지

- Lotto 클래스
    - 전체적인 로또에 대한 입출력을 관리하는 클래스
    - `start()` 메서드를 생성하여 Main 클래스에서는 이 메서드만 실행하면 되도록 함

- LottoAmountInverter 클래스
    - 구입 금액을 InputView 클래스에서 받아와서 몇 개를 구매했는지 처리하는 클래스
    - 그 몇 개인지를 LottoGenerator 클래스에 넘겨줌

<br>

- LottoGenerator 클래스
    - `ArrayList`의 2차원 배열을 생성
    - 1차원 배열을 가지고 계속해서 처리하면서 2차원 배열로 만들어줌
        - 이 2차원 배열을 OutputView 클래스에 넘겨줌
    - `Collections.shuffle()` 메서드 활용 -> 자동 생성
    - `Collections.sort()` 메서드 활용 -> 정렬
    - `ArrayList.contains()` 메서드 활용 -> 어떤 값이 존재하는지 유무 판단

<br>

- LottoNumberMatcher
    - 몇 개가 일치하는지 계산하는 클래스

<br>

- LottoYieldCalculator 클래스
    - 수익률을 계산하는 클래스

<br>

- LottoWinningStatisticsManager 클래스
    - LottoGenerator 클래스에서 생성한 2차원 배열을 호출
    - InputView 클래스에서 당첨 번호 호출
    - 전체적인 당첨 통계 관리
    - 2차원 배열을 아래의 클래스들에 넘겨주고, 결과를 리시브
        - LottoNumberMatcher 클래스 관리
        - LottoYieldCalculator 클래스 관리
    - 이 결과를 OutputView 클래스에 넘겨줌

## Main 클래스

- Lotto 클래스에 있는 `start()` 메서드를 실행

## 단위 테스트

- 일단 최대한 지금 가지고 있는 지식을 꺼내서 클래스 작성 계획을 위처럼 짜봤지만..
- 단위 테스트를 작성하는 데에 있어서 분명 부족한 점이 존재할 것이기 때문에
- 구현 후 리팩토링하는 과정에서 꼭 기능 하나당 테스트 하나씩 작성할 예정