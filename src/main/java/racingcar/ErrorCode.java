package racingcar;

public enum ErrorCode {
    VALIDATE_NAME_BLANK("일부 이름이 빈칸으로 주어져 있습니다."),
    VALIDATE_NAME_LENGTH(" 해당 이름 길이가 5글자보다 깁니다."),
    VALIDATE_DUPLICATION(" 해당 이름이 이전에 나온 적 있습니다."),
    VALIDATE_NOT_ALLOWED_CHAR(" 해당 이름이 이름 규칙에 맞지 않습니다. 이름에는 숫자, 영문자, 한글, _만 나올 수 있습니다."),
    VALIDATE_TRY_EMPTY("시도 횟수 입력이 비어있습니다."),
    VALIDATE_TRY_NOT_INTEGER("시도 횟수가 허용되지 않은 형태로 입력되었습니다. 반드시 자연수로 입력되어야 합니다."),
    VALIDATE_TRY_NOT_ZERO_AND_NEGATIVE("시도 횟수는 반드시 0보다 큰 자연수로 입력되어야 합니다."),
    VALIDATE_TRY_ALLOWED_ARRANGE("시도 횟수 범위가 초과되었습니다. 시도 횟수는 최대 10만 이내로만 제한합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

}
