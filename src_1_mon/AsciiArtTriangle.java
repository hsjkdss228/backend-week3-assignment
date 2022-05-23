import java.util.Scanner;

public class AsciiArtTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String TRY_MESSAGE = "삼각형의 높이를 입력해 주세요. (2 이상 20 미만)";
        final String RETRY_MESSAGE = "\n다시 입력해 주세요. (2 이상 20 미만)";

        boolean isValidInput;

        System.out.println(TRY_MESSAGE);

        do {
            int height = scanner.nextInt();

            isValidInput = (height >= 2 && height < 20);

            if (!isValidInput) {
                System.out.println(RETRY_MESSAGE);

                continue;
            }


            final String ASCII_STAR = "*";
            final String BLANK = " ";
            final int BASE_LINE_LENGTH = (height * 2) - 1;
            String[] drawingFromTopToBottom = new String[height];

            for (int i = 0; i < height; i++) {
                drawingFromTopToBottom[i] = "";
            }

            for (int i = 1; i <= height; i++) {
                int drawingPosition = i - 1;
                int starDrawingCount = (i * 2) - 1;
                int blankCount = (BASE_LINE_LENGTH - starDrawingCount) / 2;

                for (int j = 0; j < blankCount; j++) {
                    drawingFromTopToBottom[drawingPosition] += BLANK;
                }
                for (int j = 0; j < starDrawingCount; j++) {
                    drawingFromTopToBottom[drawingPosition] += ASCII_STAR;
                }
                for (int j = 0; j < blankCount; j++) {
                    drawingFromTopToBottom[drawingPosition] += BLANK;
                }
            }


            for (int i = 0; i < height; i++) {
                System.out.println(drawingFromTopToBottom[i]);
            }

        } while (!isValidInput);

    }
}
