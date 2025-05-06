# Treasure Hunt Game

This is a simple Treasure Hunt game implemented in Java. Players (Hunters) navigate a grid to collect treasures, earning points based on the treasure's value and losing points based on the distance traveled. Be aware of trap treasures that can reduce your score!

## How to Play

1.  **Welcome:** The game starts with a welcome message.
2.  **Initial Score:** You will be prompted to enter an initial score for all hunters (between 1 and 100).
3.  **Number of Treasures:** You will then enter the number of regular treasures to be placed on the map.
4.  **Number of Hunters:** Enter the number of players (hunters) who will participate (between 1 and 5).
5.  **Hunter Names:** For each hunter, you will be asked to enter their name.
6.  **Game Start:** The game begins, and each hunter will attempt to collect the closest available treasure.
    * A hunter spends points equal to the distance to the treasure.
    * If a hunter has enough points to reach a treasure, they collect it, and their score is updated (increased by the treasure's value).
    * If a hunter encounters a trap treasure, their score is reduced by the trap's penalty.
    * The hunter's new position is updated to the location of the collected treasure.
    * The game continues until all treasures are collected or a hunter cannot reach any remaining treasure.
7.  **Final Scores:** Once the game ends, the final scores and the list of collected treasures for each hunter are announced.

## Game Mechanics

* **Treasure:** Each treasure has a location (x, y coordinates) and a value.
* **Hunter:** Each hunter has a name, a current location (initially 0, 0), and a score.
* **Movement Cost:** The cost to move to a treasure is the Euclidean distance between the hunter's current location and the treasure's location (rounded to the nearest integer).
* **Collecting Treasure:** A hunter can only collect a treasure if their current score is greater than or equal to the distance to that treasure.
* **Double Bonus Treasure:** This special treasure doubles its original value when collected.
* **Trap Treasure:** This special treasure reduces the hunter's score by a penalty amount in addition to its base value (which might be zero or positive).

## Code Structure

The project consists of the following Java files:

* `A1.java`: Contains the `main` method to start the Treasure Hunt game, get user inputs, and manage the game flow.
* `DoubleBonusTreasure.java`: A subclass of `Treasure` that represents a treasure with double the original value.
* `Hunter.java`: Represents a player in the game, with attributes like name, position, score, and a list of collected treasures. It includes methods to find the closest treasure and collect it.
* `TrapTreasure.java`: A subclass of `Treasure` that represents a trap which reduces the hunter's score when "collected".
* `Treasure.java`: The base class for all treasures, with attributes for location (x, y) and value, and a method to calculate the distance to a given point.
* `TreasureMap.java`: Manages the game state, including the list of hunters and treasures. It initializes the map with treasures (including a double bonus and a trap treasure), adds hunters, starts the game loop, and announces the final scores.

## How to Run

1.  Save all the `.java` files in the same directory.
2.  Compile the Java code using a Java Development Kit (JDK):
    ```bash
    javac A1.java DoubleBonusTreasure.java Hunter.java TrapTreasure.java Treasure.java TreasureMap.java
    ```
3.  Run the main class `A1`:
    ```bash
    java A1
    ```
4.  Follow the prompts in the console to enter the initial score, number of treasures, number of hunters, and their names.

## Potential Improvements

* Implement different movement strategies for hunters (e.g., prioritizing high-value treasures).
* Add obstacles or different types of terrain to the map that affect movement cost.
* Allow hunters to have different initial scores.
* Implement a graphical user interface (GUI) for a more visual gameplay experience.
* Introduce randomness in hunter starting positions.
* Add more sophisticated game ending conditions.
* Implement error handling for invalid user inputs.
