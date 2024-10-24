/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.PriorityQueue;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author khoa.nv173196
 */
public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    private final int DELAY = 140;
    private final int ROW = B_HEIGHT / DOT_SIZE;
    private final int COL = B_WIDTH / DOT_SIZE;
    private final int BLANK = 0;
    private final int WALL = 1;
    private final int SNAKE = 2;
    private final int VISITED = 3;

    private final int[] x = new int[ALL_DOTS];
    private final int[] y = new int[ALL_DOTS];
    private final int[] com_x = new int[ALL_DOTS];
    private final int[] com_y = new int[ALL_DOTS];
    private final int[] brick_x = new int[ROW];
    private final int[] brick_y = new int[ROW];
    private final int[][] map = new int[ROW][COL];
    private final int[] r = {-1, 0, 1, 0};
    private final int[] c = {0, 1, 0, -1};

    private PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (int) ((a.cost + a.level - b.level - b.cost) * 1000000));
    private Stack<Node> st = new Stack<>();

    private int dots = 3;
    private int com_dots = 3;
    private int apple_x;
    private int apple_y;
    //private int WIN;

    // top, right, bottom, left
    private final boolean[] direction = new boolean[]{false, true, false, false};
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;
    private Image com_ball;
    private Image com_head;
    private Image brick;
    
    public Board() {
        addKeyListener(new TAdapter());
        setBackground(Color.gray);
        setFocusable(true);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    public void loadImages() {
        ImageIcon brickImg = new ImageIcon(getClass().getResource("/brick.png"));
        brick = brickImg.getImage();
        ImageIcon dotImg = new ImageIcon(getClass().getResource("/dot.png"));
        ball = dotImg.getImage();
        com_head = dotImg.getImage();
        ImageIcon appleImg = new ImageIcon(getClass().getResource("/apple.png"));
        apple = appleImg.getImage();
        ImageIcon headImg = new ImageIcon(getClass().getResource("/head.png"));
        head = headImg.getImage();
        com_ball = headImg.getImage();
    }

    public void initGame() {
        for (int i = 0; i < ROW; i++) {
            brick_x[i] = (int) (Math.random() * RAND_POS);
            brick_y[i] = (int) (Math.random() * RAND_POS);
            map[brick_x[i]][brick_y[i]] = WALL;
            brick_x[i] *= DOT_SIZE;
            brick_y[i] *= DOT_SIZE;
        }
        for (int i = 0; i < dots; i++) {
            x[i] = (dots - i - 1) * DOT_SIZE;
            y[i] = 0;
            com_x[i] = B_WIDTH - DOT_SIZE;
            com_y[i] = (dots - i - 1) * DOT_SIZE;
        }
        locateApple();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        if (inGame) {
            g.drawImage(apple, apple_x, apple_y, this);
            g.drawImage(head, x[0], y[0], this);
            g.drawImage(com_head, com_x[0], com_y[0], this);
            for (int i = 1; i < dots; i++) {
                g.drawImage(ball, x[i], y[i], this);
            }
            for (int i = 1; i < com_dots; i++) {
                g.drawImage(com_ball, com_x[i], com_y[i], this);
            }
            for (int i = 0; i < ROW; i++) {
                g.drawImage(brick, brick_x[i], brick_y[i], this);
            }
            Toolkit.getDefaultToolkit().sync();
        } else {
            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    private void checkApple() {
        if ((x[0] == apple_x) && (y[0] == apple_y)) {
            ++dots;
            locateApple();
        } else if ((com_x[0] == apple_x) && (com_y[0] == apple_y)) {
            ++com_dots;
            locateApple();
        }
    }

    private void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        if (direction[3]) {
            x[0] -= DOT_SIZE;
        } else if (direction[1]) {
            x[0] += DOT_SIZE;
        } else if (direction[0]) {
            y[0] -= DOT_SIZE;
        } else if (direction[2]) {
            y[0] += DOT_SIZE;
        }

        if (y[0] == B_HEIGHT) {
            y[0] = 0;
        } else if (y[0] < 0) {
            y[0] = B_HEIGHT - DOT_SIZE;
        } else if (x[0] == B_WIDTH) {
            x[0] = 0;
        } else if (x[0] < 0) {
            x[0] = B_WIDTH - DOT_SIZE;
        }
    }

    private void checkCollision() {
        if (dots > 4) {
            for (int i = dots; i > 3; i--) {
                if ((x[0] == x[i] && y[0] == y[i]) || (com_x[0] == com_x[i] && com_y[0] == com_y[i])) {
                    inGame = false;
                    break;
                }
            }
        } else {
            for (int i = dots; i > 4; i--) {
                if ((x[0] == x[i] && y[0] == y[i]) || (com_x[0] == com_x[i] && com_y[0] == com_y[i])) {
                    inGame = false;
                    break;
                }
            }
        }
        for (int i = 0; i < ROW; i++) {
            if ((x[0] == brick_x[i] && y[0] == brick_y[i]) || (com_x[0] == brick_x[i] && com_y[0] == brick_y[i])) {
                inGame = false;
                break;
            }
        }
        if (!inGame) {
            timer.stop();
        }
    }

    private void locateApple() {
        int r;
        do {
            r = (int) (Math.random() * RAND_POS);
            apple_x = r;
            r = (int) (Math.random() * RAND_POS);
            apple_y = r;
        } while (map[apple_x][apple_y] == SNAKE || map[apple_x][apple_y] == WALL);
        apple_x *= DOT_SIZE;
        apple_y *= DOT_SIZE;
        
        // reset map
        pq.clear();
        //st.clear();
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (map[i][j] == VISITED) {
                    map[i][j] = BLANK;
                }
            }
        }
        Node root = new Node(com_x[0] / DOT_SIZE, com_y[0] / DOT_SIZE, 0, null);
        root.cost = calculateCost(root);
        pq.add(root);
        AStarSearch();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkCollision();
            move();
            comMove();
        }
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && !direction[1]) {
                direction[3] = true;
                direction[0] = false;
                direction[2] = false;
            } else if (key == KeyEvent.VK_RIGHT && !direction[3]) {
                direction[1] = true;
                direction[0] = false;
                direction[2] = false;
            } else if (key == KeyEvent.VK_UP && !direction[2]) {
                direction[0] = true;
                direction[1] = false;
                direction[3] = false;
            } else if (key == KeyEvent.VK_DOWN && !direction[0]) {
                direction[2] = true;
                direction[1] = false;
                direction[3] = false;
            }
        }

    }

    // AI
    private boolean isMovable(int x, int y) {
        return map[x][y] == BLANK;
    }

    private void comMove() {
        for (int i = com_dots; i > 0; i--) {
            com_x[i] = com_x[i - 1];
            com_y[i] = com_y[i - 1];
        }

        Node min = st.pop();
        com_x[0] = min.x * DOT_SIZE;
        com_y[0] = min.y * DOT_SIZE;
        map[min.x][min.y] = SNAKE;
        map[com_x[com_dots] / DOT_SIZE][com_y[com_dots] / DOT_SIZE] = BLANK;
    }

    public double calculateCost(Node node) {
        return Math.sqrt(Math.pow(node.x - apple_x / DOT_SIZE, 2) + Math.pow(node.y - apple_y / DOT_SIZE, 2));
    }

    public void getPath(Node node) {
        while (node.parent != null) {
            st.add(node);
            node = node.parent;
        }
    }

    public void AStarSearch() {
        int x, y;
        while (!pq.isEmpty()) {
            Node min = pq.poll();
            
            System.out.println(min.x + " " + min.y + " " + min.cost + " " + map[min.x][min.y]);

            if (min.cost == 0) {
                getPath(min);
                return;
            }

            for (int i = 0; i < 4; i++) {
                x = min.x + r[i];
                y = min.y + c[i];
                if (y == COL) {
                    y = 0;
                } else if (y < 0) {
                    y = COL - 1;
                } else if (x == ROW) {
                    x = 0;
                } else if (x < 0) {
                    x = ROW - 1;
                }
                if (isMovable(x, y)) {
                    Node child = new Node(x, y, min.level + 1, min);
                    child.cost = calculateCost(child);
                    map[child.x][child.y] = VISITED;
                    pq.add(child);
                }
            }
        }
    }

}
