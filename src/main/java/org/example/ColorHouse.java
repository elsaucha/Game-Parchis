package org.example;

import java.awt.*;

public class ColorHouse {
    private Color color;
    private int houseRectSize = 175;
    private int houseBigOvalSize = 125;
    private int houseSmallOvalSize = 75;
    private int x, y;
    private int[] xt, yt;
    Graphics2D graphics;
    private int boxWidth, boxHeight;
    private int boxSize = 25;
    private int corridorCoordenate;
    private boolean verticalOrientation;
    public ColorHouse(Graphics2D graphics, Color color, int houseX, int houseY, int[] triangleX, int[] triangleY, int corridorCoordenate, boolean verticalOrientation){
        this.graphics = graphics;
        this.color = color;
        this.x = houseX;
        this.y = houseY;
        this.xt =triangleX;
        this.yt = triangleY;
        this.corridorCoordenate = corridorCoordenate;
        this.verticalOrientation = verticalOrientation;
        createColorHouses();
    }

    public void createColorHouses(){
        this.graphics.setColor(Color.black);
        this.graphics.drawRect(this.x,this.y, this.houseRectSize, this.houseRectSize);
        drawBigOvalsCentered(houseBigOvalSize);
        drawSmallOvalCentered(houseSmallOvalSize);
        drawBoardCenter();
        drawColorCorridor();
    }

    private void drawBigOvalsCentered(int oval) {
        // Centro del rectangulo
        int centerX = this.x + houseRectSize / 2;
        int centerY = this.y + houseRectSize / 2;

        // Posición centrada
        int ovalX = centerX - oval / 2;
        int ovalY = centerY - oval / 2;

        // Dibujar
        this.graphics.setColor(this.color);
        this.graphics.fillOval(ovalX,ovalY,houseBigOvalSize,houseBigOvalSize);
        this.graphics.setColor(Color.black);
        this.graphics.drawOval(ovalX,ovalY,houseBigOvalSize,houseBigOvalSize);
    }

    private void drawSmallOvalCentered(int oval) {
        // Centro del rectangulo
        int centerX = this.x + houseRectSize / 2;
        int centerY = this.y + houseRectSize / 2;

        // Posición centrada
        int ovalX = centerX - oval / 2;
        int ovalY = centerY - oval / 2;

        // Dibujar
        this.graphics.setColor(Color.white);
        this.graphics.drawOval(ovalX,ovalY,houseSmallOvalSize,houseSmallOvalSize);
    }

    private void drawBoardCenter(){
        this.graphics.setColor(this.color);
        this.graphics.fillPolygon(this.xt, this.yt,3);
    }

    //Dibuja los pasillos de colores
    private void drawColorCorridor(){
        changeOrientation(this.verticalOrientation);
        int finalX = this.corridorCoordenate+this.boxSize*7;
        for (int i = this.corridorCoordenate; i < finalX; i = i+this.boxSize) {
            if (verticalOrientation) {
                this.graphics.setColor(Color.black);
                this.graphics.drawRect(267, i, this.boxWidth, this.boxHeight);
                this.graphics.setColor(this.color);
                this.graphics.fillRect(267 + 1, i + 1, this.boxWidth - 1, this.boxHeight - 1);
            } else {
                this.graphics.setColor(Color.black);
                this.graphics.drawRect(i,267,this.boxWidth,this.boxHeight);
                this.graphics.setColor(this.color);
                this.graphics.fillRect(i+1,267+1,this.boxWidth-1,this.boxHeight-1);
            }
        }
    }

    //Función para cambiar la orientación de las casillas al dibujarlas
    private void changeOrientation(boolean verticalOrientation){
        if (verticalOrientation){
            this.boxWidth = 92;
            this.boxHeight = 25;
        } else {
            this.boxWidth = 25;
            this.boxHeight = 92;
        }
    }
}
