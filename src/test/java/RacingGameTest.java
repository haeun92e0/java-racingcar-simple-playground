import Model.Car;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 우승자가_여러명일_경우_공동_우승자를_모두_반환한다(){
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car rabbit = new Car("rabbit");

        pobi.move(4);
        crong.move(5);
        rabbit.move(2);

        RacingGame game = new RacingGame(Arrays.asList(pobi, crong, rabbit));
        List<Car> winners = game.getWinners();

        assertThat(winners).containsExactlyInAnyOrder(pobi, crong);
    }

    @Test
    void 우승자가_한명일_경우_단일_우승자를_반환한다(){
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car rabbit = new Car("rabbit");

        pobi.move(5);
        crong.move(1);
        rabbit.move(2);

        RacingGame game = new RacingGame(Arrays.asList(pobi, crong, rabbit));
        List<Car> winners = game.getWinners();

        assertThat(winners).containsExactlyInAnyOrder(pobi);

    }


    @Test
    void 모든_자동차가_이동하지_않은_경우_전원을_공동_우승자로_반환한다(){
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car rabbit = new Car("rabbit");

        pobi.move(1);
        crong.move(2);
        rabbit.move(3);

        RacingGame game = new RacingGame(Arrays.asList(pobi, crong, rabbit));
        List<Car> winners = game.getWinners();

        assertThat(winners).containsExactlyInAnyOrder(pobi, crong, rabbit);
    }
}
