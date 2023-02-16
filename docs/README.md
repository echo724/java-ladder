## 구현 기능 목록

- [ ] 도메인
  - [ ] 참가자들
      - [X] [예외] 참가자의 이름은 공백일 수 없다.
      - [X] [예외] 참가자의 이름은 1글자 이상 5글자 이하여야 한다.
  - [X] 사다리 생성기
    - [X] 사다리 생성기는 너비, 높이와 포인트 생성기를 받아 사다리를 생성한다.
  - [X] 사다리는 라인 리스트를 갖고있다.
  - [X] 라인은 포인트 리스트를 갖고있다.
    - [X] **포인트 리스트를 반환할 수 있어야한다.(toString vs getter)**

- [X] 유틸
  - [X] 라인 포인트 생성기
    - [X] 메서드 파라미터로 포인트 생성기를 입력받아야 한다.
    - [X] 연속된 포인트 값을 생성하면 안 된다.
  - [X] 포인트 생성기(인터페이스)
  - [X] 랜덤 포인트 생성기(구현체)
  - [X] 포인트(enum)
    - Presence, Absence로 구성된다.

- [ ] 컨트롤러
  - [ ] 사다리 게임
    - [ ] 참여할 사람 이름을 입력받아야한다.
    - [ ] 최대 사다리 높이를 입력 받는다.
    - [ ] 이름과 높이로 사다리 생성자를 호출한다.
    - [ ] 실행 결과를 출력한다.

- [ ] 뷰
  - [ ] 인풋뷰
    - [X] 참여할 사람을 입력 받는다.
    - [X] 쉼표 사이 공백을 제거한다.
      - [X] [예외] 0명 입력되면 예외를 반환한다.
    - [X] 높이를 입력 받는다.
      - [X] [예외] 높이는 자연수여야한다.
  - [ ] 아웃풋 뷰
    - [ ] 에러 메세지를 출력한다.
    - [ ] 실행결과를 출력한다.
      - [ ] 참가자들 이름을 출력한다.
      - [ ] 게임에서 사다리 포인트들의 배열을 받아서 출력한다.