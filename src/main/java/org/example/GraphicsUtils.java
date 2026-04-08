package org.example;

import java.awt.*;

public class GraphicsUtils {
    public GraphicsUtils(){

    }

    //Dibuja el círculo de color de cada casa centrado
    protected static void drawBigOvalsCentered(Graphics2D gr, int x, int y, Color color, int houseOvalSize, int houseRectSize) {
        // Centro del rectangulo
        int centerX = x + houseRectSize / 2;
        int centerY = y + houseRectSize / 2;

        // Posición centrada
        int ovalX = centerX - houseOvalSize / 2;
        int ovalY = centerY - houseOvalSize / 2;

        // Dibujar
        gr.setColor(color);
        gr.fillOval(ovalX,ovalY,houseOvalSize,houseOvalSize);
        gr.setColor(Color.black);
        gr.drawOval(ovalX,ovalY,houseOvalSize,houseOvalSize);
    }

    //Dibuja el círculo blanco de cada casa centrado
    protected static void drawSmallOvalCentered(Graphics2D gr, int x, int y, int houseOvalSize, int houseRectSize) {
        // Centro del rectangulo
        int centerX = x + houseRectSize / 2;
        int centerY = y + houseRectSize / 2;

        // Posición centrada
        int ovalX = centerX - houseOvalSize / 2;
        int ovalY = centerY - houseOvalSize / 2;

        // Dibujar
        gr.setColor(Color.white);
        gr.drawOval(ovalX,ovalY,houseOvalSize,houseOvalSize);
    }

    //Función para rotar y escribir cualquier label
    protected static void drawCenteredRotatedString(Graphics2D g2d, String text, int x, int y, int width, int height, int angleDegrees) {

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
