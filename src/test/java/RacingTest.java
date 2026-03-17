import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

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

        assertThat(winners).containsExactly(pobi, crong);
    }
}
