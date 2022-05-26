import java.util.Scanner;

public class AsciiArtTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("삼각형의 높이를 입력해 주세요. (2 이상 20 미만) ");

        int height = scanner.nextInt();

        while (height < 2 || height >= 20) {
            System.out.print("\n다시 입력해 주세요. (2 이상 20 미만)");

            height = scanner.nextInt();
        }

        for (int i = 0; i < height; i += 1) {
            int blankCount = height - (i + 1);
            int starCount = (i * 2) + 1;

            for (int j = 0; j < blankCount; j += 1) {
                System.out.print(" ");
            }

            for (int j = 0; j < starCount; j += 1) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
