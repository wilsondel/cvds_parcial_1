package domain;

import javax.swing.*;
import java.awt.*;

public class Piece {
    private Color color;
    private int position;
    private String state;
    private ImageIcon image;
    private int numberName;

    public Color getColor() {
        return color;
    }

    public int getNumberName() {
        return numberName;
    }

    public Piece(Color color) {
        this.color = color;
    }

    public Piece(Color color, int numberName) {
        this.color = color;
        this.numberName = numberName;
    }

    public void move (int value){

    }

    public int getPosition(){
        return position;
    }

}
