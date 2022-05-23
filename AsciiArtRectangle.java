import java.util.Scanner;

public class AsciiArtRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String TRY_MESSAGE = "한 변의 길이를 입력해 주세요. (2 이상 20 미만) ";
        final String RETRY_MESSAGE = "다시 입력해 주세요. (2 이상 20 미만) ";

        boolean isValidInput;

        System.out.println(TRY_MESSAGE);

        do {
            int sideLength = scanner.nextInt();

            isValidInput = (sideLength >= 2 && sideLength < 20);

            if (!isValidInput) {
                System.out.println("\n" + RETRY_MESSAGE);

                continue;
            }

            final char ASCII_STAR = '*';

            for (int height = 0; height < sideLength; height++) {
                for (int width = 0; width < sideLength; width++) {
                    System.out.print(ASCII_STAR);
                }

                System.out.println();
            }

        } while (!isValidInput);

    }
}
