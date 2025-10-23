package racingcar;

public class RacingCarValidator {
    private static final String VALIDATE_NAME_BLANK_ERROR_MESSAGE = "일부 이름이 빈칸으로 주어져 있습니다.";
    private static final String VALIDATE_NAME_LENGTH_ERROR_MESSAGE = " 해당 이름 길이가 5글자보다 깁니다.";
    private static final Integer STRICT_LENGTH = 5;

    public static void validateCarName(String[] names){

        for (String name : names){
            if(name.isBlank()) {
                throw new IllegalArgumentException(VALIDATE_NAME_BLANK_ERROR_MESSAGE);
            }
            if(name.length()>STRICT_LENGTH){
                throw  new IllegalArgumentException(name + VALIDATE_NAME_LENGTH_ERROR_MESSAGE);
            }
        }

    }

}
