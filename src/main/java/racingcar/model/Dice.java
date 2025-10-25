package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {

    private final int threadhold = 4;

    private int roll() {
        return Randoms.pickNumberInRange(0,9);
    }
    public boolean isMoveable() {
        return roll() >= threadhold;
    }
}
