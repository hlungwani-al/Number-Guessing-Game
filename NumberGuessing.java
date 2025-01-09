import java.util.Scanner;

class RandomNumberGenerator {
    int Number = (int) (Math.random() * 100);

    void numberGusser() {
        Scanner userInput = new Scanner(System.in);
        byte attempts = 5;
        Byte userAttempts[] = { -1, -1, -1, -1, -1 };
        boolean gameStatus = true;
        while (gameStatus && attempts > 0) {
            System.out.println("You have: " + attempts + " attempt(s). \nGuess a number from 0 to 100: ");
            byte userGuess = userInput.nextByte();
            userAttempts[attempts - 1] = userGuess;
            attempts--;
            if (userGuess == Number) {
                System.out.println("Congrats you guessed right.\n");
                gameStatus = false;
            } else {
                if (attempts == 0) {
                    Scanner stringScanner = new Scanner(System.in);
                    System.out.print("You are out of attempts!, your attempts are: ");
                    for (int index = 4; index >= 0; index--) {
                        System.out.print(userAttempts[index] + " ");
                    }
                    System.out.println("\nThe correct number is: " + Number
                            + "\nDo you wish to restart ? (y)es or n(o)");
                    String restartGame = stringScanner.nextLine();
                    restartGame.toLowerCase();
                    stringScanner.close();

                    // System.out.println(restartGame + " is not equal to " +
                    // restartGame.toLowerCase());

                    if (restartGame == "y" || restartGame == "yes") {
                        System.out.println("Game restarting ...\n...\n");
                        numberGusser();
                    } else {
                        System.out.println("Thanks for playing, better luck next time. Good bye");
                    }
                } else {
                    if (userGuess > Number) {
                        System.out.println("\nooops, wrong guess. try going lower\n");
                    } else {
                        System.out.println("\nooops, wrong guess. try going higher\n");
                    }
                }

            }

        }
        userInput.close();
    }
}

public class NumberGuessing {
    public static void main(String[] args) {

        RandomNumberGenerator randomNumberGeneratorObject = new RandomNumberGenerator();
        randomNumberGeneratorObject.numberGusser();

    }
}
