package org.example;

import java.awt.*;

public class Cell {
    private int x, y;
    private int boxWidth, boxHeight;
    private boolean verticalOrientation;
    private Graphics2D graphics;
    public Cell(Graphics2D graphics, int x, int y, boolean verticalOrientation){
        this.graphics = graphics;
        this.x = x;
        this.y = y;
        this.verticalOrientation = verticalOrientation;
        drawCell();
        createSavePoints();
    }

    private void drawCell(){
        orientation(verticalOrientation);
        this.graphics.setColor(Color.black);
        this.graphics.drawRect(this.x,this.y,boxWidth,boxHeight);
        this.graphics.setColor(Color.white);
        this.graphics.fillRect(this.x+1,this.y+1,boxWidth-1,boxHeight-1);
    }

    private void orientation(boolean verticalOrientation){
        if (verticalOrientation){
            boxWidth = 92;
            boxHeight = 25;
        } else {
            boxWidth = 25;
            boxHeight = 92;
        }
    }

    //Dibuja los circulos de seguridad
    public void createSavePoints(){
        this.graphics.setColor(Color.black);
        this.graphics.drawOval(304,2,22,22);
        this.graphics.drawOval(396,77,22,22);
        this.graphics.drawOval(602,304,22,22);
        this.graphics.drawOval(527,396,22,22);
        this.graphics.drawOval(2,303,22,22);
        this.graphics.drawOval(77,211,22,22);
        this.graphics.drawOval(303,602,22,22);
        this.graphics.drawOval(211,527,22,22);
    }
}
