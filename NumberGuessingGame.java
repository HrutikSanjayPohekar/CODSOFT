import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lower = 1;
        int upper = 100;
        int maxAttempts = 7;
        int score = 0;
        int round = 1;

        System.out.println("🎮 Welcome to the Number Guessing Game");

        boolean playAgain = true;
        while (playAgain) {
            int secretNumber = random.nextInt(upper - lower + 1) + lower;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n🔁 Round " + round + " has started");
            System.out.println("Guess the number between " + lower + " and " + upper);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess;

                // Check for valid integer input
                if (scanner.hasNextInt()) {
                    guess = scanner.nextInt();
                    attempts++;

                    if (guess == secretNumber) {
                        System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
                        score++;
                        guessedCorrectly = true;
                        break;
                    } else if (guess < secretNumber) {
                        System.out.println("📉 Too low");
                    } else {
                        System.out.println("📈 Too high");
                    }
                } else {
                    System.out.println("⚠️ Invalid input. Please enter a number.");
                    scanner.next(); // discard invalid input
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts. The number was: " + secretNumber);
            }

            System.out.println("✅ Your current score: " + score);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            } else {
                round++;
            }
        }

        System.out.println("\n🏁 Game Over! Final score: " + score + " point(s) in " + round + " round(s).");
        System.out.println("Thanks for playing");
        scanner.close();
    }
}
