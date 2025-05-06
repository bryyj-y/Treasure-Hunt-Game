//BYEO399
//represents a Treasure object with x,y coordinates & its respective value

public class Treasure {
    public int x = 0;
    public int y = 0;
    protected int value = 20;

    public Treasure() {}

    public Treasure(int value) {this.value = value;}

    public Treasure(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getValue() {return value;}

    public int distance(int hunter_x, int hunter_y) {
        return (int) Math.round(Math.sqrt(Math.pow(hunter_x - x, 2) + Math.pow(hunter_y - y, 2)));
    }

    public String toString() {
        return String.format("Treasure at (%d, %d) worth %d points", x, y, value);
    }
}