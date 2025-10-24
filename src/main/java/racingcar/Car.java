package racingcar;

public class Car {
    private String carName;
    public int moveStatus;

    public Car(String name) {
        this.carName = name;
        this.moveStatus = 0;
    }

    public void moveCar() {
        moveStatus++;
    }
    public int getMoveStatus() {
        return moveStatus;
    }

}
