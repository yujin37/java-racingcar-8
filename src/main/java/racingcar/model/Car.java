package racingcar.model;

public class Car {
    private static final String MOVE_DASH = "-";
    private static final int INIT_STAUS = 0;

    private String carName;
    private int moveStatus;

    public Car(String name) {
        this.carName = name;
        this.moveStatus = INIT_STAUS;
    }

    public void moveCar() {
        moveStatus++;
    }

    public int getMoveStatus() {
        return moveStatus;
    }

    public String getDashMove() {
        return (String) (MOVE_DASH.repeat(getMoveStatus()));
    }

    public String getCarName() {
        return carName;
    }

}
