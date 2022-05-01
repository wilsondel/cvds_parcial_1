package domain;

import java.awt.*;

public class Board {
    // Boxes
    private Box[] boxes;
    private Safe[] safes;
    private HomeWay[] homeWays;
    private Success[] successes;

    //
    private Box[][] completeMatrix;

    // COLORS
    private Color blueHome = new Color(0x805FF2EE,true);
    private Color redHome = new Color(0x80FF1616,true);
    private Color greenHome = new Color(0x807FB95F,true);
    private Color yellowHome = new Color(0x80F9A72B,true);
    private Color grayBox = new Color(0xBF66635B,true);

    public Board(){
        boxes = new Box[56];
        safes = new Safe[12];
        homeWays = new HomeWay[28];
        successes = new Success[4];
        completeMatrix = new Box[20][20];

    }

    public Box[][] getCompleteMatrix() {
        return completeMatrix;
    }

    public Box[][] buildMatrix() {
//        for (int i = 0; i < 20; i++){
//            for (int j = 0; j<20;i++){
//                completeMatrix[i][j] = new Box();
//            }
//        }
        blueBase(blueHome);
        yellowBase(yellowHome);
        greenBase(greenHome);
        redBase(redHome);
        safeBox(grayBox);
        successBox(grayBox);

        return completeMatrix;
    }

    private void blueBase(Color colorBox){
        for (int i = 0; i < 7; i++){
            for (int j = 0; j<7;j++){
                completeMatrix[i][j] = new Box(colorBox);
            }
        }
        completeMatrix[4][7] = new Box(colorBox);
        completeMatrix[4][8] = new Box(colorBox);
        for (int i = 1; i <= 6; i++){
            for (int j = 9; j<= 10;j++){
                completeMatrix[i][j] = new Box(colorBox);
            }
        }

    }

    private void yellowBase(Color colorBox){
        for (int i = 0; i <7; i++){
            for (int j = 13; j<20;j++){
                completeMatrix[i][j] = new Box(colorBox);
            }
        }
        completeMatrix[7][15] = new Box(colorBox);
        completeMatrix[8][15] = new Box(colorBox);

        for (int i = 9; i <= 10; i++){
            for (int j = 13; j< 19;j++){
                completeMatrix[i][j] = new Box(colorBox);
            }
        }

    }

    private void greenBase(Color colorBox){
        for (int i = 13; i <20; i++){
            for (int j = 13; j<20;j++){
                completeMatrix[i][j] = new Box(colorBox);
            }
        }
        completeMatrix[15][12] = new Box(colorBox);
        completeMatrix[15][11] = new Box(colorBox);

        for (int i = 13; i < 19; i++){
            for (int j = 9; j<= 10;j++){
                completeMatrix[i][j] = new Box(colorBox);
            }
        }

    }
    private void redBase(Color colorBox){
        for (int i = 13; i <20; i++){
            for (int j = 0; j<7;j++){
                completeMatrix[i][j] = new Box(colorBox);
            }
        }
        completeMatrix[11][4] = new Box(colorBox);
        completeMatrix[12][4] = new Box(colorBox);

        for (int i = 9; i <= 10; i++){
            for (int j = 1; j<= 6;j++){
                completeMatrix[i][j] = new Box(colorBox);
            }
        }

    }

    private void safeBox(Color colorBox){
        completeMatrix[0][9] = new Box(colorBox);
        completeMatrix[0][10] = new Box(colorBox);
        completeMatrix[4][11] = new Box(colorBox);
        completeMatrix[4][12] = new Box(colorBox);
        completeMatrix[9][19] = new Box(colorBox);
        completeMatrix[10][19] = new Box(colorBox);
        completeMatrix[11][15] = new Box(colorBox);
        completeMatrix[12][15] = new Box(colorBox);
        completeMatrix[19][9] = new Box(colorBox);
        completeMatrix[19][10] = new Box(colorBox);
        completeMatrix[15][7] = new Box(colorBox);
        completeMatrix[15][8] = new Box(colorBox);
        completeMatrix[9][0] = new Box(colorBox);
        completeMatrix[10][0] = new Box(colorBox);
        completeMatrix[7][4] = new Box(colorBox);
        completeMatrix[8][4] = new Box(colorBox);
    }

    private void successBox(Color colorBox){
        //red
        completeMatrix[9][7] = new Box(colorBox);
        completeMatrix[9][8] = new Box(colorBox);
        completeMatrix[10][7] = new Box(colorBox);
        completeMatrix[10][8] = new Box(colorBox);
        // green
        completeMatrix[9][11] = new Box(colorBox);
        completeMatrix[10][11] = new Box(colorBox);
        completeMatrix[9][12] = new Box(colorBox);
        completeMatrix[10][12] = new Box(colorBox);
        //yellow
        completeMatrix[11][9] = new Box(colorBox);
        completeMatrix[11][10] = new Box(colorBox);
        completeMatrix[12][9] = new Box(colorBox);
        completeMatrix[12][10] = new Box(colorBox);
        //blue
        completeMatrix[7][9] = new Box(colorBox);
        completeMatrix[8][9] = new Box(colorBox);
        completeMatrix[7][10] = new Box(colorBox);
        completeMatrix[8][10] = new Box(colorBox);

    }


    public void refresh() {}

}
