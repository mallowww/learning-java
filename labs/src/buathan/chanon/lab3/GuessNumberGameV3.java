/**
 GuessNumberGameV3 the improve program from the GuessNumberGameV2
 The program will generate number between the range that "user input for ( minimum, maximum ) numbers and remain guess"
 If user input number invalid by out of range numbers, the program will respond in text "The guess number must be in the range ..." .
 The program can let's user play again by type "y" to run the guessing with reset remain guess.
 */

/*
 * Author: Chanon Buathan
 * ID: 623040421-0
 * Sec: 1
 * Date: January 13, 2020
 */
package buathan.chanon.lab3;

import java.util.Scanner;

public class GuessNumberGameV3 {
    static int correctNum;
    static int minNum = 1;
    static int maxNum = 10;
    static int remainTry = 3;
    static int newRemainTry; // For using reset remainTry while loop via input "y" to play again.
    static Scanner userScanner = new Scanner(System.in);

    public static void main(String[] args) {

        /**
         // tl;dr idea >>>> first| config range for user >> Enter the min and the max value:(minNum) (maxNum)
         // config tries >> Enter the number of tries:(remainTry)
         // if user put nums outside range >> The guess number must be in the range (minNum) and (maxNum)
         // if remaining try alr out, ask >> If want to play again? type 'y' to continue or 'q' to quit:(newInstance check input from keyboard)
         */

        // Running class configGame() and after received all "static int variable" exit the configGame().
        while (true) {
            if ( configGame() )
                break;
        }

        // Running almost whole program method: genAnswer(), playGames(), ask user to play again or exit the program.
        while (true) {
            genAnswer();
            playGames();

            // If user type other String(I'm not using char) except y(only lowercase) the program will exit the loop.
            // ( || userInput.equals("Y")
            System.out.print("If want to play again? type 'y' to continue or 'q' to quit:");
            String userInput = userScanner.nextLine();
            if ( !userInput.equals("y") )  {
                break;
            }
        }
        userScanner.close();
    }

    // Receive boolean return from comparable max, min numbers which always true,
    // used boolean for input while (true) condition in configGame().
    public static boolean configGame() {
        System.out.print("Enter the min and the max value:");
        Scanner inputRangeNumber = new Scanner(System.in);

        // Create variable which return "static int minNum = 1, maxNum = 10, remainTry = 3";
        int firstConfigNum, secondConfigNum, tryConfigNum;
        firstConfigNum = inputRangeNumber.nextInt();
        secondConfigNum = inputRangeNumber.nextInt();

        System.out.print("Enter the number of tries:");
        Scanner inputTryNumber = new Scanner(System.in);
        tryConfigNum = inputTryNumber.nextInt();
        remainTry = tryConfigNum;

        // Compare "number from configs" that which one is higher and another is lower, return int to variable
        // minNum, maxNum and boolean true to configGame().
        if (firstConfigNum > secondConfigNum) {
            maxNum = firstConfigNum;
            minNum = secondConfigNum;
            return true;

        } else if (firstConfigNum < secondConfigNum) {
            minNum = firstConfigNum;
            maxNum = secondConfigNum;
            return true;

        }
            return true;
        }

        public static void genAnswer () {
            correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        }

        public static void playGames () {
            // New instance used to counting remain try which is reset starting the same from user input("y").
            newRemainTry = remainTry;
            Scanner inputNum = new Scanner(System.in);

            while (newRemainTry > 0) {

                int inputNumGuessing;
                String welcomeGuessText = "Please enter a guess ("+minNum+"-"+maxNum+"):";
                System.out.print(welcomeGuessText);
                inputNumGuessing = inputNum.nextInt();
                inputNum.hasNextLine();

                // Not counting loop which invalid, if user guessed.
                // Condition inputNum showing not "out of range" which compare user configs.
                if ( (inputNumGuessing > maxNum) || (inputNumGuessing < minNum) ) {
                    System.out.println("The guess number must be in the range " + minNum + " and " + maxNum);
                    continue;
                }

                // Counter loop which user guess,
                // decreasing remain try numbers every times, after user input guess number.
                newRemainTry--;
                if (inputNumGuessing == correctNum) {
                    System.out.println("Congratulations! That's correct");
                    break;
                } else if ( (inputNumGuessing > correctNum) && (inputNumGuessing <= maxNum || inputNumGuessing >= minNum) ) {
                    System.out.print("Please type a lower number! Number of remaining tries:" + newRemainTry);
                    System.out.println("");
                    continue;
                } else if ( (inputNumGuessing < correctNum) && (inputNumGuessing <= maxNum || inputNumGuessing >= minNum)) {
                    System.out.print("Please type a higher number! Number of remaining tries:" + newRemainTry);
                    System.out.println("");
                    continue;

                }
            }
        }
}

