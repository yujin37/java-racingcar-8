package racingcar.model;

public class RacingCarNameParser {
    private static final String SPLIT_CHAR = ",";

    public static String[] parseCarName(String carName) {
        return carName.split(SPLIT_CHAR);
    }
}
