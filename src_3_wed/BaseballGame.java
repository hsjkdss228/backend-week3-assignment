//요구사항: 숫자 야구 게임을 작성한다.
//프로그램 동작 순서
//- 준비: 1~9 사이의 서로 중복되지 않는 임의의 숫자 세 개가 주어진다.
//- 임의의 숫자는 첫 번째 숫자는 일단 무조건 주어지고,
//  두 번째 숫자부터는 이전의 숫자들과 검사해서 같지 않은 숫자일 경우에 주어진다.
//  (2번째 숫자는 1번째 숫자와 비교를, 3번째 숫자는 1, 2번째 숫자와 비교, 즉 n번째 숫자는 1~(n-1)번째 숫자들과 비교함)
//  같은 숫자라면 다시 숫자를 부여하여 이전의 숫자들과 검사하는 과정을 반복한다.
//- 메인 루프
//  - 입력: 사용자로부터 세 개의 숫자를 입력받는다.
//  - 처리: 사용자가 입력한 세 개의 숫자가 각각 Strike인지 Ball인지 판단한다.
//  -      Strike 기준: 숫자와 자리가 모두 일치하는 경우
//  -      Strike는 입력한 자리수와 정답 자리수의 숫자끼리만 비교한다.
//  -      Ball 기준: 숫자는 있지만 자리가 일치하지 않는 경우
//  -      Ball은 입력한 자리수와는 다른 자리수의 정답 숫자끼리만 비교한다.
//  - 출력: Strike와 Ball의 개수를 출력한다. 이때 0S나 0B는 출력하지 않고, 0S이면서 0B인 경우에는 별도의 메세지를 출력한다.
//  - 종료 조건: 3S인 경우
//
//Test Cases: 정답으로 7 4 9가 주어졌을 때
//- 사용자가 6 7 5를 입력하면 1 Ball
//- 사용자가 7 6 5를 입력하면 1 Strike
//- 사용자가 9 7 6을 입력하면 2 Ball
//- 사용자가 5 7 9를 입력하면 1 Strike 1 Ball
//- 사용자가 7 4 3을 입력하면 2 Strike
//- 사용자가 4 9 7을 입력하면 3 Ball
//- 사용자가 7 9 4를 입력하면 1 Strike 2 Ball
//- 사용자가 7 4 9를 입력하면 3 Strike >> 게임 종료

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    public static void main(String[] args) {
        //준비
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int NUMBER_OF_NUMBERS_USED_IN_GAME = 3;
        final char STRIKE = 's';
        final char BALL = 'b';
        final char NO_COUNT = 'n';

        final String TRY_MESSAGE = "Guess numbers: ";
        final String WINNER_MESSAGE = "You win!";

        int[] numbers = new int[NUMBER_OF_NUMBERS_USED_IN_GAME];
        int[] userInput = new int[NUMBER_OF_NUMBERS_USED_IN_GAME];
        int strikeCount;
        int ballCount;

        //임의의 서로 다른 세 개의 숫자 할당
        for (int i = 0; i < NUMBER_OF_NUMBERS_USED_IN_GAME; i += 1) {
            int randomNumber = random.nextInt(9) + 1;
            boolean areSameNumbers = false;

            if (i >= 1) {
                for (int j = 0; j < i; j += 1) {
                    if (numbers[j] == randomNumber) {
                        areSameNumbers = true;

                        break;
                    }
                }
            }

            if (areSameNumbers) {
                i -= 1;

                continue;
            }

            numbers[i] = randomNumber;
        }

        //메인 루프
        while (true) {
            //입력
            System.out.print(TRY_MESSAGE);

            for (int i = 0; i < NUMBER_OF_NUMBERS_USED_IN_GAME; i += 1) {
                userInput[i] = scanner.nextInt();
            }

            //처리
            strikeCount = 0;
            ballCount = 0;
            char[] decisions = new char[NUMBER_OF_NUMBERS_USED_IN_GAME];

            for (int i = 0; i < NUMBER_OF_NUMBERS_USED_IN_GAME; i += 1) {
                boolean isNoCount = true;

                if (userInput[i] == numbers[i]) {
                    decisions[i] = STRIKE;
                    strikeCount += 1;
                    isNoCount = false;
                    continue;
                }

                for (int j = 0; j < NUMBER_OF_NUMBERS_USED_IN_GAME; j += 1) {
                    if (i == j) {
                        continue;
                    }

                    if (userInput[i] == numbers[j]) {
                        decisions[i] = BALL;
                        ballCount += 1;
                        isNoCount = false;
                    }
                }

                if (isNoCount) {
                    decisions[i] = NO_COUNT;
                }
            }

            boolean areRightAnswers = true;

            for (int i = 0; i < NUMBER_OF_NUMBERS_USED_IN_GAME; i += 1) {
                if (decisions[i] != STRIKE) {
                    areRightAnswers = false;
                }
            }

            String decisionMessage = "";

            if (strikeCount > 0) {
                decisionMessage = strikeCount + " Strike";

                if (ballCount > 0) {
                    decisionMessage += ", ";
                }
            }

            if (ballCount > 0) {
                decisionMessage += ballCount + " Ball";
            }

            if (strikeCount == 0 && ballCount == 0) {
                decisionMessage = "No Count";
            }

            //출력 및 종료 조건 검사
            System.out.println(decisionMessage);

            if (areRightAnswers) {
                break;
            }
        }

        System.out.println(WINNER_MESSAGE);
    }
}
