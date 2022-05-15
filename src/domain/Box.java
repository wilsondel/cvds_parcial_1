package domain;

import java.awt.*;
import java.util.ArrayList;

public class Box {
    public static int positionNumber=0;
    private String state;
    private int positionNumberBox;
    private ArrayList<Piece> pieces;
    private Color color;

    public Box(){
        color = Color.white;
        pieces = new ArrayList<Piece>(2);
        state = "";
        positionNumberBox =positionNumber++;
    }
    public Box(Color color){
        this.color = color;
        pieces = new ArrayList<Piece>(2);
        state = "";

    }

    public Color getColorPiece(){
        Color colorPiece = color;
        if (pieces.size() == 1) {
            colorPiece = pieces.get(0).getColor();
        }
        return colorPiece;
    }

    public int getPieceNumber(){
        int numberPiece=0;
        if( pieces.size()==1 ){
            numberPiece = pieces.get(0).getNumberName();
        }
        return numberPiece;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public Color getColor() {
        return color;
    }

    public String getState() {
        return state;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isBlocked(){
        return false;
    }

    public boolean isSafe(){
        return false;
    }

    public boolean isHomeway(){
        return false;
    }

    public boolean isSuccess(){
        return false;
    }

    public void eat(){}

    public void addPiece(Piece piece){
        if (piece != null) {
            pieces.add(piece);
            refreshState();
        }
    }

    public void addPiece(Piece[] piece){
        for (Piece p : piece) {
            addPiece(p);
        }
        refreshState();

    }

    public void removePiece(Piece piece){
        pieces.remove(piece);
        refreshState();
    }

    public void removePiece(){
        pieces.clear();
        refreshState();
    }

    public void refreshState() {
        if (pieces.size()==0) state = "";
        else if (pieces.size() > 0) state = "1";
    }

    public ArrayList<Integer> lookPieces() {
        ArrayList<Integer> numberNames = new ArrayList<Integer>();
        for (Piece p : pieces) {
            numberNames.add(p.getNumberName());
        }
        return numberNames;
    }

    public Piece pieceReference(int numberName) {
        boolean flag = true;
        Piece pieceReference = null;
        for (int i = 0; i < pieces.size() && flag; i++ ) {
            if (pieces.get(i).getNumberName() == numberName ) {
                pieceReference = pieces.get(i);
                flag = false;
            }
        }
//        if (pieceReference != null) pieceReference.setColor(Color.CYAN); // TODO: quitar esto
        return pieceReference;
    }

}
