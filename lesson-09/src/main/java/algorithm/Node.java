package algorithm;

public class Node {
    public int x, y;
    public double cost;
    public int level;
    
    public Node (int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.cost = Double.MAX_VALUE;
        this.level = level;
    }
}
