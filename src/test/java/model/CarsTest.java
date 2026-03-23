package model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void 우승자가_1명일_때_단독_우승자를_정상적으로_반환한다() {
        Cars cars = new Cars(Arrays.asList("pobi", "crong", "honux"));

        // 1번째 호출(pobi) -> 9 반환 (전진)
        // 2번째 호출(crong) -> 2 반환 (정지)
        // 3번째 호출(honux) -> 2 반환 (정지)
        NumberGenerator customGenerator = new NumberGenerator() {
            int[] values = {9, 2, 2};
            int index = 0;

            @Override
            public int generate() {
                return values[index++];
            }
        };

        // when: 가짜 기계를 넣어서 1턴 진행
        cars.moveAll(customGenerator);
        List<Car> winners = cars.findWinners();

        // then: 혼자 9를 받고 전진한 pobi만 우승해야 함
        assertThat(winners).extracting(Car::getName)
                .containsExactly("pobi");
    }

    @Test
    void 전원_이동_실패_시_전원을_공동_우승자로_정상_반환한다() {
        Cars cars = new Cars(Arrays.asList("pobi", "crong", "honux"));

        // 가짜 기계: 누가 부르든 무조건 2(정지)만 줌
        NumberGenerator failGenerator = () -> 2;

        // when: 가짜 기계를 넣어서 1턴 진행
        cars.moveAll(failGenerator);
        List<Car> winners = cars.findWinners();

        // then: 아무도 전진하지 못했으므로 3명 모두 공동 우승
        assertThat(winners).extracting(Car::getName)
                .containsExactlyInAnyOrder("pobi", "crong", "honux");
    }
}