package org.example;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel{
    public static final int WIDTH = 640;
    public static final int HEIGHT = 665;
    private Board board;
    private GameLogic gameLogic;
    public Game(){
        setBackground(Color.white);

        this.board = new Board();
        this.gameLogic = new GameLogic();

        new Timer(16, e -> update()).start();
    }

    private void update(){
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        board.createBoard(graphics);
        //piece.createPieces
    }
}
