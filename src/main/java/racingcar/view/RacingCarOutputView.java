package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class RacingCarOutputView {

    private static final String RUN_RESULT_MESSAGE = "실행결과";
    private static final String PER_RESULT_SEPERATOR = " : ";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String FINAL_WINNER_SEPERATOR = ", ";

    public static void runMessage() {
        System.out.println();
        System.out.println(RUN_RESULT_MESSAGE);
    }

    public static void perMemberResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + PER_RESULT_SEPERATOR + car.getDashMove());
        }
        System.out.println();
    }

    public static void finalWinner(List<String> winners) {
        System.out.println(FINAL_WINNER_MESSAGE + String.join(FINAL_WINNER_SEPERATOR, winners));
    }
}
