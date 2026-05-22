package org.example;

public class GameLogic {
    private int diceValue;
    private int[] lastCell = {0,42,50,52,59,67,69,8,16,18,25,33,35};
    public GameLogic(){
        rollDice();
    }

    protected void rollDice(){
        diceValue = (int)(Math.random()*6)+1;
    }

    protected int getDiceValue(){
        return diceValue;
    }

    protected void movePiece(Piece piece){
        int z;
        switch (piece.getLocation()){
            case 0:
                if (piece.getColor() == 232){
                    piece.setX(212);
                    piece.setY(77);
                    piece.setLocation(1);
                }else if (piece.getColor() == 44){
                    piece.setX(527);
                    piece.setY(212);
                    piece.setLocation(10);
                }else if (piece.getColor() == 242){
                    piece.setX(395);
                    piece.setY(527);
                    piece.setLocation(7);
                }else {
                    piece.setX(77);
                    piece.setY(395);
                    piece.setLocation(4);
                }
                break;
            case 1:
                z = lastCell[piece.getLocation()]-(piece.getLocationPoint()+this.diceValue);
                if (z >= 0){
                    piece.setX(212);
                    piece.setY(piece.getY()+(25*this.diceValue));
                }else {
                    piece.setY(212);
                    piece.setX(piece.getX()-(25*(-z)+10));
                    piece.setLocation(piece.getLocation()+1);
                }
                piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                break;
            case 2:
                z = lastCell[piece.getLocation()]-(piece.getLocationPoint()+this.diceValue);
                if (z >= 0){
                    piece.setY(212);
                    piece.setX(piece.getX()-(25*this.diceValue));
                    piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                }else {
                    if (-z <= 2){
                        piece.setX(3);
                        piece.setY(piece.getY()+(92*(-z)));
                        piece.setLocation(piece.getLocation()+1);
                    }else {
                        piece.setY(395);
                        piece.setX(3+(25*(-z-2))-1);
                        piece.setLocation(piece.getLocation()+2);
                    }
                    piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                }
                break;
            case 3:
                z = lastCell[piece.getLocation()]-(piece.getLocationPoint()+this.diceValue);
                if (piece.getColor() == 42){
                    piece.setLocation(13);

                }else {
                    if (z >= 0){
                        piece.setY(piece.getY()+(92*this.diceValue));
                    }else {
                        piece.setY(395);
                        piece.setX(3+(25*(-z))-1);
                        piece.setLocation(piece.getLocation()+1);
                    }
                    piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                }
                break;
            case 4:
                z = lastCell[piece.getLocation()]-(piece.getLocationPoint()+this.diceValue);
                if (z >= 0){
                    piece.setX(piece.getX()+(25*this.diceValue));
                }else {
                    piece.setX(piece.getX()+(25*(z+this.diceValue+1))+10);
                    piece.setY(piece.getY()+(25*(-z))+7);
                    piece.setLocation(piece.getLocation()+1);
                }
                piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                break;
            case 5:
                z = lastCell[piece.getLocation()]-(piece.getLocationPoint()+this.diceValue);
                if (z >= 0){
                    piece.setY(piece.getY()+(25*this.diceValue));
                    piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                }else {
                    if (-z <= 2){
                        piece.setY(603);
                        piece.setX(piece.getX()+(92*(-z)));
                        piece.setLocation(piece.getLocation()+1);
                        piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                    }else {
                        piece.setX(395);
                        piece.setY(603-(25*(-z-2))-1);
                        piece.setLocation(piece.getLocation()+2);
                        piece.setLocationPoint(this.diceValue-(68-piece.getLocationPoint()));
                    }
                }
                break;
            case 6:
                z = lastCell[piece.getLocation()]-(piece.getLocationPoint()+this.diceValue);
                if (piece.getColor() == 242){
                    piece.setLocation(13);

                }else {
                    if (z >= 0){
                        piece.setX(piece.getX()+(92*this.diceValue));
                    }else {
                        piece.setX(395);
                        piece.setY(603-(25*(-z))-1);
                        piece.setLocation(piece.getLocation()+1);
                    }
                    piece.setLocationPoint(this.diceValue);
                }
                break;
            case 7:
                z = lastCell[piece.getLocation()]-(piece.getLocationPoint()+this.diceValue);
                if (z >= 0){
                    piece.setY(piece.getY()-(25*this.diceValue));
                }else {
                    piece.setY(piece.getY()-(25*(z+this.diceValue+1)+7));
                    piece.setX(piece.getX()+(25*(-z)+7));
                    piece.setLocation(piece.getLocation()+1);
                }
                piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                break;
            case  8:
                z = lastCell[piece.getLocation()]-(piece.getLocationPoint()+this.diceValue);
                if (z >= 0){
                    piece.setX(piece.getX()+(25*this.diceValue));
                    piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                }else {
                    if (-z <= 2){
                        piece.setX(603);
                        piece.setY(piece.getY()-(92*(-z)));
                        piece.setLocation(piece.getLocation()+1);
                    }else {
                        piece.setY(212);
                        piece.setX(603-(25*(-z-2))-1);
                        piece.setLocation(piece.getLocation()+2);
                    }
                    piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                }
                break;
            case 9:
                z = lastCell[piece.getLocation()]-(piece.getLocationPoint()+this.diceValue);
                if (piece.getColor() == 44){
                    piece.setLocation(13);

                }else {
                    if (z >= 0){
                        piece.setY(piece.getY()-(92*this.diceValue));
                    }else {
                        piece.setY(212);
                        piece.setX(603-(25*(-z))-1);
                        piece.setLocation(piece.getLocation()+1);
                    }
                    piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                }
                break;
            case 10:
                z = lastCell[piece.getLocation()]-(piece.getLocationPoint()+this.diceValue);
                if (z >= 0){
                    piece.setX(piece.getX()-(25*this.diceValue));
                }else {
                    piece.setX(piece.getX()-(25*(z+this.diceValue+1))-7);
                    piece.setY(piece.getY()-(25*(-z))-10);
                    piece.setLocation(piece.getLocation()+1);
                }
                piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                break;
            case 11:
                z = lastCell[piece.getLocation()]-(piece.getLocationPoint()+this.diceValue);
                if (z >= 0){
                    piece.setY(piece.getY()-(25*this.diceValue));
                    piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                }else {
                    if (-z <= 2){
                        piece.setY(3);
                        piece.setX(piece.getX()-(92*(-z)));
                        piece.setLocation(piece.getLocation()+1);
                        piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                    }else {
                        piece.setX(212);
                        piece.setY(3+(25*(-z-2))-1);
                        piece.setLocation(1);
                        piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                    }
                }
                break;
            case 12:
                z = lastCell[piece.getLocation()]-(piece.getLocationPoint()+this.diceValue);
                if (piece.getColor() == 232){
                    piece.setLocation(13);

                }else {
                    if (z >= 0){
                        piece.setX(piece.getX()-(92*this.diceValue));
                    }else {
                        piece.setX(212);
                        piece.setY(3+(25*(-z))-1);
                        piece.setLocation(1);
                    }
                    piece.setLocationPoint(piece.getLocationPoint()+this.diceValue);
                }
                break;
            case 13:
                if (piece.getColor() == 44){

                }else if (piece.getColor() == 232){

                }else if (piece.getColor() == 63){

                }else{
                    
                }
                break;
        }

    }


}
