package domain;

import java.awt.*;
import java.util.ArrayList;

public class Box {
    private int state;
    private int positionNumber;
    private Piece[] pieces;
    private Color color;

    public Box(){
        color = Color.white;
        pieces = new Piece[2];
    }
    public Box(Color color){
        this.color = color;
        pieces = new Piece[2];
    }

    public Color getColor() {
        return color;
    }

    public int getState() {
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

}
