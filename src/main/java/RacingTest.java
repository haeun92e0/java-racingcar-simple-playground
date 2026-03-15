import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    @Test
    void 자동차가_4이상일때_전진하고_3이하일때_멈추는지_테스트(){
        Car car = new Car("Pobi");

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 우승자가_한명_또는_여러명일떄_제대로_구해지는지_테스트(){
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car rabbit = new Car("rabbit");

        pobi.move(4);
        crong.move(5);
        rabbit.move(2);

        RacingGame game = new RacingGame(Arrays.asList(pobi, crong, rabbit));
        List<Car> winners = game.getWinners();

        assertThat(winners).containsExactly(pobi, crong);
    }
}
