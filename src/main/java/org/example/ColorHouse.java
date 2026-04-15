package org.example;

import java.awt.*;

public class ColorHouse {
    private Color color;
    Color myRed = new Color(222, 126, 113);
    Color myBlue = new Color(81, 83, 224);
    Color myGreen = new Color(118, 214, 118);
    Color myYellow = new Color(240, 233, 127);
    private int houseRectSize = 175;
    private int houseBigOvalSize = 125;
    private int houseSmallOvalSize = 75;
    private int x, y;
    private int[] xt, yt;
    private int boxWidth, boxHeight;
    private int boxSize = 25;
    private int corridorCoordenate;
    private boolean verticalOrientation;
    public ColorHouse( Color color, int houseX, int houseY, int[] triangleX, int[] triangleY, int corridorCoordenate, boolean verticalOrientation){
        this.color = color;
        this.x = houseX;
        this.y = houseY;
        this.xt =triangleX;
        this.yt = triangleY;
        this.corridorCoordenate = corridorCoordenate;
        this.verticalOrientation = verticalOrientation;
    }

    public void drawColorHouses(Graphics2D gr){
        gr.setColor(Color.black);
        gr.drawRect(this.x,this.y, this.houseRectSize, this.houseRectSize);
        GraphicsUtils.drawBigOvalsCentered(gr, this.x, this.y, this.color,houseBigOvalSize, houseRectSize);
        GraphicsUtils.drawSmallOvalCentered(gr, this.x, this.y, houseSmallOvalSize, houseRectSize);
        drawBoardCenter(gr);
        drawColorCorridor(gr);
        drawStartPoints(gr);
    }

    private void drawBoardCenter(Graphics2D gr){
        gr.setColor(this.color);
        gr.fillPolygon(this.xt, this.yt,3);
    }

    //Dibuja los pasillos de colores
    private void drawColorCorridor(Graphics2D gr){
        changeOrientation(this.verticalOrientation);
        int finalX = this.corridorCoordenate+this.boxSize*7;
        for (int i = this.corridorCoordenate; i < finalX; i = i+this.boxSize) {
            if (verticalOrientation) {
                gr.setColor(this.color);
                gr.fillRect(267 + 1, i + 1, this.boxWidth, this.boxHeight);
                gr.setColor(Color.black);
                gr.drawRect(267, i, this.boxWidth, this.boxHeight);
            } else {
                gr.setColor(this.color);
                gr.fillRect(i+1,267+1,this.boxWidth,this.boxHeight);
                gr.setColor(Color.black);
                gr.drawRect(i,267,this.boxWidth,this.boxHeight);
            }
        }
    }

    //Colorea las casillas donde comienza cada color, dibuja el circulo y escribe 'SALIDA' en cada una
    private void drawStartPoints(Graphics2D gr) {
        changeOrientation(true);
        gr.setColor(myRed);
        gr.fillRect(176,25*3+1,boxWidth-1,boxHeight-1);
        gr.setColor(myYellow);
        gr.fillRect(360,626-25*4,boxWidth-1,boxHeight-1);
        changeOrientation(false);
        gr.setColor(myBlue);
        gr.fillRect(626-25*4,176,boxWidth-1,boxHeight-1);
        gr.setColor(myGreen);
        gr.fillRect(25*3+1,360,boxWidth-1,boxHeight-1);

        gr.setColor(Color.black);
        gr.setFont(new Font("Arial", Font.PLAIN, 6));
        GraphicsUtils.drawCenteredRotatedString(gr, "SALIDA", 212, 77, 22, 22, 180);
        GraphicsUtils.drawCenteredRotatedString(gr, "SALIDA", 527, 212, 22, 22, 270);
        GraphicsUtils.drawCenteredRotatedString(gr, "SALIDA", 77, 395, 22, 22, 90);
        GraphicsUtils.drawCenteredRotatedString(gr, "SALIDA", 395, 527, 22, 22, 0);

        gr.setColor(Color.black);
        gr.drawOval(212,77,22,22);
        gr.drawOval(527,212,22,22);
        gr.drawOval(77,395,22,22);
        gr.drawOval(395,527,22,22);
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
