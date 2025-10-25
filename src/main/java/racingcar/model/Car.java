package racingcar.model;

public class Car {
    private String carName;
    private int moveStatus;

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

    public String getDashMove() {
        return (String) ("-".repeat(getMoveStatus()));
    }

    public String getCarName() {
        return carName;
    }

}
