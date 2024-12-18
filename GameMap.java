import java.util.Random;
import java.util.Scanner;

public class GameMap {
    private String[] locations = {"Abandoned Town", "Forest", "Highway", "Zombie Horde", "Supply Store", "Safe Haven"};
    private int currentLocationIndex;

    public GameMap() {
        this.currentLocationIndex = 0; // Start at the first location
    }

    public String getCurrentLocation() {
        return locations[currentLocationIndex];
    }

    public boolean isAtSafeHaven() {
        return currentLocationIndex == locations.length - 1;
    }

    public void navigate(Player player) {
        if (currentLocationIndex < locations.length - 1) {
            currentLocationIndex++;
            System.out.println("You moved to " + locations[currentLocationIndex] + ".");
            encounter(player);
        } else {
            System.out.println("You are already at the Safe Haven.");
        }
    }

    private void encounter(Player player) {
        Random random = new Random();
        int encounterType = random.nextInt(3); // 0 = Zombie, 1 = Loot, 2 = Decision-Making Event

        Scanner scanner = new Scanner(System.in);

        switch (encounterType) {
            case 0: { // Zombie Encounter
                System.out.println("A zombie attacks you!");
                System.out.println("What will you do?");
                System.out.println("1. Fight with your Knife");
                System.out.println("2. Run away (uses stamina)");

                int choice = -1;
                // Input validation for valid choice
                while (choice != 1 && choice != 2) {
                    System.out.print("Enter your choice (1 or 2): ");
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        if (choice == 1) {
                            System.out.println("You killed the zombie using your Knife but lost 10 health.");
                            player.reduceHealth(10);
                        } else if (choice == 2) {
                            System.out.println("You escaped the zombie but lost 15 stamina.");
                            player.reduceStamina(15);
                        } else {
                            System.out.println("Invalid choice! The zombie attacked you, causing 20 damage.");
                            player.reduceHealth(20);
                        }
                    } else {
                        System.out.println("Invalid input! Please enter 1 or 2.");
                        scanner.next(); // Clear invalid input
                    }
                }
                break;
            }
            case 1: { // Loot Encounter
                System.out.println("You found supplies!");
                player.addItem("First Aid Kit");
                player.addItem("Energy Bar");
                break;
            }
            case 2: { // Survivor Trade Encounter
                System.out.println("You encounter a survivor who offers to trade. Will you?");
                System.out.println("1. Trade a First Aid Kit for 2 Energy Bars");
                System.out.println("2. Decline and move on");

                int choice = -1;
                // Input validation for valid choice
                while (choice != 1 && choice != 2) {
                    System.out.print("Enter your choice (1 or 2): ");
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        if (choice == 1 && player.getHealth() > 0 && player.hasItem("First Aid Kit")) {
                            player.useItem("First Aid Kit");
                            player.addItem("Energy Bar");
                            player.addItem("Energy Bar");
                            System.out.println("You traded a First Aid Kit for 2 Energy Bars.");
                        } else if (choice == 1) {
                            System.out.println("You don't have a First Aid Kit or can't make the trade.");
                        } else if (choice == 2) {
                            System.out.println("You declined the trade and moved on.");
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    } else {
                        System.out.println("Invalid input! Please enter 1 or 2.");
                        scanner.next(); // Clear invalid input
                    }
                }
                break;
            }
            default: {
                System.out.println("Unexpected encounter type.");
                break;
            }
        }
    }
}
