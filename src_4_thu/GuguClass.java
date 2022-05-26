public class GuguClass {
    public static void main(String[] args) {
        String[][] gugudanStrings = new String[8][9];

        for (int i = 2; i <= 9; i += 1) {
            for (int j = 1; j <= 9; j += 1) {
                gugudanStrings[i - 2][j - 1] = i + " * " + j + " = " + (i * j);
            }
        }

        final int GROUP_OF_STAGES = 3;

        int rangeOfStages = 8;
        int groupIndex = 0;
        int stageIndex = 0;
        int multiplicandIndex = 0;
        int stageNow = 0;

        while (rangeOfStages > stageNow) {

            while (multiplicandIndex <= 8) {
                stageNow = GROUP_OF_STAGES * groupIndex;

                while (stageIndex < 3) {

                    System.out.print(gugudanStrings[stageNow][multiplicandIndex]);

                    if (stageIndex < GROUP_OF_STAGES - 1) {
                        System.out.print("\t");
                    }

                    if (stageIndex == GROUP_OF_STAGES - 1) {
                        System.out.print("\n");
                    }

                    stageNow += 1;
                    stageIndex += 1;

                    if (stageNow >= rangeOfStages) {
                        System.out.print("\n");
                        break;
                    }
                }

                stageIndex = 0;
                multiplicandIndex += 1;
            }

            if (stageNow < rangeOfStages) {
                System.out.println();
            }

            multiplicandIndex = 0;
            groupIndex += 1;
        }
    }
}
