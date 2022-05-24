public class GuguClass {
    public static void main(String[] args) {

        final int START_GUGU_TABLE = 2;
        final int END_GUGU_TABLE = 9;
        final int PRINT_NUMBER_OF_GUGU_RESULTS_EACH_LINE = 3;
        final int START_MULTIPLICAND_EACH_GUGU_TABLE = 1;
        final int END_MULTIPLICAND_EACH_GUGU_TABLE = 9;
        final int VARIANCE = 1;

        for (int i = START_GUGU_TABLE; i <= END_GUGU_TABLE; i += PRINT_NUMBER_OF_GUGU_RESULTS_EACH_LINE) {
            for (int j = START_MULTIPLICAND_EACH_GUGU_TABLE; j <= END_MULTIPLICAND_EACH_GUGU_TABLE; j += VARIANCE) {
                String guguResultsLine = "";

                for (int k = 0; k <= (PRINT_NUMBER_OF_GUGU_RESULTS_EACH_LINE - 1); k += VARIANCE) {
                    if (i + k > 9) {
                        break;
                    }

                    guguResultsLine += (i + k) + " * " + j + " = " + ((i + k) * j);

                    if (k < (PRINT_NUMBER_OF_GUGU_RESULTS_EACH_LINE - 1)) {
                        guguResultsLine += "\t";
                    }
                }

                System.out.println(guguResultsLine);
            }

            if (END_MULTIPLICAND_EACH_GUGU_TABLE > PRINT_NUMBER_OF_GUGU_RESULTS_EACH_LINE + i) {
                System.out.println();
            }
        }
    }
}
