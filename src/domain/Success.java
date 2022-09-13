package domain;

import java.awt.*;

public class Success extends Box{
    private int amountPieces;
    public Success() {
        super();
        amountPieces = 0;
    }
    public Success(Color color) {
        super(color);
    }

    public int getAmountPieces() {
        return amountPieces;
    }

    public void setAmountPieces(int amountPieces) {
        this.amountPieces = amountPieces;
    }
}
