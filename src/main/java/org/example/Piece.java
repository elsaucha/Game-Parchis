package org.example;

import java.awt.*;

public class Piece {
    private Color color;
    private int pieceSize = 22;
    private int id;
    private int x, y;
    private int location = 0;
    private int locationPoint;
    private boolean sharingCell = false;

    public Piece(int id, int x, int y, String color){
        this.id = id;
        this.x = x;
        this.y = y;
        setAttributes(color);
    }

    protected void setAttributes(String c){
        switch (c){
            case "red":
                this.color = new Color(232, 44, 44);
                this.locationPoint = 38;
                break;
            case "blue":
                this.color = new Color(44, 50, 232);
                this.locationPoint = 21;
                break;
            case "yellow":
                this.color = new Color(242, 224, 63);
                this.locationPoint = 4;
                break;
            case "green":
                this.color = new Color(42, 176, 42);
                this.locationPoint = 55;
                break;
        }
    }

    protected void drawPieces(Graphics2D graphics){
        graphics.setColor(this.color);
        graphics.fillOval(this.x,this.y,pieceSize,pieceSize);
        graphics.setColor(Color.black);
        graphics.drawOval(this.x,this.y,pieceSize,pieceSize);
    }

    protected int getX(){
        return this.x;
    }

    protected int getY(){
        return this.y;
    }

    protected void setX(int x){
        this.x = x;
    }

    protected  void setY(int y){
        this.y = y;
    }
    protected int getSize(){
        return this.pieceSize;
    }
    protected int getLocation(){
        return this.location;
    }

    protected void setLocation(int l){
        this.location = l;
    }

    protected int getLocationPoint(){
        return locationPoint;
    }

    protected  void setLocationPoint(int lp){
        this.locationPoint = lp;
    }

    protected int getColor(){
        return this.color.getRed();
    }

    protected Boolean getStatus(){
        return sharingCell;
    }

    protected void setStatus(Boolean status){
        sharingCell = status;
    }

}
