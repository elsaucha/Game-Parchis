package org.example;

import java.awt.*;

public class Board {
    private int boxWidth;
    private int boxHeight;
    private int houseRectSize = 175;
    private int houseBigOvalSize = 125;
    private int houseSmallOvalSize = 75;
    public Board(Graphics2D graphics){
        createBoard(graphics);
    }

    public void createBoard(Graphics2D graphics){
        createWhiteSquares(graphics);
        createColorHouses(graphics);
        drawCenter(graphics);
        assignNumbers(graphics);
    }

    //Dibuja la casa de cada color - cuadrado sin fondo y circulo. Y los colores del centro del tablero
    public void createColorHouses(Graphics2D graphics){
        int[] xred={201,426,313};
        int[] yred={201,200,313};
        int[] xblue={425,425,313};
        int[] yblue={201,425,313};
        int[] xgreen={201,201,313};
        int[] ygreen={201,426,313};
        int[] xyellow={201,425,313};
        int[] yyellow={425,425,313};
        new ColorHouse(graphics, Color.red, 0,0, xred, yred, 25,true);
        new ColorHouse(graphics, Color.blue, 451,0, xblue, yblue, 425, false);
        new ColorHouse(graphics, Color.green, 0,451, xgreen, ygreen,25, false);
        new ColorHouse(graphics, Color.orange, 451,451, xyellow, yyellow, 425, true);
    }

    //Dibuja las lineas negras del centro del tablero
    public void drawCenter(Graphics graphics){
        graphics.setColor(Color.black);
        graphics.drawRect(200,200,225,225);
        graphics.drawLine(175,175,451,451);
        graphics.drawLine(451,175,175,451);
    }

    //Dibuja las casillas blancas normales (también crea las de los pasillos de colores, sin color)
    public void createWhiteSquares(Graphics2D graphics){
        orientation(true);
        for (int i = 175; i < 451; i = i+boxWidth){
            for (int j = 0; j < 610; j = j+boxHeight){
                if (j < 175 || j >= 450){
                    new Cell(graphics,i,j,true);
                }
            }
        }
        orientation(false);
        for (int i = 0; i < 610; i = i+boxWidth){
            for (int j = 175; j < 451; j = j+boxHeight){
                if (i < 175 || i >= 450){
                    new Cell(graphics,i,j,false);
                }
            }
        }
    }

    public void assignNumbers(Graphics2D graphics){
        graphics.setFont(new Font("Arial", Font.PLAIN, 16));

        //Columna amarillo-azul
        int y=608;
        for (int i = 1; i <= 33; i++){
            if (i <= 8 ){
                drawCenteredRotatedString(graphics,String.valueOf(i),360,y,10,10,0);
                if (i == 8){
                    y=188;
                } else {
                    y=y-25;
                }
            } else if (i >= 26){
                drawCenteredRotatedString(graphics,String.valueOf(i),364,y,10,10,180);
                y=y-25;
            }
        }

        //Columna verde-rojo
        y=608;
        for (int i = 67; i >= 35; i--){
            if (i >= 60 ){
                drawCenteredRotatedString(graphics,String.valueOf(i),250,y,10,10,0);
                if (i == 60){
                    y=188;
                } else {
                    y=y-25;
                }
            } else if (i <= 42){
                drawCenteredRotatedString(graphics,String.valueOf(i),250,y,10,10,180);
                y=y-25;
            }
        }

        //Fila rojo-azul
        int x=5;
        for (int i = 50; i >= 18; i--){
            if (i >= 43){
                drawCenteredRotatedString(graphics, String.valueOf(i),x, 251, 10, 10, 90);
                if (i == 43){
                    x=430;
                } else {
                    x=x+25;
                }
            } else if (i <= 25){
                drawCenteredRotatedString(graphics, String.valueOf(i), x, 251, 10, 10, 270);
                x=x+25;
            }
        }

        //Fila verde-amarillo
        x=430;
        for (int i = 9; i <= 59; i++){
            if (i <= 16){
                drawCenteredRotatedString(graphics, String.valueOf(i),x, 365, 10, 10, 270);
                if (i == 16){
                    x=5;
                } else {
                    x=x+25;
                }
            } else if (i >= 52){
                drawCenteredRotatedString(graphics, String.valueOf(i), x, 365, 10, 10, 90);
                x=x+25;
            }
        }

        //Centros
        drawCenteredRotatedString(graphics, "17", 607,311, 10, 10, 270);
        drawCenteredRotatedString(graphics, "34", 311,9, 10, 10, 180);
        drawCenteredRotatedString(graphics, "51", 9,310, 10, 10, 90);
        drawCenteredRotatedString(graphics, "68", 309,607, 10, 10, 0);
    }

    public void orientation(boolean verticalOrientation){
        if (verticalOrientation){
            boxWidth = 92;
            boxHeight = 25;
        } else {
            boxWidth = 25;
            boxHeight = 92;
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
