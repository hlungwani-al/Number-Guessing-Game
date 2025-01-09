import java.util.Scanner;

class RandomNumberGenerator {
    int Number = (int) (Math.random() * 100);

    void numberGusser() {
        Scanner userInput = new Scanner(System.in);
        byte attempts = 5;
        boolean gameStatus = true;
        while (gameStatus && attempts >= 0) {
            System.out.println("You have: " + attempts + " attempt(s). \nGuess a number from 0 to 100: ");
            byte userGuess = userInput.nextByte();

            if (userGuess == Number) {
                System.out.println("Congrats you guessed right.\n");
                gameStatus = false;
            } else {
                if (userGuess > Number) {
                    System.out.println("\nooops, wrong guess. try going lower\n");
                } else {
                    System.out.println("\nooops, wrong guess. try going higher\n");
                }
                attempts--;
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
