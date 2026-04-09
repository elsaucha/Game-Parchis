package org.example;

public class GameLogic {
    private int diceValue;
    public GameLogic(){
        rollDice();
    }

    protected void rollDice(){
        diceValue = (int)(Math.random()*6)+1;
        System.out.println(diceValue);
    }

    protected int getDiceValue(){
        return diceValue;
    }
}
