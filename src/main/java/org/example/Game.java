package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Game extends JPanel{
    protected static final int WIDTH = 640;
    protected static final int HEIGHT = 665;
    private Board board;
    private Piece pR1,pR2,pR3,pR4,pB1,pB2,pB3,pB4,pY1,pY2,pY3,pY4,pG1,pG2,pG3,pG4;
    private Piece[] piecesList = new Piece[16];
    private GameLogic gameLogic;
    private int[] coordinates = {15, 140, 465, 590};
    private Dice dice;
    private int dicePositionX = 283;
    private int DicePositionY = 283;
    private int diceSize = 60;
    private boolean redTurn = false;
    private boolean blueTurn = false;
    private boolean greenTurn = false;
    private boolean yellowTurn = false;

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

               isPieceClicked(mouseX, mouseY);
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

        //graphics.drawImage(redDice.diceImages[value-1], 175/2-diceSize/2, 175/2-diceSize/2, diceSize, diceSize, null);
    }

    private void createPieces(){
        pR1 = new Piece(1, coordinates[0], coordinates[0], "red");
        piecesList[0] = pR1;
        pR2 = new Piece(2, coordinates[1], coordinates[0], "red");
        piecesList[1] = pR2;
        pR3 = new Piece(3, coordinates[0], coordinates[1], "red");
        piecesList[2] = pR3;
        pR4 = new Piece(4, coordinates[1], coordinates[1], "red");
        piecesList[3] = pR4;

        pB1 = new Piece(1, coordinates[2], coordinates[0], "blue");
        piecesList[4] = pB1;
        pB2 = new Piece(2, coordinates[3], coordinates[0], "blue");
        piecesList[5] = pB2;
        pB3 = new Piece(3, coordinates[2], coordinates[1], "blue");
        piecesList[6] = pB3;
        pB4 = new Piece(4, coordinates[3], coordinates[1], "blue");
        piecesList[7] = pB4;

        pG1 = new Piece(1, coordinates[0], coordinates[2], "green");
        piecesList[8] = pG1;
        pG2 = new Piece(2, coordinates[1], coordinates[2], "green");
        piecesList[9] = pG2;
        pG3 = new Piece(3, coordinates[0], coordinates[3], "green");
        piecesList[10] = pG3;
        pG4 = new Piece(4, coordinates[1], coordinates[3], "green");
        piecesList[11] = pG4;

        pY1 = new Piece(1, coordinates[2], coordinates[2], "yellow");
        piecesList[12] = pY1;
        pY2 = new Piece(2, coordinates[3], coordinates[2], "yellow");
        piecesList[13] = pY2;
        pY3 = new Piece(3, coordinates[2], coordinates[3], "yellow");
        piecesList[14] = pY3;
        pY4 = new Piece(4, coordinates[3], coordinates[3], "yellow");
        piecesList[15] = pY4;
    }

    private void drawPieces(Graphics2D graphics){
        pR1.drawPieces(graphics);
        pR2.drawPieces(graphics);
        pR3.drawPieces(graphics);
        pR4.drawPieces(graphics);

        pB1.drawPieces(graphics);
        pB2.drawPieces(graphics);
        pB3.drawPieces(graphics);
        pB4.drawPieces(graphics);

        pG1.drawPieces(graphics);
        pG2.drawPieces(graphics);
        pG3.drawPieces(graphics);
        pG4.drawPieces(graphics);

        pY1.drawPieces(graphics);
        pY2.drawPieces(graphics);
        pY3.drawPieces(graphics);
        pY4.drawPieces(graphics);
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

    private void isPieceClicked(int x, int y){
        for (int i = 0; i<piecesList.length; i++){
            if (x >= piecesList[i].getX() && x <= piecesList[i].getX()+piecesList[i].getSize() && y >= piecesList[i].getY() && y <= piecesList[i].getY()+piecesList[i].getSize()){
                gameLogic.movePiece(piecesList[i]);
                break;
            }
        }
    }
}
