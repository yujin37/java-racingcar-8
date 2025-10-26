# java-racingcar-precourse

## 자동차 경주

> 초간단 자동차 경주 게임을 구현한다.
> - 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
> - 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
> - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
> - 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
> - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
> - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
> - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
> - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 목차

[1. 디렉토리 구조](#디렉토리-구조) \
[2. 기능 목록](#기능-목록) \
[3. 진행 구조](#진행-구조)

## 디렉토리 구조

```commandline
├───main
│   └───java
│       └───racingcar
│           │   Application.java #프로그램 시작
│           │
│           ├───controller
│           │       RacingCarController.java #게임 전체 제어
│           │
│           ├───model
│           │       Car.java # 차 객체
│           │       Dice.java # 주사위 객체
│           │       ErrorCode.java # 예외 메시지 정의
│           │       RacingCarNameParser.java # 이름 파싱 처리
│           │       RacingCarRace.java # 경기 진행 로직
│           │       RacingCarValidator.java # 이름 및 시도횟수 검증 로직
│           │
│           └───view
│                   RacingCarInputView.java # 입력 처리
│                   RacingCarOutputView.java # 출력 처리
│
└───test
    └───java
        └───racingcar
                ApplicationTest.java # 기본 테스트
                CarTest.java # 차 객체 생성 테스트
                DiceTest.java # 주사위 객체 생성 테스트
                RacingCarNameParserTest.java # 이름 파싱 테스트
                RacingCarValidatorTest.java # 이름, 횟수 검증 테스트
                TestErrorCode.java # 테스트 예외 메시지 정의


```

## 기능 목록

### 자동차 이름 입력

- [x] 경주할 자동차 이름 입력
- [x] 쉼표(,) 기준으로 구분
- [x] 잘못된 입력 시 IllegalArgumentException를 발생
    - [x] 이름이 비어있는 경우
    - [x] 이름 길이가 5글자 초과하는 경우
    - [x] 중복된 이름이 있는 경우
    - [x] 이름 형식이 잘못된 경우 (`A-Z`, `a-z`, `가-힣`, `0-9`, `_` 허용)
    - [x] 이름 총 개수가 초과하는 경우(최소 2개 최대 10개 허용)

### 시도할 횟수 입력

- [x] 시도할 횟수를 입력
- [x] 잘못된 입력 시 IllegalArgumentException를 발생
    - [x] 시도 횟수가 비어있는 경우
    - [x] 시도 횟수가 허용되지 않은 형태인 경우(소수(`2.5`), 문자)
    - [x] 시도 횟수 0 혹은 음수인 경우
    - [x] 시도 횟수 최대 숫자(10만)를 넘어가는 경우

### 경주 진행

- [x] 주어진 횟수만큼 반복
    - [x] 무작위 값(0-9)을 던짐
        - [x] 무작위 값이 4이상일 때 전진
    - [x] 각 차수별 결과를 출력
- [x] 가장 많이 전진한 자동차를 찾고 저장
- [x] 우승자 여러 명이면 쉼표를 이용해서 구분
- [x] 최종 우승자 출력

## 진행 구조

- 자동차 이름 입력(`InputView.inputCarName`)
- 자동차 이름 검증(`Validator.validateCarName`)
- 자동차 이름 파싱(`NameParser.parseCarName`)
- 시도할 횟수 입력(`InputView.inputTryCount`)
- 시도할 횟수 검증(`Validator.validateTryCount`)
- 레이스 진행(`Race.game`)
    - 자동차 객체 생성(`Car`, `Race.game`)
    - 주사위 객체 생성 및 결과 반환(`Dice`, `Race.playRounds`)
    - 자동차 이동 경로 기록(`Race.moveCars`, `moveCarIfPossible`)
    - 각 회차 결과 출력(`OutputView.perMemberResult`)
- 최종 이동 결과 파악 및 저장(`Race.calculateWinner`)
- 최종 우승자 출력(`OutputView.finalWinner`)