//요구사항: 별 문자("*")를 이용해 입력받은 값에 맞는 길이의 정사각형을 출력한다.
//입력받은 값이 5라고 할 때의 출력 과정
//- 반복문을 이용해 별 문자 하나("*")를 5번 출력한 뒤 한 줄을 개행한다. (*****\n)
//- 이를 반복문을 이용해큼 입력받은 5번만큼 반복한다.

import java.util.Scanner;

public class AsciiRectangle {
    public static void main(String[] args) {
        //준비
        Scanner scanner = new Scanner(System.in);

        //입력
        System.out.print("한 변의 길이를 입력해 주세요. (2 이상 20 미만): ");

        double sideLength = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            sideLength = scanner.nextDouble();

            isValidInput = (sideLength >= 2 && sideLength < 20 && sideLength - Math.floor(sideLength) == 0);

            if (!isValidInput) {
                System.out.print("\n다시 입력해 주세요. (2 이상 20 미만): ");
            }
        }

        //처리 및 출력
        for (int i = 0; i < (int)sideLength; i += 1) {
            for (int j = 0; j < (int)sideLength; j += 1) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
