/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AStarAlgorithm extends JPanel {

    public final int width = 25;
    public final int height = 25;
    private int row;
    private int col;
    private int dstX = 0, dstY = 33;
    private int[] r = {-1, 0, 1, 0};
    private int[] c = {0, 1, 0, -1};
    private int[][] map;
    private boolean initial = false;
    private PriorityQueue<Node> pq = null;

    public void ReadFile() {
        try {
            Scanner input = new Scanner(new File("src/main/resources/map.txt"));
            row = input.nextInt();
            col = input.nextInt();
            map = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    map[i][j] = input.nextInt();
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void DisplayMap(Graphics g) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    g.setColor(Color.gray);
                } else if (map[i][j] == 1) {
                    g.setColor(Color.black);
                } else if (map[i][j] == 2) {
                    g.setColor(Color.green);
                } else if (map[i][j] == 5) {
                    g.setColor(Color.yellow);
                } else {
                    g.setColor(Color.red);
                }
                g.fillRect(j * width, i * height, width, height);
            }
        }
    }

    public boolean isMovable(int x, int y) {
        return (x >= 0 && x < row && y >= 0 && y < col && (map[x][y] == 0 || map[x][y] == 3));
    }

    public double calculateCost(Node cur) {
        return Math.sqrt(Math.pow(cur.x - dstX, 2) + Math.pow(cur.y - dstY, 2));
    }

    public void AStarSearch(Graphics g) {
        if (!pq.isEmpty()) {
            Node min = pq.poll();
            System.out.println(min.x + " " + min.y + " " + (min.cost /*+ min.level*/));

            if (min.cost == 0) {
                //JOptionPane.showMessageDialog(null, "Done");
                return;
            }
            map[min.x][min.y] = 5;
            Timer timer = new Timer(500, new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    repaint();
                }
            });
            timer.setRepeats(false);
            timer.start();

            for (int i = 0; i < 4; i++) {
                if (isMovable(min.x + r[i], min.y + c[i])) {
                    Node child = new Node(min.x + r[i], min.y + c[i], min.level + 1);
                    child.cost = calculateCost(child);
                    pq.add(child);
                    map[child.x][child.y] = 2;
                }
            }
        }
    }

    public void paintComponent(Graphics grs) {
        if (!initial) {
            ReadFile();
            pq = new PriorityQueue<>((a, b) -> (int) ((a.cost /*+ a.level*/) * 1000000 - (b.cost /*+ b.level*/) * 1000000));
            Node root = new Node(11, 1, 0);
            root.cost = calculateCost(root);
            pq.add(root);
            initial = true;
        }
        DisplayMap(grs);
        AStarSearch(grs);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("A* Algorithm");
        frame.add(new AStarAlgorithm());
        frame.setSize(1300, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

}
