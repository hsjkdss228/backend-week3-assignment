//요구사항: 별 문자("*")를 이용해 입력받은 값의 높이에 맞는 삼각형을 출력한다.
//5를 입력했을 때 출력되는 삼각형의 예시를 각 문자열이 어떻게 구성되는지에 대한 측면에서 바라보면
//    *         왼쪽 공백(" ") 4개, 별("*") 1개
//   ***        왼쪽 공백(" ") 3개, 별("*") 3개
//  *****       왼쪽 공백(" ") 2개, 별("*") 5개
// *******      왼쪽 공백(" ") 1개, 별("*") 7개
//*********     왼쪽 공백(" ") 0개, 별("*") 9개
//n번째 문자열을 구성하는 왼쪽 공백 개수는 5 - n, 별 개수는 (n * 2) - 1개이므로
//반복문을 이용해 왼쪽 공백과 별의 개수를 공식에 맞는 수만큼 하나의 문자열에 출력한 뒤 개행한다.
//이를 반복문을 이용해 입력받은 삼각형의 높이인 5번만큼 반복한다.

import java.util.Scanner;

public class AsciiTriangle {
    public static void main(String[] args) {
        //준비
        Scanner scanner = new Scanner(System.in);

        //입력
        System.out.print("삼각형의 높이를 입력해 주세요. (2 이상 20 미만): ");

        double height = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            height = scanner.nextDouble();

            isValidInput = (height >= 2 && height < 20 && height - Math.floor(height) == 0);

            if (!isValidInput) {
                System.out.print("\n다시 입력해 주세요. (2 이상 20 미만): ");
            }
        }

        //처리 및 출력
        for (int i = 0; i < height; i += 1) {
            int blankCount = (int)height - (i + 1);
            int starCount = ((i + 1) * 2) - 1;

            for (int j = 0; j < blankCount; j += 1) {
                System.out.print(" ");
            }
            for (int j = 0; j < starCount; j+= 1) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
