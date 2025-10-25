package racingcar.model;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.regex.Pattern;

public class RacingCarValidator {
    private static final Integer STRICT_LENGTH = 5;
    private static final Pattern pattern = Pattern.compile("^[0-9a-zA-Z가-힣_]*$");
    private static final BigInteger MAX_TRYCOUNT = BigInteger.valueOf(100000);

    public static void validateCarName(String[] names) {
        HashSet<String> uniqueName = new HashSet<String>();
        for (String name : names) {
            name = name.trim();
            if(name.isEmpty()) {
                throw new IllegalArgumentException(ErrorCode.VALIDATE_NAME_BLANK.getMessage());
            }
            if(name.length() > STRICT_LENGTH) {
                throw  new IllegalArgumentException(name + ErrorCode.VALIDATE_NAME_LENGTH.getMessage());
            }
            if(uniqueName.contains(name)) {
                throw new IllegalArgumentException(name + ErrorCode.VALIDATE_DUPLICATION.getMessage());
            }
            if(!pattern.matcher(name).matches()) {
                throw new IllegalArgumentException(name + ErrorCode.VALIDATE_NOT_ALLOWED_CHAR.getMessage());
            }
            uniqueName.add(name.trim());
        }

    }
    public static void validateTryCount(String count) {
        if(count.isEmpty() || count.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.VALIDATE_TRY_EMPTY.getMessage());
        }

        BigInteger intCount;

        try {
            intCount = new BigInteger(count);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorCode.VALIDATE_TRY_NOT_INTEGER.getMessage());
        }

        if(intCount.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException(ErrorCode.VALIDATE_TRY_NOT_ZERO_AND_NEGATIVE.getMessage());
        }

        if(intCount.compareTo(MAX_TRYCOUNT) > 0) {
            throw new IllegalArgumentException(ErrorCode.VALIDATE_TRY_ALLOWED_ARRANGE.getMessage());
        }
    }

}
