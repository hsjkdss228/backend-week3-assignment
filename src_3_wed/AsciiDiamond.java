//요구사: 별 문자("*")를 이용해 입력받은 값의 대각선 길이에 맞는 마름모를 출력한다.
//7를 입력했을 때 출력되는 삼각형의 예시를 각 문자열이 어떻게 구성되는지에 대한 측면에서 바라보면
//   *          왼쪽 공백(" ") 3개, 별("*") 1개
//  ***         왼쪽 공백(" ") 2개, 별("*") 3개
// *****        왼쪽 공백(" ") 1개, 별("*") 5개
//*******       왼쪽 공백(" ") 0개, 별("*") 7개
// *****        왼쪽 공백(" ") 1개, 별("*") 5개
//  ***         왼쪽 공백(" ") 2개, 별("*") 3개
//   *          왼쪽 공백(" ") 3개, 별("*") 1개
//정중앙의 대각선 길이인 7개만큼의 별이 출력되는 문자열의 줄을 기점으로
//이전 문자열과 이후 문자열이 대칭되고 있다는 점을 확인할 수 있다.
//
//따라서 먼저 정중앙 문자열까지 문자열을 형성시킨 뒤에
//정중앙 이후의 문자열에는 위치상 대칭되는 이전 문자열과 똑같은 문자열 값을 할당해 주는 과정을 수행한다.
//이로 인해 이번 문제에서는 처리 과정과 출력 과정이 구분되도록 한다. (Rectangle, Triangle처럼 값을 할당과 동시에 출력하는 것이 구조상 불가능함)
//
//정중앙까지의 n번째 문자열을 구성하는 왼쪽 공백 개수는 floor(7 / 2) - n, 별 개수는 (n * 2) - 1개이므로
//반복문을 이용해 정중앙까지 왼쪽 공백과 별의 개수를 공식에 맞는 수만큼 하나의 문자열에 출력한 뒤 개행하는데
//하나의 문자열을 생성했으면 해당 문자열을 7 - (n - 1)번째 문자열에 할당해준다. 이는 정중앙 문자열에 대해서는 수행시키지 않는다.
//이를 반복문을 이용해 정중앙까지의 길이만큼 반복한다.
//모든 문자열 구성을 마쳤으면 반복문을 이용해 첫 번째 문자열부터 순서대로 출력한다.

import java.util.Scanner;

public class AsciiDiamond {
    public static void main(String[] args) {
        //준비
        Scanner scanner = new Scanner(System.in);

        //입력
        System.out.print("마름모의 크기를 입력해 주세요. (2 이상 20 미만의 홀수): ");

        double diagonalLength = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            diagonalLength = scanner.nextDouble();

            isValidInput = (diagonalLength >= 2 && diagonalLength < 20 && diagonalLength % 2 == 1
                    && diagonalLength - Math.floor(diagonalLength) == 0);

            if (!isValidInput) {
                System.out.print("\n다시 입력해 주세요. (2 이상 20 미만의 홀수): ");
            }
        }

        //처리
        String[] diamondShapeString = new String[(int)diagonalLength];               //From top to bottom
        int diagonalLengthToCenter = (int)Math.ceil(diagonalLength / 2);

        for (int i = 0; i < diagonalLengthToCenter; i += 1) {
            diamondShapeString[i] = "";

            int blankCount = diagonalLengthToCenter - (i + 1);
            int starCount = ((i + 1) * 2) - 1;

            for (int j = 0; j < blankCount; j += 1) {
                diamondShapeString[i] += " ";
            }
            for (int j = 0; j < starCount; j += 1) {
                diamondShapeString[i] += "*";
            }

            if (i != diagonalLengthToCenter - 1) {
                diamondShapeString[(int)diagonalLength - (i + 1)] = diamondShapeString[i];
            }
        }

        //출력
        for (int i = 0; i < diagonalLength; i += 1) {
            System.out.println(diamondShapeString[i]);
        }
    }
}
