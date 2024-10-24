/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 *
 * @author khoa.nv173196
 */
public class Node {
    public Node parent;
    public int x, y;
    public double cost;
    public int level;
    
    public Node (int x, int y, int level, Node parent) {
        this.x = x;
        this.y = y;
        this.cost = Double.MAX_VALUE;
        this.level = level;
        this.parent = parent;
    }
}
