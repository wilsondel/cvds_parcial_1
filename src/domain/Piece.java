package domain;

import javax.swing.*;
import java.awt.*;

public class Piece {
    private Color color;
    private int position;


    private String state="";
    private ImageIcon image;

    private int numberName;
    private String power = ""; // TODO: setear poder desde presentacion

    public Color getColor() {
        return color;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getPower() {
        return power;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumberName() {
        return numberName;
    }

    public Piece(Color color) {
        this.color = color;
        this.state = "";
    }

    public Piece(Color color, int numberName) {
        this.color = color;
        this.numberName = numberName;
        this.state = "";

    }

    public void move (int value){

    }

    public int getPosition(){
        return position;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

}
