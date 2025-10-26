package racingcar.model;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.regex.Pattern;

public class RacingCarValidator {
    private static final Integer STRICT_LENGTH = 5;
    private static final Pattern pattern = Pattern.compile("^[0-9a-zA-Z가-힣_]*$");
    private static final BigInteger MAX_TRYCOUNT = BigInteger.valueOf(100000);
    private static final int minCar = 2;
    private static final int maxCar = 10;

    public static void validateCarName(String[] names) {
        HashSet<String> uniqueName = new HashSet<String>();
        for (String name : names) {
            name = name.trim();
            nameIntegrationTest(name, uniqueName);
            uniqueName.add(name);
        }
        validateCarsCount(uniqueName);
    }

    private static void nameIntegrationTest(String name, HashSet<String> uniqueName) {
        validateNameIsEmpty(name);
        validateNameLength(name);
        validateNameUnique(name, uniqueName);
        validateNameRules(name);
    }

    private static void validateNameIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.VALIDATE_NAME_BLANK.getMessage());
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > STRICT_LENGTH) {
            throw new IllegalArgumentException(name + ErrorCode.VALIDATE_NAME_LENGTH.getMessage());
        }
    }

    private static void validateNameUnique(String name, HashSet<String> uniqueName) {
        if (uniqueName.contains(name)) {
            throw new IllegalArgumentException(name + ErrorCode.VALIDATE_DUPLICATION.getMessage());
        }
    }

    private static void validateNameRules(String name) {
        if (!pattern.matcher(name).matches()) {
            throw new IllegalArgumentException(name + ErrorCode.VALIDATE_NOT_ALLOWED_CHAR.getMessage());
        }
    }

    private static void validateCarsCount(HashSet<String> uniqueCars) {
        if (uniqueCars.size() < minCar) {
            throw new IllegalArgumentException((ErrorCode.VALIDATE_CARS_MIN_COUNT.getMessage()));
        }
        if (uniqueCars.size() > maxCar) {
            throw new IllegalArgumentException((ErrorCode.VALIDATE_CARS_MAX_COUNT.getMessage()));
        }
    }

    public static void validateTryCount(String count) {
        tryCountIntegrationTest(count);
    }

    private static void tryCountIntegrationTest(String count) {
        validateTryEmpty(count);
        BigInteger intCount;
        intCount = validateTryBigInteger(count);
        validateTryUnderZero(intCount);
        validateTryMax(intCount);
    }

    private static void validateTryEmpty(String count) {
        if (count.isEmpty() || count.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.VALIDATE_TRY_EMPTY.getMessage());
        }
    }

    private static BigInteger validateTryBigInteger(String count) {
        try {
            return new BigInteger(count);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorCode.VALIDATE_TRY_NOT_INTEGER.getMessage());
        }
    }

    private static void validateTryUnderZero(BigInteger intCount) {
        if (intCount.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException(ErrorCode.VALIDATE_TRY_NOT_ZERO_AND_NEGATIVE.getMessage());
        }
    }

    private static void validateTryMax(BigInteger intCount) {
        if (intCount.compareTo(MAX_TRYCOUNT) > 0) {
            throw new IllegalArgumentException(ErrorCode.VALIDATE_TRY_ALLOWED_ARRANGE.getMessage());
        }
    }
}
