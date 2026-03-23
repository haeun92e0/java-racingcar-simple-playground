package Controller;

import Model.RacingGame;
import Model.RandomNumberGenerator;
import View.InputView;
import View.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 1. 입력 받기
        List<String> carNames = InputView.getCarNames();
        int tryCount = InputView.getTryCount();

        // 2. 게임 세팅
        RacingGame racingGame = new RacingGame(carNames, tryCount);
        RandomNumberGenerator randomGenerator = new RandomNumberGenerator();

        // 3. 게임 실행
        ResultView.printRaceStart();
        while (!racingGame.isEnd()) {
            racingGame.raceStep(randomGenerator);
            ResultView.printStepResult(racingGame.getCars());
        }

        // 4. 최종 우승자 출력
        ResultView.printWinners(racingGame.getWinners());
    }
}
