import java.util.Scanner;

public class AsciiRectangle {
    public static void main(String[] args) {
        //준비
        Scanner scanner = new Scanner(System.in);


        //최초 출력
        final String TRY_MESSAGE = "한 변의 길이를 입력해 주세요. (2 이상 20 미만): ";
        final String RETRY_MESSAGE = "\n다시 입력해 주세요. (2 이상 20 미만): ";

        boolean isValidInput = true;

        System.out.println(TRY_MESSAGE);


        //메인 루프
        do {
            //입력
            int sideLength = scanner.nextInt();

            if (sideLength < 2 || sideLength >= 20) {
                isValidInput = false;

                System.out.println(RETRY_MESSAGE);

                continue;
            }

            if (sideLength >= 2 && sideLength < 20) {
                isValidInput = true;
            }


            //처리
            final String ASCII_STAR = "*";

            String[] rectangleShapeFromTopToBottom = new String[sideLength];

            for (int i = 0; i < sideLength; i += 1) {
                rectangleShapeFromTopToBottom[i] = "";

                for (int j = 0; j < sideLength; j += 1) {
                    rectangleShapeFromTopToBottom[i] += ASCII_STAR;
                }
            }


            //출력
            for (int i = 0; i < sideLength; i += 1) {
                System.out.println(rectangleShapeFromTopToBottom[i]);
            }

        } while (!isValidInput);

    }
}
