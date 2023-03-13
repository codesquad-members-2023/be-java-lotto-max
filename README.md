# Java Lotto

코드스쿼드 마스터즈 백엔드 프로젝트 로또

- 결과
  <img width="433" alt="image" src="https://user-images.githubusercontent.com/75569293/224648640-5f86f0ee-afb5-4845-a506-345122f3f87e.png">
##고민 사항 및 리팩토링할 사항
- 예외처리를 어디서 해야하는가에 대한 고민
  - 입력값을 받은 클래스에서 처리하는 게 맞나?
  - View 클래스에서 처리해야 하나?
- LottoGame 클래스에 너무 많은 클래스들이 연결되어있다.
  - 결합도를 낮추자