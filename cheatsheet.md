This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.


# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.


### **1. Commands List**

- **`1. Move to a new location`**
  - **Effect**: Move the player to the next location on the map.
  - **Usage**: Enter `1` when prompted for an action.
  - **Details**:
    - Triggers random encounters (Zombies, Loot, or Trading Events).
    - Locations include:
      - Abandoned Town
      - Forest
      - Highway
      - Zombie Horde
      - Supply Store
      - Safe Haven (final destination).

- **`2. Check Inventory`**
  - **Effect**: Displays all items currently in the player’s inventory.
  - **Usage**: Enter `2` when prompted for an action.
  - **Details**:
    - Shows item names and quantities.
    - Items include:
      - `First Aid Kit`: Restores 30 health.
      - `Energy Bar`: Restores 20 stamina.
      - `Knife`: Used during combat events.

- **`3. Rest`**
  - **Effect**: Regain stamina by resting.
  - **Usage**: Enter `3` when prompted for an action.
  - **Details**:
    - Rest restores **20 stamina**.
    - Cannot exceed 100 stamina.

- **`4. Quit Game`**
  - **Effect**: Exit the game.
  - **Usage**: Enter `4` when prompted for an action.

- **`HELP` Command** *(Optional Implementation)*:
  - **Effect**: Display this list of available commands during gameplay.
  - **Usage**: Type `HELP` at any point (requires implementation inside the game).

---

### **2. Encounters**

While traveling between locations, you may encounter the following events:

1. **Zombie Attack**:
   - **Choices**:
     - **Fight**: Use your Knife to kill the zombie but lose **10 health**.
     - **Run Away**: Escape the zombie but lose **15 stamina**.
   - If you make no choice, you automatically lose **20 health**.

2. **Loot Encounter**:
   - **Effect**: You randomly find supplies to add to your inventory.
   - Items you may find:
     - `First Aid Kit`
     - `Energy Bar`

3. **Survivor Trade**:
   - **Offer**: Trade a `First Aid Kit` for **2 Energy Bars**.
   - **Choices**:
     - Accept the trade.
     - Decline and move on.

---

### **3. Item Usage**

You can use specific items in your inventory for survival:

- **`First Aid Kit`**:
  - **Effect**: Restores 30 health (caps at 100).
  - **Usage**: Selected automatically when chosen in the inventory.

- **`Energy Bar`**:
  - **Effect**: Restores 20 stamina (caps at 100).
  - **Usage**: Selected automatically when chosen in the inventory.

- **`Knife`**:
  - **Effect**: Used during zombie fights.

---

### **4. Challenges to Overcome**

To win the game and reach the Safe Haven, you must:

1. **Manage Resources**:
   - Monitor your **health** and **stamina**.
   - Use `First Aid Kits` and `Energy Bars` wisely.

2. **Survive Zombie Encounters**:
   - Decide whether to fight zombies (health loss) or run away (stamina loss).

3. **Navigate Safely**:
   - Progress through dangerous locations while avoiding death from health depletion.

4. **Reach the Safe Haven**:
   - Successfully survive all encounters and arrive at the final destination.

---

### **5. Win/Lose Conditions**

- **Win**: Reach the Safe Haven while staying alive.
- **Lose**: Health drops to 0 before reaching the Safe Haven.

---

This cheatsheet can optionally be displayed in-game as a response to a `HELP` command to assist players during gameplay.