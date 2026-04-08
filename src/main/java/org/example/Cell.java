package org.example;

import java.awt.*;

public class Cell {
    private int x, y;
    private int boxWidth, boxHeight;
    private boolean verticalOrientation;
    public Cell(int x, int y, boolean verticalOrientation){
        this.x = x;
        this.y = y;
        this.verticalOrientation = verticalOrientation;
    }

    public void drawCell(Graphics2D gr){
        orientation(verticalOrientation);
        gr.setColor(Color.black);
        gr.drawRect(this.x,this.y,boxWidth,boxHeight);
        gr.setColor(Color.white);
        gr.fillRect(this.x+1,this.y+1,boxWidth-1,boxHeight-1);
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


}
