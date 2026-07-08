package org.example;

public class GameLogic {
    private int diceValue;
    private int[] lastCell = {0, 42, 50, 52, 59, 67, 69, 8, 16, 18, 25, 33, 35};

    public GameLogic() {
        rollDice();
    }

    protected void rollDice() {
        diceValue = (int) (Math.random() * 6) + 1;
    }

    protected int getDiceValue() {
        return diceValue;
    }

    protected void getPieceNewCoordinates(Piece piece, Piece[] piecesList) {
        int z;
        switch (piece.getLocation()) {
            case 0:
                if (piece.getColor() == 232) {
                    piece.setLocation(1);
                    movePiece(piece, piecesList, 212, 77);
                } else if (piece.getColor() == 44) {
                    piece.setLocation(10);
                    movePiece(piece, piecesList, 527, 212);
                } else if (piece.getColor() == 242) {
                    piece.setLocation(7);
                    movePiece(piece, piecesList, 395, 527);
                } else {
                    piece.setLocation(4);
                    movePiece(piece, piecesList, 77, 395);
                }
                break;
            case 1:
                z = lastCell[piece.getLocation()] - (piece.getLocationPoint() + this.diceValue);
                if (z >= 0) {
                    movePiece(piece, piecesList, 212, piece.getY() + (25 * this.diceValue));
                } else {
                    piece.setLocation(piece.getLocation() + 1);
                    movePiece(piece, piecesList, piece.getX() - (25 * (-z) + 10), 212);
                }
                piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                break;
            case 2:
                z = lastCell[piece.getLocation()] - (piece.getLocationPoint() + this.diceValue);
                if (z >= 0) {
                    piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                    movePiece(piece, piecesList, piece.getX() - (25 * this.diceValue), 212);
                } else {
                    if (piece.getColor() == 42) {
                        piece.setLocation(13);
                        movePiece(piece, piecesList, 2 + (25 * (-z - 1)), 13);
                    } else {
                        if (-z <= 2) {
                            piece.setLocation(piece.getLocation() + 1);
                            piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                            movePiece(piece, piecesList, 3, piece.getY() + (92 * (-z)));
                        } else {
                            piece.setLocation(piece.getLocation() + 2);
                            piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                            movePiece(piece, piecesList, 3 + (25 * (-z - 2)) - 1, 395);
                        }
                    }
                }
                break;
            case 3:
                z = lastCell[piece.getLocation()] - (piece.getLocationPoint() + this.diceValue);
                if (piece.getColor() == 42) {
                    piece.setLocation(13);
                } else {
                    if (z >= 0) {
                        movePiece(piece, piecesList, piece.getX(), piece.getY() + (92 * this.diceValue));
                    } else {
                        piece.setLocation(piece.getLocation() + 1);
                        movePiece(piece, piecesList, 3 + (25 * (-z)) - 1, 395);
                    }
                    piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                }
                break;
            case 4:
                z = lastCell[piece.getLocation()] - (piece.getLocationPoint() + this.diceValue);
                if (z >= 0) {
                    movePiece(piece, piecesList, piece.getX() + (25 * this.diceValue), piece.getY());
                } else {
                    piece.setLocation(piece.getLocation() + 1);
                    movePiece(piece, piecesList, piece.getX() + (25 * (z + this.diceValue + 1)) + 10, piece.getY() + (25 * (-z)) + 7);
                }
                piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                break;
            case 5:
                z = lastCell[piece.getLocation()] - (piece.getLocationPoint() + this.diceValue);
                if (z >= 0) {
                    piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                    movePiece(piece, piecesList, piece.getX(), piece.getY() + (25 * this.diceValue));
                } else {
                    if (piece.getColor() == 242) {
                        piece.setLocation(13);
                        movePiece(piece, piecesList, 304, 602 - (25 * (-z - 1)));
                    } else {
                        if (-z < 2) {
                            piece.setLocation(piece.getLocation() + 1);
                            piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                            movePiece(piece, piecesList, piece.getX() + (92 * (-z)), 603);
                        } else {
                            piece.setLocation(piece.getLocation() + 2);
                            piece.setLocationPoint(this.diceValue - (68 - piece.getLocationPoint()));
                            movePiece(piece, piecesList, 395, 603 - (25 * (-z - 2)) - 1);
                        }
                    }
                }
                break;
            case 6:
                z = lastCell[piece.getLocation()] - (piece.getLocationPoint() + this.diceValue);
                if (piece.getColor() == 242) {
                    piece.setLocation(13);
                } else {
                    if (z >= 0) {
                        movePiece(piece, piecesList, piece.getX() + (92 * this.diceValue), piece.getY());
                    } else {
                        piece.setLocation(piece.getLocation() + 1);
                        movePiece(piece, piecesList, 395, 603 - (25 * (-z)) - 1);
                    }
                    piece.setLocationPoint(this.diceValue);
                }
                break;
            case 7:
                z = lastCell[piece.getLocation()] - (piece.getLocationPoint() + this.diceValue);
                if (z >= 0) {
                    movePiece(piece, piecesList, piece.getX(), piece.getY() - (25 * this.diceValue));
                } else {
                    piece.setLocation(piece.getLocation() + 1);
                    movePiece(piece, piecesList, piece.getX() + (25 * (-z) + 7), piece.getY() - (25 * (z + this.diceValue + 1) + 7));
                }
                piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                break;
            case 8:
                z = lastCell[piece.getLocation()] - (piece.getLocationPoint() + this.diceValue);
                if (z >= 0) {
                    piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                    movePiece(piece, piecesList, piece.getX() + (25 * this.diceValue), piece.getY());
                } else {
                    if (piece.getColor() == 44) {
                        piece.setLocation(13);
                        movePiece(piece, piecesList, 602 - (25 * (-z - 1)), 304);
                    } else {
                        if (-z <= 2) {
                            piece.setLocation(piece.getLocation() + 1);
                            piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                            movePiece(piece, piecesList, 603, piece.getY() - (92 * (-z)));
                        } else {
                            piece.setLocation(piece.getLocation() + 2);
                            piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                            movePiece(piece, piecesList, 603 - (25 * (-z - 2)) - 1, 212);
                        }
                    }
                }
                break;
            case 9:
                z = lastCell[piece.getLocation()] - (piece.getLocationPoint() + this.diceValue);
                if (piece.getColor() == 44) {
                    piece.setLocation(13);
                } else {
                    if (z >= 0) {
                        movePiece(piece, piecesList, piece.getX(), piece.getY() - (92 * this.diceValue));
                    } else {
                        piece.setLocation(piece.getLocation() + 1);
                        movePiece(piece, piecesList, 603 - (25 * (-z)) - 1, 212);
                    }
                    piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                }
                break;
            case 10:
                z = lastCell[piece.getLocation()] - (piece.getLocationPoint() + this.diceValue);
                if (z >= 0) {
                    movePiece(piece, piecesList, piece.getX() - (25 * this.diceValue), piece.getY());
                } else {
                    piece.setLocation(piece.getLocation() + 1);
                    movePiece(piece, piecesList, piece.getX() - (25 * (z + this.diceValue + 1)) - 7, piece.getY() - (25 * (-z)) - 10);
                }
                piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                break;
            case 11:
                z = lastCell[piece.getLocation()] - (piece.getLocationPoint() + this.diceValue);
                if (z >= 0) {
                    piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                    movePiece(piece, piecesList, piece.getX(), piece.getY() - (25 * this.diceValue));
                } else {
                    if (piece.getColor() == 232) {
                        piece.setLocation(13);
                        movePiece(piece, piecesList, 304, 2 + (25 * (-z - 1)));
                    } else {
                        if (-z <= 2) {
                            piece.setLocation(piece.getLocation() + 1);
                            piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                            movePiece(piece, piecesList, piece.getX() - (92 * (-z)), 3);
                        } else {
                            piece.setLocation(1);
                            piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                            movePiece(piece, piecesList, 212, 3 + (25 * (-z - 2)) - 1);
                        }
                    }
                }
                break;
            case 12:
                z = lastCell[piece.getLocation()] - (piece.getLocationPoint() + this.diceValue);
                if (piece.getColor() == 232) {
                    piece.setLocation(13);
                } else {
                    if (z >= 0) {
                        movePiece(piece, piecesList, piece.getX() - (92 * this.diceValue), piece.getY());
                    } else {
                        piece.setLocation(1);
                        movePiece(piece, piecesList, 212, 3 + (25 * (-z)) - 1);
                    }
                    piece.setLocationPoint(piece.getLocationPoint() + this.diceValue);
                }
                break;
            case 13:
                if (piece.getColor() == 232) {
                    if (piece.getY() < 25 * 8) {
                        movePiece(piece, piecesList, piece.getX(), piece.getY() + (25 * this.diceValue));
                    } else {

                    }
                } else if (piece.getColor() == 44) {
                    if (piece.getX() > 25 * 8) {
                        movePiece(piece, piecesList, piece.getX() - (25 * this.diceValue), piece.getY());
                    } else {

                    }
                } else if (piece.getColor() == 242) {
                    if (piece.getY() > 25 * 8) {
                        movePiece(piece, piecesList, piece.getX(), piece.getY() - (25 * this.diceValue));
                    } else {

                    }
                } else {
                    if (piece.getX() < 25 * 8) {
                        movePiece(piece, piecesList, piece.getX() + (25 * this.diceValue), piece.getY());
                    } else {

                    }
                }
                break;
        }
    }

