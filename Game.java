import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Initialize game components
        Player player = new Player("Survivor", 100, 100);
        GameMap map = new GameMap();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to The Walking Dead: Survival Adventure!");
            System.out.println("Your goal is to navigate the post-apocalyptic world and reach the Safe Haven.\n");

            while (player.isAlive() && !map.isAtSafeHaven()) {
                // Display player status and options
                System.out.println("\nCurrent Location: " + map.getCurrentLocation());
                System.out.println("Health: " + player.getHealth() + " | Stamina: " + player.getStamina());
                System.out.println("What would you like to do?");
                System.out.println("1. Move to a new location");
                System.out.println("2. Check Inventory");
                System.out.println("3. Rest");
                System.out.println("4. Quit Game");

                int choice = -1;

                // Input validation loop
                while (choice < 1 || choice > 4) {
                    System.out.print("Enter your choice (1-4): ");
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        if (choice < 1 || choice > 4) {
                            System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.next(); // Clear invalid input
                    }
                }
                scanner.nextLine(); // Clear the newline character from the buffer

                // Handle player actions based on choice
                switch (choice) {
                    case 1:
                        map.navigate(player); // Move to a new location
                        break;
                    case 2:
                        player.showInventory(); // Check inventory
                        break;
                    case 3:
                        player.rest(); // Rest to regain stamina
                        break;
                    case 4:
                        System.out.println("You chose to quit the game. Goodbye!");
                        System.exit(0); // Exit the game
                        break;
                    default:
                        System.out.println("Unexpected error occurred. Please restart the game."); // Safeguard
                        break;
                }
            }

            // End-game messages
            if (player.isAlive()) {
                System.out.println("\nCongratulations! You've reached the Safe Haven and survived the apocalypse!");
            } else {
                System.out.println("\nGame Over. You didn't survive the apocalypse.");
            }
        } // Scanner automatically closed here with try-with-resources
    }
}