package org.example;

import javax.swing.*;
import java.awt.*;

public class Dice {
    protected Image[] diceImages = new Image[6];
    public Dice(){
        laodDiceImages();
    }
    protected void laodDiceImages(){
        for (int i=0; i<6; i++){
            diceImages[i] = new ImageIcon(getClass().getResource("/dice/dice"+(i+1)+".png")).getImage();
        }
    }
}
