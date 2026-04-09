package org.example;

import java.awt.*;

public class Piece {
    private Color color;
    private int pieceSize = 21;
    private int id;
    private int x, y;

    public Piece(int id, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    protected void changeColor(String c){
        switch (c){
            case "red":
                this.color = new Color(232, 44, 44);
                break;
            case "blue":
                this.color = new Color(44, 50, 232);
                break;
            case "yellow":
                this.color = new Color(242, 224, 63);
                break;
            case "green":
                this.color = new Color(42, 176, 42);
                break;
        }
    }

    protected void drawPieces(Graphics2D graphics, String color){
        changeColor(color);
        graphics.setColor(this.color);
        graphics.fillOval(this.x,this.y,pieceSize,pieceSize);
        graphics.setColor(Color.black);
        graphics.drawOval(this.x,this.y,pieceSize,pieceSize);
    }


}
