import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getWinners(){
        int maxPosition = getMaxPosition();
        return findCarsAt(maxPosition);
    }

    private int getMaxPosition(){
        int max=0;
        for (Car car : cars){
            max = updateMax(max, car.getPosition());
        }
        return max;
    }

    private int updateMax(int currentMax, int carPosition){
        if (carPosition > currentMax){
            return carPosition;
        }
        return currentMax;
    }

    private List<Car> findCarsAt(int maxPosition){
        List<Car> winners = new ArrayList<>();
        for(Car car : cars){
            addIfWinner(winners, car, maxPosition);
        }
        return winners;
    }

    private void addIfWinner(List<Car> winners, Car car, int maxPosition){
        if (car.isAtPosition(maxPosition)){
            winners.add(car);
        }
    }
}
