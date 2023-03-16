Last Update: 2023-03-16

# 💰 로또
- 미션 기간(max 2주차): 23-03-13 ~ 23-03-17 [5d]
- 2023 코드스쿼드 마스터즈 BE max에서 진행한 `로또`를 구현하는 선택 미션

<br/>

## 🔍 진행 방식
- 로또는 선택 미션으로 스스로의 학습 속도를 돌아보고 진행한다.
- 미션은 단계별로 구성되어 있다. 한꺼번에 다 구현하려고 하지 말고 천천히 제대로 학습하며 단계별로 진행한다.
- `제출 방법`, `기능 요구사항`, `프로그래밍 요구사항`을 최대한 만족하기 위해 노력하며 미션을 진행한다.

<br/>

## 📤 제출 방법
- 미션 단계별로 PR을 생성하여 제출한다.
- PR에 대한 자세한 내용은 [가이드](https://github.com/code-squad/codesquad-docs/blob/main/codereview/README.md)를 참고한다.
- PR 보낼때 다음 요구사항을 지킨다. 
  - 미션의 각 단계를 마무리 한 후 PR을 보낸다. 
  - PR 보낼때 label 설정: 각 단계별 라벨 (ex: step-1) 을 지정해서 보낸다. 
  - 하루에 PR 1개만 보낸다.

<br/>

## 🖥 출력 예시
### 1단계
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 -64.28%입니다.
```

### 2단계
```
[... 생략 ...]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 -64.28%입니다.
```

<br/>

## ⌨️ 프로그래밍 요구사항
- 메소드의 indent(인덴트, 들여쓰기) depth를 1단계로 구현한다. 
  - if문을 사용하는 경우 depth가 1단계 증가한다. if문 안에 while문을 사용한다면 depth는 2단계가 된다. 
- else를 사용하지 마라. 
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다. 
  - method가 한 가지 일만 하도록 최대한 작게 만들어라.
- ArrayList를 사용해서 구현한다.
- 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- enum을 적용해 프로그래밍을 구현한다.

<br/>

---

<br/>

# 🧑🏻‍💻 미션 구현 Log

## 🗓️ 학습 계획
| 날짜       | 내용                 | 완료  |
|:---------|:-------------------|:----|
| 03-13(월) | README 작성 및 1단계 구현 | 🔺  |
| 03-14(화) |                    |     |
| 03-15(수) |                    |     |
| 03-16(목) | 2단계 구현             |     |
| 03-17(금) | 3단계 구현             |     |

<br/>

## ✏️ 1단계 - 기본 기능 구현
### 💬 Brief 일일 회고 및 TIL
- 학습 일정 계획 및 1단계 기능 요구사항 작성
- 1단계 기능 요구사항 중 당첨 통계 출력 기능 제외하고 구현 완료
- 🔖 TIL
  - Exception 테스트 코드 작성 방법 공부

### ✔️ 기능 요구사항
#### 입력 기능
- [X] 로또 구입 금액 입력 기능
- [X] 당첨 번호 입력 기능
- 유효성 검증
  - [X] 당첨 번호를 쉼표로 구분하지 않았을 때 예외처리

#### 출력 기능
- [X] 구입한 로또 정보(개수, 숫자) 출력 기능
- ~~ - [ ] 당첨 통계 출력 기능
  - 당첨 내역 출력
  - 수익률 출력(기대 수익은 동작 예시 참고)~~

#### 구입 금액
- 유효성 검증
  - 로또 1장의 가격은 1000원이다.
  - [X] 1000원 미만으로 입력했을 때 예외처리
  - [X] 1000원 단위로 입력하지 않았을 때 예외처리
  
#### 로또 번호(보너스 번호 포함)
- [X] 로또를 발급하는 기능 
  - 1 ~ 45 범위 내 중복되지 않은 6개의 숫자로 구성된 로또 발행 
  - 발행한 로또 번호를 오름차순으로 정렬하는 기능
- [X] 유효성 검증
  - 6개의 숫자로 구성 
  - 숫자 유효 범위: 1 ~ 45 
  - 중복 값으로 구성 불가

#### 로또 서비스
- [X] 구입 금액에 해당하는 로또를 발행하는 기능

<br/>

## ✏️ 2단계 - 보너스 번호 추가
### 💬 Brief 일일 회고 및 TIL

### ✔️ 기능 요구사항
#### 입력 기능
- [X] 보너스 번호를 입력받는 기능

- [ ] 2등을 위해 추가 번호를 하나 더 추첨하는 기능
