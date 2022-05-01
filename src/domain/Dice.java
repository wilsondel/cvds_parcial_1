package domain;

public class Dice {
    private int value;
    private String imageLocation;

    public int getValue() {
        return value;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public Dice(){
        value = 0;
        imageLocation="images/dices/design.png";
    }

    public int rollDice(){
        int randomNum = 1 + (int)(Math.random() * ((6 - 1) + 1));
        value = randomNum;
        return randomNum;
    }

}
