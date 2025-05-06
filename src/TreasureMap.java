//BYEO399
//contains the games state, including hunters and treasures on the map

import java.util.*;
public class TreasureMap {
    private ArrayList<Hunter> hunters;
    private ArrayList<Treasure> treasures;
    private int initialScore = 20;
    private int maxX, maxY, maxValue;

    public TreasureMap(int initialScore, int numOfTreasures, int maxX, int maxY, int maxValue) {
        this.initialScore = initialScore;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxValue = maxValue;
        this.treasures = new ArrayList<Treasure>();
        this.hunters = new ArrayList<Hunter>();

        //creating new treasure map
        Random rand = new Random(30);
        for (int i = 0; i < numOfTreasures; i++){
            int x = rand.nextInt(maxX);
            int y = rand.nextInt(maxY);
            int value = rand.nextInt(maxValue);
            treasures.add(new Treasure(x, y, value));
        }

        //DoubleBonusTreasure
        int dX = rand.nextInt(maxX);
        int dY = rand.nextInt(maxY);
        int dValue = rand.nextInt(maxValue);
        treasures.add(new DoubleBonusTreasure(dX, dY, dValue));

        //TrapTreasure
        int tX = rand.nextInt(maxX);
        int tY = rand.nextInt(maxY);
        int tValue = rand.nextInt(maxValue);
        int tPenalty = rand.nextInt(maxValue);
        treasures.add(new TrapTreasure(tX, tY, tValue, tPenalty));

        //print all Treasures:
        for (Treasure t: treasures) {System.out.println(t);}

    }

    public void addHunter(String name){
        hunters.add(new Hunter(name, initialScore));
    }

    public void start() {
        while (!treasures.isEmpty()) {
            for (Hunter h : hunters) {
                boolean collected = h.collect(treasures);
                if (!collected) {
                    return; // end game if any hunter cannot collect
                }
                if (treasures.isEmpty()) {
                    return; // all treasures collected
                }
            }
        }
    }

    public void announce() {
        System.out.println("\n--- Final Scores ---");
        for (Hunter h: hunters){
            System.out.println(h);
        }
    }

}
