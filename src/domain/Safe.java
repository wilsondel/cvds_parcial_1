package domain;

import java.awt.*;
import java.util.ArrayList;

public class Safe extends Box{
    public Safe() {
        super();
    }
    public Safe(Color color) {
        super(color);
    }


    public Piece[] outBase(String caseDice){
        ArrayList<Integer> numberNames = super.lookPieces();
        int pieceNum1,pieceNum2;
        if (caseDice.equals("1")) {
            if (numberNames.size() >= 2) {
                numberNames.stream().sorted();
                pieceNum1 = numberNames.get(0);
                pieceNum2 = numberNames.get(1);
                // Delete from box using the reference
                Piece[] pieces = {super.pieceReference(pieceNum1),super.pieceReference(pieceNum2)};
                super.removePiece( pieces[0] );
                super.removePiece( pieces[1] );
                return pieces;
            }
        } else if (caseDice.equals("2")) {
            if (numberNames.size() >= 1) {
                numberNames.stream().sorted();
                pieceNum1 = numberNames.get(0);
                // Delete from box using the reference
                Piece[] pieces = {super.pieceReference(pieceNum1)};
                super.removePiece( pieces[0] );
                return pieces;
            }
        }
        return  null;
    }
}
