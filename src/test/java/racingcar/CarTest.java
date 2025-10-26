package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {

    @Test
    void 차_이동호출_시_값이_증가하는지_테스트() {
        Car car = new Car("pobi");
        car.moveCar();
        assertThat(car.getMoveStatus()).isEqualTo(1);
    }

    @Test
    void 이동상태_대시_표현_테스트() {
        Car car = new Car("nuri");
        car.moveCar();
        car.moveCar();
        assertThat(car.getDashMove()).isEqualTo("--");
    }

    @Test
    void 차_이름_리턴_텐스트() {
        Car car = new Car("로켓보이");
        assertThat(car.getCarName()).isEqualTo("로켓보이");
    }
}
