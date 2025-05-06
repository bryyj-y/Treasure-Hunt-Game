//Represents a Hunter object that can collect treasures on the map

import java.util.ArrayList;
public class Hunter {

    private String name = "Unknown";
    private int x = 0;
    private int y = 0;
    private int score= 20;
    private ArrayList<Treasure> collected;

    public Hunter() {}

    public Hunter(String name, int initialScore) {
        this.name = name;
        score = initialScore;
        this.collected = new ArrayList<Treasure>();
    }

    public Hunter(int x, int y, String name, int initialScore) {
        this.x = x;
        this.y = y;
        this.name = name;
        score = initialScore;
        this.collected = new ArrayList<Treasure>();
    }


    public String toString() {
        return String.format("Hunter %s: %d points. Treasures collected: %d",
                name, score, collected.size());
    }

    public Treasure findClosest(ArrayList<Treasure> treasures) {
        if (treasures.isEmpty()) {return null;}
        if (treasures.size() == 1) {return treasures.get(0);}

        Treasure closest = treasures.get(0);
        int minDistance = closest.distance(x, y);

        for (Treasure t : treasures) {
            int distance = t.distance(x, y);
            if (distance < minDistance) {
                minDistance = distance;
                closest = t;
            }
        }

        return closest;

    }


    public boolean collect(ArrayList<Treasure> treasures){
        Treasure closestTreasure = findClosest(treasures);

        int distance = closestTreasure.distance(x, y);
        if (score >= distance) {
            int oldX = x;
            int oldY = y;

            score -= distance;
            score += closestTreasure.getValue();

            this.x = closestTreasure.x;
            this.y = closestTreasure.y;
            collected.add(closestTreasure);
            treasures.remove(closestTreasure);

            System.out.printf("%s started at (%d, %d), spent %d points, and collected %s. New score: %d.\n",
                    name, oldX, oldY, distance, closestTreasure.toString(), score);
            return true;
        }
        else {
            System.out.printf("%s started at (%d, %d), but does not have enough points to reach the treasure.\n", name, x, y);
            return false;
        }


    }
}
