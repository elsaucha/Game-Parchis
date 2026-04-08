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
        createStartPoints();
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

    //Colorea las casillas donde comienza cada color, dibuja el circulo y escribe 'SALIDA' en cada una
    private void createStartPoints() {
        changeOrientation(true);
        this.graphics.setColor(Color.red);
        this.graphics.fillRect(176,25*3+1,boxWidth-1,boxHeight-1);
        this.graphics.setColor(Color.orange);
        this.graphics.fillRect(360,626-25*4,boxWidth-1,boxHeight-1);
        changeOrientation(false);
        this.graphics.setColor(Color.blue);
        this.graphics.fillRect(626-25*4,176,boxWidth-1,boxHeight-1);
        this.graphics.setColor(Color.green);
        this.graphics.fillRect(25*3+1,360,boxWidth-1,boxHeight-1);

        this.graphics.setColor(Color.black);
        this.graphics.setFont(new Font("Arial", Font.PLAIN, 6));
        drawCenteredRotatedString(graphics, "SALIDA", 212, 77, 22, 22, 180);
        drawCenteredRotatedString(graphics, "SALIDA", 527, 212, 22, 22, 270);
        drawCenteredRotatedString(graphics, "SALIDA", 77, 395, 22, 22, 90);
        drawCenteredRotatedString(graphics, "SALIDA", 395, 527, 22, 22, 0);

        this.graphics.setColor(Color.black);
        this.graphics.drawOval(212,77,22,22);
        this.graphics.drawOval(527,212,22,22);
        this.graphics.drawOval(77,395,22,22);
        this.graphics.drawOval(395,527,22,22);
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

    //Función para rotar y escribir cualquier label
    private void drawCenteredRotatedString(Graphics2D g2d, String text, int x, int y, int width, int height, int angleDegrees) {

        // Centro del óvalo en tu caso
        int centerX = x + width / 2;
        int centerY = y + height / 2;

        // Métricas del texto
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getAscent();

        // Posición centrada (antes de rotar)
        int textX = centerX - textWidth / 2;
        int textY = centerY + textHeight / 2;

        // Convertir a radianes
        double angle = Math.toRadians(angleDegrees);

        // Rotar alrededor del centro
        g2d.rotate(angle, centerX, centerY);

        // Dibujar texto
        g2d.drawString(text, textX, textY);

        // Deshacer rotación
        g2d.rotate(-angle, centerX, centerY);
    }
}
