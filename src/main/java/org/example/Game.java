package org.example;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel{

    public static final int WIDTH = 640;
    public static final int HEIGHT = 665;
    static JFrame frame;
    static Game game;


    public static void main(String[] args) throws InterruptedException {
        frame = new JFrame("Parchís");
        game = new Game();
        game.setBackground(Color.white);
        frame.add(game);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);                          //Abril la ventana en el medio de la pantalla
        frame.setResizable(false);                                  //No cambiar el tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //Al cerrar la ventana se acaba el programa

        new Timer(16, e -> game.repaint()).start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        new Board(graphics);
    }
}