    private void movePiece(Piece piece, Piece[] piecesList, int x, int y) {
        //Avanzo normal
        piece.setX(x);
        piece.setY(y);

        //Comprobar si hay otra pieza en su próximo celda
        Piece pieceInCell = null;
        pieceInCell = lookForPieceInCell(piece, piecesList);
        System.out.println(pieceInCell);

        //Comprobar si ya estaba compartiendo celda
        if (piece.getSharingCellStatus()) {
            //Si está compartiendo celda, volver a la posición central
            backToCenter(piece, piece.getPieceSharingWith(), x, y);
        }

        if (pieceInCell != null) {
            alreadyPieceInCell(piece, pieceInCell);
        }else {
            System.out.println("No hay nadie aqui");
        }


    }

    private void alreadyPieceInCell(Piece piece, Piece pieceInCell) {
        if (pieceInCell.getX() == piece.getX() && pieceInCell.getY() == piece.getY() && piece.getId() != pieceInCell.getId()) {
            piece.setPieceSharingWith(pieceInCell);
            pieceInCell.setPieceSharingWith(piece);
            System.out.println("Hay alguien aqui");
            if (piece.getLocation() == 1 || piece.getLocation() == 5 || piece.getLocation() == 6 || piece.getLocation() == 7 || piece.getLocation() == 11 || piece.getLocation() == 12) {
                System.out.println("Me muevo la X");
                piece.setOldX(piece.getX());
                pieceInCell.setOldX(pieceInCell.getX());
                piece.setX(piece.getX() + 15);
                pieceInCell.setX(pieceInCell.getX() - 15);
            } else if (piece.getLocation() == 2 || piece.getLocation() == 3 || piece.getLocation() == 4 || piece.getLocation() == 8 || piece.getLocation() == 9 || piece.getLocation() == 10) {
                System.out.println("Me muevo la Y");
                piece.setOldY(piece.getY());
                pieceInCell.setOldY(pieceInCell.getY());
                piece.setY(piece.getY() + 15);
                pieceInCell.setY(pieceInCell.getY() - 15);
            }
            piece.setSharingCellStatus(true);
            pieceInCell.setSharingCellStatus(true);
        }
    }

