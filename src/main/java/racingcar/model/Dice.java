package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {

    private final int threadhold = 4;
    private final int minNum = 0;
    private final int maxNum = 9;

    private int roll() {
        return Randoms.pickNumberInRange(minNum, maxNum);
    }

    public boolean isMoveable() {
        return roll() >= threadhold;
    }
}
