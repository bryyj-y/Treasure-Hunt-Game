//BYEO399
//Treasure Hunt Game where players collect treasures on a grid.

import java.util.*;
public class A1 {
    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);
        System.out.println("Welcome to the Treasure Hunt Game!");

        //get initial score
        System.out.println("Enter the initial score (1-100):");
        int initialScore = getInput.nextInt();

        //get number of treasures
        System.out.println("Enter the number of Treasures:");
        int maxTreasures = getInput.nextInt();

        //create treasure map
        TreasureMap treasureMap = new TreasureMap(initialScore, maxTreasures, 50, 50, 30);

        //get number of hunters
        System.out.println("Enter the number of hunters (1-5):");
        int numberOfHunters = getInput.nextInt();

        for (int i = 1; i <= numberOfHunters; i++){
            System.out.printf("Enter the name of the %d hunter: \n", i);
            String name = getInput.next();
            treasureMap.addHunter(name);
        }

        treasureMap.start();

        treasureMap.announce();
    }
}