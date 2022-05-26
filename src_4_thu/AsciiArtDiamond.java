//  *
// ***
//*****
// ***
//  *

import java.util.Scanner;

public class AsciiArtDiamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("마름모의 크기를 입력해 주세요. (2 이상 20 미만의 홀수) ");

        int diagonalLength = scanner.nextInt();

        while (diagonalLength < 2 || diagonalLength >= 20 || diagonalLength % 2 == 0) {
            System.out.print("\n다시 입력해 주세요. (2 이상 20 미만의 홀수) ");

            diagonalLength = scanner.nextInt();
        }

        int halfDiagonalLength = (diagonalLength / 2) + 1;

        String[] overTriangleShapeStrings = new String[halfDiagonalLength];
        String[] underTriangleShapeStrings = new String[halfDiagonalLength - 1];

        for (int i = 0; i < halfDiagonalLength; i += 1) {
            int blankCount = halfDiagonalLength - (i + 1);
            int starCount = (i * 2) + 1;

            overTriangleShapeStrings[i] = "";

            for (int j = 0; j < blankCount; j += 1) {
                overTriangleShapeStrings[i] += " ";
            }

            for (int j = 0; j < starCount; j += 1) {
                overTriangleShapeStrings[i] += "*";
            }

            System.out.println(overTriangleShapeStrings[i]);

            if (i < halfDiagonalLength - 1) {
                underTriangleShapeStrings[(halfDiagonalLength - 1) - (i + 1)] = overTriangleShapeStrings[i];
            }
        }

        for (String print : underTriangleShapeStrings) {
            System.out.println(print);
        }
    }
}
