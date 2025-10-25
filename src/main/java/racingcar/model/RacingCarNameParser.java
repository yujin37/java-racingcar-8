package racingcar.model;

public class RacingCarNameParser {
    public static String[] parseCarName(String carName){
        return carName.split(",");
    }
}
