import java.util.Scanner;
import java.util.Random;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 5; // Limiting the number of attempts
        int score = 0;
        boolean playAgain = true;
        
        System.out.println("Welcome to the Number Game!");
        
        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            
            System.out.println("\nI've generated a number between " + minRange + " and " + maxRange + ". Can you guess it?");
            
            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score++;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                
                attempts++;
            }
            
            if (attempts == attemptsLimit) {
                System.out.println("\nSorry, you've used all your attempts. The number was: " + generatedNumber);
            }
            
            System.out.println("Your current score: " + score);
            
            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            
            if (!playAgainResponse.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("\nThank you for playing! Your final score is: " + score);
        System.out.println("SEE YOU AGAIN!!!");

        
        scanner.close();
    }
}
