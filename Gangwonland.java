import java.util.Random;
import java.util.Scanner;

public class Gangwonland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        final String INITIAL_MESSAGE = "Wanna play? 1. Yes, 2. No";
        final String WINNER_MESSAGE = "Winner!!!";
        final String LOSER_MESSAGE = "Need more credit? Go home!!";
        final String END_MESSAGE = "Bye bye ~~";

        final double BATTING_COST = 1000;
        final int NUMBER_OF_SLOTS = 3;
        final double BONUS_RATE = 4;
        final double PENALTY_RATE = 0.5;
        final double WINNING_STANDARD = 10000;
        final double LOSING_STANDARD = 1000;

        double userCredit = 5000;
        boolean canBat = true;


        String userCreditMessage = "Credit: " + userCredit;


        System.out.println(userCreditMessage);


        while (canBat) {
            System.out.println(INITIAL_MESSAGE);

            int userReply = scanner.nextInt();

            if (userReply == 2) {
                break;
            }


            int[] numberOfEachSlots = new int[NUMBER_OF_SLOTS];
            String numberOfEachSlotsMessage = "";
            double[] prizeEachSlots = new double[NUMBER_OF_SLOTS];
            double basicSumOfPrize = 0;
            int bonusCount = 0;
            int penaltyCount = 0;


            userCredit -= BATTING_COST;

            for (int i = 0; i < NUMBER_OF_SLOTS; i++) {
                numberOfEachSlots[i] = random.nextInt(9) + 1;

                prizeEachSlots[i] = BATTING_COST * numberOfEachSlots[i] / 20;
                basicSumOfPrize += prizeEachSlots[i];

                boolean isBonus = (numberOfEachSlots[i] == 7);
                boolean isPenalty = (numberOfEachSlots[i] == 4 || numberOfEachSlots[i] == 8 || numberOfEachSlots[i] == 9);

                if (isBonus) {
                    bonusCount += 1;
                }

                if (isPenalty) {
                    penaltyCount += 1;
                }


                numberOfEachSlotsMessage += numberOfEachSlots[i];

                if (i < NUMBER_OF_SLOTS - 1) {
                    numberOfEachSlotsMessage += " . ";
                }
            }

            double finalSumOfPrize = basicSumOfPrize * Math.pow(BONUS_RATE, bonusCount) * Math.pow(PENALTY_RATE, penaltyCount);

            userCredit += finalSumOfPrize;

            String PrizeMessage = "Got: " + finalSumOfPrize;
            userCreditMessage = "Credit: " + userCredit + "\n";


            System.out.println(numberOfEachSlotsMessage);
            System.out.println(PrizeMessage);
            System.out.println(userCreditMessage);


            boolean isWinner = (userCredit >= WINNING_STANDARD);
            boolean isLoser = (userCredit <= LOSING_STANDARD);

            if (isWinner) {
                System.out.println(WINNER_MESSAGE);

                break;
            }

            if (isLoser) {
                System.out.println(LOSER_MESSAGE);

                canBat = false;
            }
        }

        System.out.println(END_MESSAGE);
    }
}