    private Piece lookForPieceInCell(Piece piece, Piece[] piecesList) {
        Piece pieceInCell = null;
        for (int i = 0; i < piecesList.length; i++) {
            if (piecesList[i].getX() == piece.getX() && piecesList[i].getY() == piece.getY() && piece.getId() != piecesList[i].getId()) {
                pieceInCell = piecesList[i];
            }
        }
        return pieceInCell;
    }


    private void backToCenter(Piece piece, Piece pieceInCell, int x, int y) {
        if (piece.getLocation() == 1 || piece.getLocation() == 5 || piece.getLocation() == 6 || piece.getLocation() == 7 || piece.getLocation() == 11 || piece.getLocation() == 12) {
            System.out.println("Vuelvo a mi X");
            piece.setX(piece.getOldX());
            piece.setY(y);
            piece.getPieceSharingWith().setX(piece.getPieceSharingWith().getOldX());
            piece.setSharingCellStatus(false);
        } else if (piece.getLocation() == 2 || piece.getLocation() == 3 || piece.getLocation() == 4 || piece.getLocation() == 8 || piece.getLocation() == 9 || piece.getLocation() == 10) {
            System.out.println("Vuelvo a mi Y");
            piece.setX(x);
            piece.setY(piece.getOldY());
            piece.getPieceSharingWith().setY(piece.getPieceSharingWith().getOldY());
            piece.setSharingCellStatus(false);
        }
    }
}
/*
Corregir la vuelta a la posición central al pasar por esquinas
 */
