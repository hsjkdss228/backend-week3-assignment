import java.util.Scanner;

public class AsciiDiamond {
    public static void main(String[] args) {
        //준비
        Scanner scanner = new Scanner(System.in);


        //최초 출력
        final String TRY_MESSAGE = "마름모의 크기를 입력해 주세요. (2 이상 20 미만의 홀수): ";
        final String RETRY_MESSAGE = "\n다시 입력해 주세요. (2 이상 20 미만의 홀수): ";

        boolean isValidInput = true;

        System.out.println(TRY_MESSAGE);


        //메인 루프
        do {
            //입력
            int diagonalLength = scanner.nextInt();

            if (diagonalLength < 2 || diagonalLength >= 20 || diagonalLength % 2 == 0) {
                isValidInput = false;

                System.out.println(RETRY_MESSAGE);

                continue;
            }

            if (diagonalLength >= 2 && diagonalLength < 20 && diagonalLength % 2 == 1) {
                isValidInput = true;
            }


            //처리
            final String BLANK = " ";
            final String ASCII_STAR = "*";

            int diagonalLengthToCenter = (int)Math.ceil((double)diagonalLength / 2);

            String[] diamondShapeFromTopToBottom = new String[diagonalLength];

            for (int i = 0; i < diagonalLengthToCenter; i += 1) {
                diamondShapeFromTopToBottom[i] = "";

                int numberOfStarsToDraw = (i * 2) + 1;
                int numberOfBlanksToDraw = (diagonalLength - numberOfStarsToDraw) / 2;

                for (int j = 0; j < numberOfBlanksToDraw; j += 1) {
                    diamondShapeFromTopToBottom[i] += BLANK;
                }

                for (int j = 0; j < numberOfStarsToDraw; j += 1) {
                    diamondShapeFromTopToBottom[i] += ASCII_STAR;
                }

                diamondShapeFromTopToBottom[diagonalLength - (i + 1)] = diamondShapeFromTopToBottom[i];
            }


            //출력
            for (int i = 0; i < diagonalLength; i += 1) {
                System.out.println(diamondShapeFromTopToBottom[i]);
            }

        } while (!isValidInput);

    }
}
