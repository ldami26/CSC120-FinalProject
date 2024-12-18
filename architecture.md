                               +----------------------------------+
                                |             Game.java           |
                                |-----------------------------------|
                                |    - main(String[] args)      |
                                |-----------------------------------|
                                | - Initializes the game        |
                                | - Handles game look        |
                                | - Displays player stats      |
                                | - Interacts with Player       |
                                |   and GameMap classes   |
                                +-----------------+----------------+
                                                      ↓
                                +----------------------------------+
                                 |         GameMap.java        |
                                 |-----------------------------------|
                                 |    - locations[]                   |
                                 |  - currentLocationIndex    |
                                 |-----------------------------------|
                                 |   - navigate(Player)          |
                                 |   - encounter(Player)        |
                                 |   - getCurrentLocation()    |
                                 |   - isAtSafeHaven()           |
                                 +----------------+----------------+
                                                      ↓
                                 +----------------------------------+
                                  |            Player.java            |
                                  |-----------------------------------|
                                  |    - name                           |
                                  |    - health                          |
                                  |    - stamina                       |
                                  |  - inventory (HashMap)    |
                                  |-----------------------------------|
                                  |    - reduceHealth(int)        |
                                  |    - reduceStamina(int)     |
                                  |    - addItem(String)           |
                                  |    - useItem(String)           |
                                  |    - rest()                           |
                                  |    - showInventory()          |
                                  |    - isAlive()                       |
                                  |    - hasItem(String)           |
                                 +-----------------------------------+

