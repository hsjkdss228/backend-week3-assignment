//요구사항: 숫자야구 게임을 작성한다.
//- 준비: 3개의 서로 다른 임의의 숫자 준비
//- 메인 루프
//  - 입력: 사용자로부터 3개의 숫자를 입력받음
//  - 처리: 사용자가 입력한 3개의 숫자에 대해 각각 Strike인지, Ball인지, 아무것도 아닌지 판단
//         Strike 기준: 사용자가 입력한 특정 자리수 위치의 숫자가 정답과 자리수도 같고 숫자도 같을 때
//         Ball 기준: 사용자가 입력한 특정 자리수 위치의 숫자가 정답과 자리수는 다르지만 숫자가 같은 게 있을 때
//         Strike도 Ball도 아니면 아무것도 아님
//  - 출력: Strike, Ball의 개수를 출력
//         Strike, Ball 둘 중 한 종류만 카운트되었을 경우 해당되는 것만 출력
//         Strike, Ball 둘 다 카운트되지 않았으면 No count라고 출력
//  - 종료 조건 검사: 3 Strike일 경우 메인 루프 종료 및 프로그램 종료
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
        final int MIXING_COUNT = 20;

        int[] numbersArray = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] answers = new int[NUMBER_OF_NUMBERS_USED_IN_GAME];
        int[] userInputs = new int[NUMBER_OF_NUMBERS_USED_IN_GAME];

        for (int i = 0; i < MIXING_COUNT; i++) {
            int randomIndex1 = random.nextInt(9);
            int randomIndex2 = random.nextInt(9);

            while (randomIndex1 == randomIndex2) {
                randomIndex2 = random.nextInt(9);
            }

            int temporaryVariable = numbersArray[randomIndex1];
            numbersArray[randomIndex1] = numbersArray[randomIndex2];
            numbersArray[randomIndex2] = temporaryVariable;
        }

        for (int i = 0; i < NUMBER_OF_NUMBERS_USED_IN_GAME; i += 1) {
            answers[i] = numbersArray[i];
        }

        //메인 루프
        while (true) {
            //입력
            System.out.print("Guess numbers: ");

            for (int i = 0; i < NUMBER_OF_NUMBERS_USED_IN_GAME; i += 1) {
                userInputs[i] = scanner.nextInt();
            }

            //처리
            int strikeCount = 0;
            int ballCount = 0;

            for (int i = 0; i < NUMBER_OF_NUMBERS_USED_IN_GAME; i += 1) {
                if (userInputs[i] == answers[i]) {
                    strikeCount += 1;
                    continue;
                }

                for (int j = 0; j < NUMBER_OF_NUMBERS_USED_IN_GAME; j += 1) {
                    if (i == j) {
                        continue;
                    }

                    if (userInputs[i] == answers[j]) {
                        ballCount += 1;
                        break;
                    }
                }
            }

            //출력
            if (strikeCount > 0 && ballCount > 0) {
                System.out.println(strikeCount + " Strike, " + ballCount + " Ball");
            }

            if (strikeCount > 0 && ballCount == 0) {
                System.out.println(strikeCount + " Strike");
            }

            if (strikeCount == 0 && ballCount > 0) {
                System.out.println(ballCount + " Ball");
            }

            if (strikeCount == 0 && ballCount == 0) {
                System.out.println("No count...");
            }

            //종료 조건 검사
            if (strikeCount >= 3) {
                break;
            }
        }

        System.out.println("You win!!");
    }
}
