import java.util.Scanner;

public class AsciiArtDiamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String TRY_MESSAGE = "마름모의 크기를 입력해 주세요. (2 이상 20 미만의 홀수) ";
        final String RETRY_MESSAGE = "\n다시 입력해주세요. (2 이상 20 미만의 홀수) ";

        boolean isValidInput;

        System.out.println(TRY_MESSAGE);

        do {
            int diagonalLength = scanner.nextInt();

            isValidInput = (diagonalLength >= 2 && diagonalLength < 20 && diagonalLength % 2 == 1);

            if (!isValidInput) {
                System.out.println(RETRY_MESSAGE);

                continue;
            }


            final String ASCII_STAR = "*";
            final String BLANK = " ";
            String[] drawingFromTopToBottom = new String[diagonalLength];

            int diagonalHalfLength = (int)(Math.floor(diagonalLength / (double)2));

            for (int i = 0; i < diagonalHalfLength + 1; i++) {
                drawingFromTopToBottom[i] = "";

                int starDrawingCount = ((i + 1) * 2) - 1;
                int blankCount = (diagonalLength - starDrawingCount) / 2;

                for (int j = 0; j < blankCount; j++) {
                    drawingFromTopToBottom[i] += BLANK;
                }
                for (int j = 0; j < starDrawingCount; j++) {
                    drawingFromTopToBottom[i] += ASCII_STAR;
                }
                for (int j = 0; j < blankCount; j++) {
                    drawingFromTopToBottom[i] += BLANK;
                }

                drawingFromTopToBottom[diagonalLength - (i + 1)] = drawingFromTopToBottom[i];
            }


            for (int i = 0; i < diagonalLength; i++) {
                System.out.println(drawingFromTopToBottom[i]);
            }

        } while (!isValidInput);

    }
}
