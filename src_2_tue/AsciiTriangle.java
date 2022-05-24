import java.util.Scanner;

public class AsciiTriangle {
    public static void main(String[] args) {
        //준비
        Scanner scanner = new Scanner(System.in);


        //최초 출력
        final String TRY_MESSAGE = "삼각형의 높이를 입력해 주세요. (2 이상 20 미만): ";
        final String RETRY_MESSAGE = "\n다시 입력해 주세요. (2 이상 20 미만): ";

        boolean isValidInput = true;

        System.out.println(TRY_MESSAGE);


        //메인 루프
        do {
            //입력
            int height = scanner.nextInt();

            if (height < 2 || height >= 20) {
                isValidInput = false;

                System.out.println(RETRY_MESSAGE);

                continue;
            }

            if (height >= 2 && height < 20) {
                isValidInput = true;
            }


            //처리
            final String BLANK = " ";
            final String ASCII_STAR = "*";

            int LengthOfBase = (height * 2) - 1;

            String[] triangleShapeFromTopToBottom = new String[height];

            for (int i = 0; i < height; i += 1) {
                int numberOfStarsToDraw = ((i + 1) * 2) - 1;
                int numberOfBlanksToDraw = (LengthOfBase - numberOfStarsToDraw) / 2;

                triangleShapeFromTopToBottom[i] = "";

                for (int j = 0; j < numberOfBlanksToDraw; j += 1) {
                    triangleShapeFromTopToBottom[i] += BLANK;
                }

                for (int j = 0; j < numberOfStarsToDraw; j += 1) {
                    triangleShapeFromTopToBottom[i] += ASCII_STAR;
                }
            }


            //출력
            for (int i = 0; i < height; i += 1) {
                System.out.println(triangleShapeFromTopToBottom[i]);
            }

        } while (!isValidInput);

    }
}
