# java-racingcar-precourse
## 주요 기능
* 사용자 정보 입력
  * 경주할 자동차 이름 입력을 받는다.
    * 쉼표 기준으로 구분한다
    * 이름은 5자 이하이다.
    * 잘못된 입력 시 IllegalArgumentException를 발생시킨다.
  * 시도할 횟수를 입력 받는다.
    * 1이상 정수로 이루어져야 한다. 
    * 잘못된 입력(음수, 소수, 0 등)시  IllegalArgumentException를 발생시킨다. 
* 경주 진행
  * 주어진 횟수만큼 반복한다.
  * 무작위 값(0-9)을 던진다.
  * 무작위 값이 4이상일 때 전진한다.
  * 각 차수별 결과를 출력한다.
* 최종 우승자 출력
  * 가장 많이 전진한 자동차를 찾고 저장한다.
  * 우승자 여러 명이면 쉼표를 이용해서 구분한다. 
* 예외 처리 
  * 사용자가 잘못된 값 입력 시 IllegalArgumentException를 발생시킨다.
## 구현 순서
- 경주할 자동차 이름을 입력 받는다.(쉼표 기준으로 구분한다)
- 자동차 이름 규칙에 맞게 되었는지 검증한다. 
- 시도할 횟수 입력 및 검증한다.
- 각 차수별 각 자동차마다 무작위 값을 구한다.
- 무작위 구한 값을 자동차 별로 저장한다.
- 현재 자동차 이동 상태를 출력한다.
- 가장 길이가 길거나 큰 값을 구해서 해당 이름을 가져와서 저장한다.
- 저장된 최종 우승자 결과를 출력한다. 
## 프로그래밍 요구 사항 1
* JDK 21 버전에서 실행 가능해야 한다.
* 프로그램 실행의 시작점은 Application의 main()이다.
* build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
* 프로그램 종료 시 System.exit()를 호출하지 않는다.
* 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
* 기본적으로 Java Style Guide를 원칙으로 한다.
## 프로그래밍 요구사항 2
* indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 3항 연산자를 쓰지 않는다.
* 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
* JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
  * 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
    * JUnit 5 User Guide
      * AssertJ User Guide
      * AssertJ Exception Assertions
      * Guide to JUnit 5 Parameterized Tests
### 라이브러리
* camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  * Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
* 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

**사용 예시**

0에서 9까지의 정수 중 한 개의 정수 반환
``` Randoms.pickNumberInRange(0, 9);```