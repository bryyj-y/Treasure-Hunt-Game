//Modifies a Treasure object to become a trap with a penalty that reduces the player's score

public class TrapTreasure extends Treasure{
    private int penalty = 50;

    public TrapTreasure() {super();	}

    public TrapTreasure(int penalty) {this.penalty = penalty;}

    public TrapTreasure(int value, int penalty) {
        this.value = value;
        this.penalty = penalty;
    }

    public TrapTreasure(int x, int y, int value, int penalty) {
        super(x, y, value);
        this.penalty = penalty;
    }

    public int getPenalty() {return penalty;}

    public int getValue() {return value - penalty;}

    public String toString() {
        return super.toString() + String.format("but has a penalty of %d", penalty);
    }
}
