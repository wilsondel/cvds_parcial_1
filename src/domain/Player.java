package domain;

import java.util.ArrayList;

public class Player {
    private Dice dice;
    private String color;
    private Piece[] pieces;
    private String name; // TODO: modificar y validar name


    public Player(String name) {
        dice = new Dice();
        pieces = new Piece[4];
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int[] getValueDice() {
        int val1 = dice.rollDice();
        int val2 = dice.rollDice();
        int[] dices = {val1,val2};
        return dices;
    }



}
