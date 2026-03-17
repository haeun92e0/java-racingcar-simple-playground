import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 무작위_값이_4_이상이면_전진한다(){
        Car car = new Car("pobi");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 무작위_값이_3_이하이면_멈춘다(){
        Car car = new Car("rabbit");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

}