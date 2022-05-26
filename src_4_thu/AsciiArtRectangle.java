import java.util.Scanner;

public class AsciiArtRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("한 변의 길이를 입력해 주세요. (2 이상 20 미만) ");

        int sideLength = scanner.nextInt();

        while (sideLength < 2 || sideLength >= 20) {
            System.out.print("\n다시 입력해 주세요. (2 이상 20 미만) ");

            sideLength = scanner.nextInt();
        }

        for (int i = 0; i < sideLength; i += 1) {
            for (int j = 0; j < sideLength; j += 1) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
