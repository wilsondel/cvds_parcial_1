package domain;

public class Player {
    private Dice dice;
    private String color;

    public Player() {
        dice = new Dice();
    }

    public int[] getValueDice() {
        int val1 = dice.rollDice();
        int val2 = dice.rollDice();
        int[] dices = {val1,val2};
        return dices;
    }


}
