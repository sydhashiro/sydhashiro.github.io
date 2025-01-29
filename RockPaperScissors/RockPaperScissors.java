import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Rock-Paper-Scissors!");

        while (true) {
            // Get user's choice
            System.out.print("Enter your choice (rock, paper, scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please choose rock, paper, or scissors.");
                continue;
            }

            // Get computer's choice
            String[] choices = {"rock", "paper", "scissors"};
            String computerChoice = choices[random.nextInt(3)];

            System.out.println("You chose: " + userChoice);
            System.out.println("Computer chose: " + computerChoice);

            // Determine winner
            String result;
            if (userChoice.equals(computerChoice)) {
                result = "It's a tie!";
            } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                       (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                       (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
                result = "You win!";
            } else {
                result = "Computer wins!";
            }

            System.out.println(result);

            // Ask to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}
