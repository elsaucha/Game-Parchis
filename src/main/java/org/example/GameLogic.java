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

    protected void getPieceNewCoordinates(Piece piece, Piece[] piecesList){
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
                    if (piece.getColor() == 42) {
                        piece.setX(2+(25*(-z-1)));
                        piece.setY(304);
                        piece.setLocation(13);
                    }else {
                        if (-z <= 2) {
                            piece.setX(3);
                            piece.setY(piece.getY() + (92 * (-z)));
                            piece.setLocation(piece.getLocation() + 1);
                            piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                        } else {
                            piece.setY(395);
                            piece.setX(3 + (25 * (-z - 2)) - 1);
                            piece.setLocation(piece.getLocation() + 2);
                            piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                        }
                    }
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
                    if (piece.getColor() == 242) {
                        piece.setX(304);
                        piece.setY(602-(25*(-z-1)));
                        piece.setLocation(13);
                    }else {
                        if (-z < 2) {
                            piece.setY(603);
                            piece.setX(piece.getX() + (92 * (-z)));
                            piece.setLocation(piece.getLocation() + 1);
                            piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                        } else {
                            piece.setX(395);
                            piece.setY(603 - (25 * (-z - 2)) - 1);
                            piece.setLocation(piece.getLocation() + 2);
                            piece.setLocationPoint(this.diceValue - (68 - piece.getLocationPoint()));
                        }
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
                    if (piece.getColor() == 44) {
                        piece.setX(602-(25*(-z-1)));
                        piece.setY(304);
                        piece.setLocation(13);
                    }else {
                        if (-z <= 2) {
                            piece.setX(603);
                            piece.setY(piece.getY() - (92 * (-z)));
                            piece.setLocation(piece.getLocation() + 1);
                            piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                        } else {
                            piece.setY(212);
                            piece.setX(603 - (25 * (-z - 2)) - 1);
                            piece.setLocation(piece.getLocation() + 2);
                            piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                        }
                    }
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
                    if (piece.getColor() == 232) {
                        piece.setX(304);
                        piece.setY(2+(25*(-z-1)));
                        piece.setLocation(13);
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
                if (piece.getColor() == 232){
                    if (piece.getY() < 25*8){
                        piece.setY(piece.getY()+(25*this.diceValue));
                    }else {

                    }
                }else if (piece.getColor() == 44){
                    if (piece.getX() > 25*8){
                        piece.setX(piece.getX()-(25*this.diceValue));
                    }else {

                    }
                }else if (piece.getColor() == 242){
                    if (piece.getY() > 25*8){
                        piece.setY(piece.getY()-(25*this.diceValue));
                    }else {

                    }
                }else {
                    if (piece.getX() < 25*8){
                        piece.setX(piece.getX()+(25*this.diceValue));
                    }else {

                    }
                }
                break;
        }
        isAlreadyPieceInCell(piece, piecesList);
    }

    private void isAlreadyPieceInCell(Piece piece, Piece[] piecesList){
        for (int i = 0; i < piecesList.length; i++){
            if (piecesList[i].getX() == piece.getX() && piecesList[i].getY() == piece.getY()){
                if (piece.getLocation() == 1 || piece.getLocation() == 5 || piece.getLocation() == 6 || piece.getLocation() == 7 || piece.getLocation() == 11 || piece.getLocation() == 12){
                    piece.setX(piece.getX()+15);
                    piecesList[i].setX(piecesList[i].getX()-15);
                }else if(piece.getLocation() == 2 || piece.getLocation() == 3 || piece.getLocation() == 4 || piece.getLocation() == 8 || piece.getLocation() == 9 || piece.getLocation() == 10){
                    piece.setY(piece.getY()+15);
                    piecesList[i].setY(piecesList[i].getY()-15);
                }
                piece.setStatus(true);
                piecesList[i].setStatus(true);
            }
        }
    }

    private void setPieceNewCoordinates(){

    }

}

//en getPieceNewCoordinates llamar a setPieceNewCoordinates para hacer setX y setY.
//en setPieceNewCoordinates comprobar el estado de sharingCell llamando a piece.getStatus(). si es true, mover las piezas en 15