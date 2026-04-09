package org.example;

import java.awt.*;

public class Board {
    Color myRed = new Color(222, 126, 113);
    Color myBlue = new Color(81, 83, 224);
    Color myGreen = new Color(118, 214, 118);
    Color myYellow = new Color(240, 233, 127);
    int[] xred={201,426,313};
    int[] yred={201,200,313};
    int[] xblue={425,425,313};
    int[] yblue={201,425,313};
    int[] xgreen={201,201,313};
    int[] ygreen={201,426,313};
    int[] xyellow={201,425,313};
    int[] yyellow={425,425,313};
    private int boxWidth;
    private int boxHeight;
    private int houseRectSize = 175;
    private int houseBigOvalSize = 125;
    private int houseSmallOvalSize = 75;
    private ColorHouse redHouse, blueHouse, greenHouse, yellowHouse;

    public Board(){
        redHouse = new ColorHouse(myRed, 0,0, xred, yred, 25,true);
        blueHouse = new ColorHouse(myBlue, 451,0, xblue, yblue, 425, false);
        greenHouse = new ColorHouse(myGreen, 0,451, xgreen, ygreen,25, false);
        yellowHouse = new ColorHouse(myYellow, 451,451, xyellow, yyellow, 425, true);
    }

    public void drawBoard(Graphics2D graphics){
        drawWhiteSquares(graphics);
        drawColorHouses(graphics);
        drawCenter(graphics);
        assignNumbers(graphics);
        drawSavePoints(graphics);
    }

    //Dibuja la casa de cada color - cuadrado sin fondo y circulo. Y los colores del centro del tablero
    private void drawColorHouses(Graphics2D graphics){
        redHouse.drawColorHouses(graphics);
        blueHouse.drawColorHouses(graphics);
        greenHouse.drawColorHouses(graphics);
        yellowHouse.drawColorHouses(graphics);
    }

    //Dibuja las lineas negras del centro del tablero
    private void drawCenter(Graphics graphics){
        graphics.setColor(Color.black);
        graphics.drawRect(200,200,225,225);
        graphics.drawLine(175,175,451,451);
        graphics.drawLine(451,175,175,451);
    }

    //Dibuja las casillas blancas normales (también crea las de los pasillos de colores, sin color)
    private void drawWhiteSquares(Graphics2D graphics){
        orientation(true);
        for (int i = 175; i < 451; i = i+boxWidth){
            for (int j = 0; j < 610; j = j+boxHeight){
                if (j < 175 || j >= 450){
                    new Cell(i,j,true).drawCell(graphics);
                }
            }
        }
        orientation(false);
        for (int i = 0; i < 610; i = i+boxWidth){
            for (int j = 175; j < 451; j = j+boxHeight){
                if (i < 175 || i >= 450){
                    new Cell(i,j,false).drawCell(graphics);
                }
            }
        }
    }

    private void assignNumbers(Graphics2D graphics){
        graphics.setFont(new Font("Arial", Font.PLAIN, 16));

        //Columna amarillo-azul
        int y=608;
        for (int i = 1; i <= 33; i++){
            if (i <= 8 ){
                GraphicsUtils.drawCenteredRotatedString(graphics, String.valueOf(i), 360, y, 10, 10, 0);
                if (i == 8){
                    y=188;
                } else {
                    y=y-25;
                }
            } else if (i >= 26){
                GraphicsUtils.drawCenteredRotatedString(graphics,String.valueOf(i),364,y,10,10,180);
                y=y-25;
            }
        }

        //Columna verde-rojo
        y=608;
        for (int i = 67; i >= 35; i--){
            if (i >= 60 ){
                GraphicsUtils.drawCenteredRotatedString(graphics,String.valueOf(i),250,y,10,10,0);
                if (i == 60){
                    y=188;
                } else {
                    y=y-25;
                }
            } else if (i <= 42){
                GraphicsUtils.drawCenteredRotatedString(graphics,String.valueOf(i),250,y,10,10,180);
                y=y-25;
            }
        }

        //Fila rojo-azul
        int x=5;
        for (int i = 50; i >= 18; i--){
            if (i >= 43){
                GraphicsUtils.drawCenteredRotatedString(graphics, String.valueOf(i),x, 251, 10, 10, 90);
                if (i == 43){
                    x=430;
                } else {
                    x=x+25;
                }
            } else if (i <= 25){
                GraphicsUtils.drawCenteredRotatedString(graphics, String.valueOf(i), x, 251, 10, 10, 270);
                x=x+25;
            }
        }

        //Fila verde-amarillo
        x=430;
        for (int i = 9; i <= 59; i++){
            if (i <= 16){
                GraphicsUtils.drawCenteredRotatedString(graphics, String.valueOf(i),x, 365, 10, 10, 270);
                if (i == 16){
                    x=5;
                } else {
                    x=x+25;
                }
            } else if (i >= 52){
                GraphicsUtils.drawCenteredRotatedString(graphics, String.valueOf(i), x, 365, 10, 10, 90);
                x=x+25;
            }
        }

        //Centros
        GraphicsUtils.drawCenteredRotatedString(graphics, "17", 607,311, 10, 10, 270);
        GraphicsUtils.drawCenteredRotatedString(graphics, "34", 311,9, 10, 10, 180);
        GraphicsUtils.drawCenteredRotatedString(graphics, "51", 9,310, 10, 10, 90);
        GraphicsUtils.drawCenteredRotatedString(graphics, "68", 309,607, 10, 10, 0);
    }

    //Dibuja los circulos de seguridad
    private void drawSavePoints(Graphics2D gr){
        gr.setColor(Color.black);
        gr.drawOval(304,2,22,22);
        gr.drawOval(396,77,22,22);
        gr.drawOval(602,304,22,22);
        gr.drawOval(527,396,22,22);
        gr.drawOval(2,303,22,22);
        gr.drawOval(77,211,22,22);
        gr.drawOval(303,602,22,22);
        gr.drawOval(211,527,22,22);
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
