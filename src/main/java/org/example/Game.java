package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Game extends JPanel{
    protected static final int WIDTH = 640;
    protected static final int HEIGHT = 665;
    private Board board;
    private Piece pR1,pR2,pR3,pR4,pB1,pB2,pB3,pB4,pY1,pY2,pY3,pY4,pG1,pG2,pG3,pG4;
    private GameLogic gameLogic;
    private int[] coordinates = {15, 140, 465, 590};
    private Dice dice;
    private int dicePositionX = 283;
    private int DicePositionY = 283;
    private int diceSize = 60;
    public Game(){
        setBackground(Color.white);

        this.board = new Board();
        this.gameLogic = new GameLogic();
        this.dice = new Dice();
        createPieces();

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int mouseX = e.getX();
                int mouseY = e.getY();

                if (isDiceClicked(mouseX, mouseY)){
                    rollingDiceAnimation();
                }
            }
        });

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

        board.drawBoard(graphics);
        drawPieces(graphics);
        drawDice(graphics);
    }

    private void drawDice(Graphics2D graphics){
        int value = gameLogic.getDiceValue();
        graphics.drawImage(dice.diceImages[value-1],dicePositionX, DicePositionY,diceSize,diceSize,null);
    }

    private boolean isDiceClicked(int x, int y){
        if (x >= dicePositionX && x <= dicePositionX+diceSize && y >= DicePositionY && y <= DicePositionY+diceSize){
            return true;
        }else {
            return false;
        }
    }

    private void rollingDiceAnimation(){
        Timer animationTimer = new Timer(80, null);

        animationTimer.addActionListener(e1 -> {
            gameLogic.rollDice();
            repaint();
        });
        animationTimer.start();

        new Timer(700, e2 -> {
            animationTimer.stop();

            gameLogic.rollDice();
            repaint();

            ((Timer)e2.getSource()).stop();
        }).start();
    }

    private void createPieces(){
        pR1 = new Piece(1, coordinates[0], coordinates[0]);
        pR2 = new Piece(2, coordinates[1], coordinates[0]);
        pR3 = new Piece(3, coordinates[0], coordinates[1]);
        pR4 = new Piece(4, coordinates[1], coordinates[1]);

        pB1 = new Piece(1, coordinates[2], coordinates[0]);
        pB2 = new Piece(2, coordinates[3], coordinates[0]);
        pB3 = new Piece(3, coordinates[2], coordinates[1]);
        pB4 = new Piece(4, coordinates[3], coordinates[1]);

        pG1 = new  Piece(1, coordinates[0], coordinates[2]);
        pG2 = new Piece(2, coordinates[1], coordinates[2]);
        pG3 = new Piece(3, coordinates[0], coordinates[3]);
        pG4 = new Piece(4, coordinates[1], coordinates[3]);

        pY1 = new Piece(1, coordinates[2], coordinates[2]);
        pY2 = new Piece(2, coordinates[3], coordinates[2]);
        pY3 = new Piece(3, coordinates[2], coordinates[3]);
        pY4 = new Piece(4, coordinates[3], coordinates[3]);
    }

    private void drawPieces(Graphics2D graphics){
        pR1.drawPieces(graphics, "red");
        pR2.drawPieces(graphics, "red");
        pR3.drawPieces(graphics, "red");
        pR4.drawPieces(graphics, "red");

        pB1.drawPieces(graphics, "blue");
        pB2.drawPieces(graphics, "blue");
        pB3.drawPieces(graphics, "blue");
        pB4.drawPieces(graphics, "blue");

        pG1.drawPieces(graphics, "green");
        pG2.drawPieces(graphics, "green");
        pG3.drawPieces(graphics, "green");
        pG4.drawPieces(graphics, "green");

        pY1.drawPieces(graphics, "yellow");
        pY2.drawPieces(graphics, "yellow");
        pY3.drawPieces(graphics, "yellow");
        pY4.drawPieces(graphics, "yellow");

    }
}
