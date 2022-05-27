public class GuguClass {
    public static void main(String[] args) {
        String[][] gugudanStrings = new String[8][9];

        for (int i = 2; i <= 9; i += 1) {
            for (int j = 1; j <= 9; j += 1) {
                gugudanStrings[i - 2][j - 1] = i + " * " + j + " = " + (i * j);
            }
        }

        final int RANGE_OF_STAGES = 8;
        final int GROUP_OF_STAGES = 3;

        int groupIndex = 0;
        int stageIndex = 0;
        int multiplicandIndex = 0;
        int stageNow = 0;

        while (stageNow < RANGE_OF_STAGES) {

            while (multiplicandIndex <= RANGE_OF_STAGES) {
                stageNow = GROUP_OF_STAGES * groupIndex;

                while (stageIndex < GROUP_OF_STAGES) {

                    System.out.print(gugudanStrings[stageNow][multiplicandIndex]);

                    if (stageIndex < GROUP_OF_STAGES - 1) {
                        System.out.print("\t");
                    }

                    boolean isAligned = false;

                    if (stageIndex == GROUP_OF_STAGES - 1) {
                        System.out.print("\n");
                        isAligned = true;
                    }

                    stageNow += 1;
                    stageIndex += 1;

                    if (!isAligned && stageNow >= RANGE_OF_STAGES) {
                        System.out.print("\n");
                        break;
                    }
                }

                stageIndex = 0;
                multiplicandIndex += 1;
            }

            if (stageNow < RANGE_OF_STAGES) {
                System.out.println();
            }

            multiplicandIndex = 0;
            groupIndex += 1;
        }
    }
}
