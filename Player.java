import java.util.HashMap;

public class Player {
    private String name;
    private int health;
    private int stamina;
    private HashMap<String, Integer> inventory;

    public Player(String name, int health, int stamina) {
        this.name = name;
        this.health = health;
        this.stamina = stamina;
        this.inventory = new HashMap<>();
        // Starter items
        this.inventory.put("Knife", 1); // For combat
        this.inventory.put("First Aid Kit", 1); // For healing
        this.inventory.put("Energy Bar", 2); // For stamina recovery
    }

    public int getHealth() {
        return health;
    }

    public int getStamina() {
        return stamina;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void reduceHealth(int damage) {
        this.health -= damage;
        System.out.println("You took " + damage + " damage! Health: " + this.health);
    }

    public void reduceStamina(int cost) {
        this.stamina -= cost;
        System.out.println("You used " + cost + " stamina. Stamina: " + this.stamina);
    }

    public void addItem(String item) {
        inventory.put(item, inventory.getOrDefault(item, 0) + 1);
        System.out.println(item + " has been added to your inventory.");
    }

    public void useItem(String item) {
        if (!inventory.containsKey(item) || inventory.get(item) <= 0) {
            System.out.println("You don't have " + item + " in your inventory.");
            return;
        }

        // Use the item based on its type
        switch (item) {
            case "First Aid Kit": 
                health = Math.min(100, health + 30); // Heal by 30, but cap at 100 health
                System.out.println("You used a First Aid Kit and regained 30 health! Health: " + health);
                break;
            case "Energy Bar":
                stamina = Math.min(100, stamina + 20); // Recover 20 stamina, but cap at 100 stamina
                System.out.println("You ate an Energy Bar and regained 20 stamina! Stamina: " + stamina);
                break;
            case "Knife":
                System.out.println("You used your Knife in combat. Keep it handy!");
                break;
            default:
                System.out.println("This item can't be used.");
        }

        // Reduce item count after use
        inventory.put(item, inventory.get(item) - 1);
    }

    public void rest() {
        if (stamina < 100) {
            this.stamina = Math.min(100, this.stamina + 20); // Rest to gain 20 stamina, but cap at 100
            System.out.println("You rested and regained stamina. Stamina: " + this.stamina);
        } else {
            System.out.println("You already have full stamina.");
        }
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory:");
            inventory.forEach((item, count) -> System.out.println(item + ": " + count));
        }
    }

    // Additional method to check if the player has a specific item in inventory
    public boolean hasItem(String item) {
        return inventory.containsKey(item) && inventory.get(item) > 0;
    }
}