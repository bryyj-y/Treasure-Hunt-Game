//Doubles the original value of a treasure object

public class DoubleBonusTreasure extends Treasure{
    public DoubleBonusTreasure() {
        super();
        this.value *= 2;
    }

    public DoubleBonusTreasure(int value) {
        super(value * 2);
    }

    public DoubleBonusTreasure(int x, int y, int value) {
        super(x, y, value * 2);
    }
}
