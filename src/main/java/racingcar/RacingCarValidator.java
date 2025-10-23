package racingcar;

import java.util.HashSet;
import java.util.regex.Pattern;

public class RacingCarValidator {
    private static final String VALIDATE_NAME_BLANK_ERROR_MESSAGE = "일부 이름이 빈칸으로 주어져 있습니다.";
    private static final String VALIDATE_NAME_LENGTH_ERROR_MESSAGE = " 해당 이름 길이가 5글자보다 깁니다.";
    private static final String VALIDATE_DUPLICATION_ERROR_MESSAGE = " 해당 이름이 이전에 나온 적 있습니다.";
    private static final String VALIDATE_NOT_ALLOWED_CHAR_ERROR_MESSAGE = " 해당 이름이 이름 규칙에 맞지 않습니다. 이름에는 숫자, 영문자, 한글, _만 나올 수 있습니다.";
    private static final Integer STRICT_LENGTH = 5;
    private static final Pattern pattern = Pattern.compile("^[0-9a-zA-Z가-힣_]*$");

    public static void validateCarName(String[] names){
        HashSet<String> uniqueName = new HashSet<String>();
        for (String name : names){
            if(name.isBlank()) {
                throw new IllegalArgumentException(VALIDATE_NAME_BLANK_ERROR_MESSAGE);
            }
            if(name.length()>STRICT_LENGTH){
                throw  new IllegalArgumentException(name + VALIDATE_NAME_LENGTH_ERROR_MESSAGE);
            }
            if(uniqueName.contains(name)){
                throw new IllegalArgumentException(name + VALIDATE_DUPLICATION_ERROR_MESSAGE);
            }
            if(!pattern.matcher(name).matches()){
                throw new IllegalArgumentException(name + VALIDATE_NOT_ALLOWED_CHAR_ERROR_MESSAGE);
            }
            uniqueName.add(name);
        }

    }

}
