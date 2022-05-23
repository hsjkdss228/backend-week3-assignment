public class GuguClass {
    public static void main(String[] args) {
        for (int multiplier = 2; multiplier < 10; multiplier += 3) {

            for (int multiplicand = 1; multiplicand < 10; multiplicand += 1) {

                for (int i = multiplier; i <= multiplier + 2; i += 1) {
                    if (i >= 10) {
                        continue;
                    }

                    int product = i * multiplicand;
                    String printMessage = i + " * " + multiplicand + " = " + product;

                    if (i != multiplier + 2) {
                        printMessage += "\t";
                    }

                    System.out.print(printMessage);
                }

                System.out.println();
            }

            if (multiplier < 8) {
                System.out.println();
            }

        }

    }
}
