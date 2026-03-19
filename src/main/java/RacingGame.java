import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final List<Car> cars;

    public RacingGame(List<Car> cars){
        this.cars = cars;
    }

    public void race(int tryCount){
        for(int i=0; i< tryCount; i++){
            moveCars();
        }
    }

    private void moveCars(){
        Random random = new Random();
        for (Car car : cars){
            int randomValue = random.nextInt(10);
            car.move(randomValue);
        }
    }

    public List<Car> getWinners(){
        int maxPosition = getMaxPosition();
        return findCarsAt(maxPosition);
    }

    private int getMaxPosition(){
        int max=0;
        for (Car car : cars){
            max = Math.max(max, car.getPosition());
        }
        return max;
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
