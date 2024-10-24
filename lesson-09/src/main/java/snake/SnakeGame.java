/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author khoa.nv173196
 */
public class SnakeGame extends JFrame {

    public SnakeGame() {
        add(new Board());
        setResizable(false);
        pack();

        setTitle("Snake Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ex = new SnakeGame();
                ex.setVisible(true);
            }

        });
    }
}
