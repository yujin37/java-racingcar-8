package racingcar;

public class RacingCarNameParser {
    public static String[] parseCarName(String carName){
        return carName.replace(" ","").split(",");
    }
}
