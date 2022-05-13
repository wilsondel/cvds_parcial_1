package domain;

import com.sun.xml.internal.ws.model.wsdl.WSDLOutputImpl;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    // Boxes
    private Box[] boxes;
    private Safe[] safes;
    private HomeWay[] homeWays;
    private Success[] successes;

    //
    private Box[][] completeMatrix;

    // COLORS
    private Color blueHome = new Color(0xBF5FF2EE,true);
    private Color redHome = new Color(0xBFFF1616,true);
    private Color greenHome = new Color(0xBF81F141,true);
    private Color yellowHome = new Color(0xBFF9A72B,true);
    private Color grayBox = new Color(0xBF66635B,true);

    // List boxes
    private ArrayList<Box> mainBoxes;
    private Safe baseP1;
    private Safe baseP2;

    // Boxes position domain
    //private int[][][] boxesPosition;


    public Board(){
        boxes = new Box[56];
        safes = new Safe[12];
        homeWays = new HomeWay[28];
        successes = new Success[4];
        completeMatrix = new Box[20][20];
        for(int i = 0; i < completeMatrix.length;i++){
            for(int j = 0; j < completeMatrix.length;j++){
                completeMatrix[i][j] = new Box();
            }
        }
        mainBoxes = new  ArrayList<Box>(68);
        for (int i = 0; i < 68;i++){
            mainBoxes.add(new Box());
        }
        baseP1 = new Safe();
        baseP2 = new Safe();
        int[] namesP1 = {1,2,3,4};
        int[] namesP2 = {4,5,6,7};
        initialBase(baseP1,redHome,namesP1);
        initialBase(baseP2,blueHome,namesP2);

    }

    public void initialBase(Safe base, Color color, int[] names) {
        base.addPiece(new Piece(color,names[0]));
        base.addPiece(new Piece(color,names[1]));
        base.addPiece(new Piece(color,names[2]));
        base.addPiece(new Piece(color,names[3]));
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
                completeMatrix[i][j] = new Safe(colorBox);
            }
        }
        completeMatrix[4][7] = new Safe(colorBox);
        completeMatrix[4][8] = new Safe(colorBox);
        for (int i = 1; i <= 6; i++){
            for (int j = 9; j<= 10;j++){
                completeMatrix[i][j] = new HomeWay(colorBox);
            }
        }

    }

    private void yellowBase(Color colorBox){
        for (int i = 0; i <7; i++){
            for (int j = 13; j<20;j++){
                completeMatrix[i][j] = new Safe(colorBox);
            }
        }
        completeMatrix[7][15] = new Safe(colorBox);
        completeMatrix[8][15] = new Safe(colorBox);

        for (int i = 9; i <= 10; i++){
            for (int j = 13; j< 19;j++){
                completeMatrix[i][j] = new HomeWay(colorBox);
            }
        }
        int[][] position = { {1,14},{1,18},{5,14},{5,18} };
        addPiecesBase( position,yellowHome);

    }

    private void greenBase(Color colorBox){
        for (int i = 13; i <20; i++){
            for (int j = 13; j<20;j++){
                completeMatrix[i][j] = new Safe(colorBox);
            }
        }
        completeMatrix[15][12] = new Safe(colorBox);
        completeMatrix[15][11] = new Safe(colorBox);

        for (int i = 13; i < 19; i++){
            for (int j = 9; j<= 10;j++){
                completeMatrix[i][j] = new HomeWay(colorBox);
            }
        }

    }
    private void redBase(Color colorBox){
        for (int i = 13; i <20; i++){
            for (int j = 0; j<7;j++){
                completeMatrix[i][j] = new Safe(colorBox);
            }
        }
        completeMatrix[11][4] = new Safe(colorBox);
        completeMatrix[12][4] = new Safe(colorBox);

        for (int i = 9; i <= 10; i++){
            for (int j = 1; j<= 6;j++){
                completeMatrix[i][j] = new HomeWay(colorBox);
            }
        }
        int[][] position = { {14,1},{14,5},{18,1},{18,5} };
        addPiecesBase( position,redHome);
    }

    private void addPiecesBase(int[][] position, Color colorPiece){
        for (int[] pos : position){
            completeMatrix[pos[0]][pos[1]].addPiece(new Piece(colorPiece));
        }
    }

    private void safeBox(Color colorBox){
        completeMatrix[0][9] = new Safe(colorBox);
        completeMatrix[0][10] = new Safe(colorBox);
        completeMatrix[4][11] = new Safe(colorBox);
        completeMatrix[4][12] = new Safe(colorBox);
        completeMatrix[9][19] = new Safe(colorBox);
        completeMatrix[10][19] = new Safe(colorBox);
        completeMatrix[11][15] = new Safe(colorBox);
        completeMatrix[12][15] = new Safe(colorBox);
        completeMatrix[19][9] = new Safe(colorBox);
        completeMatrix[19][10] = new Safe(colorBox);
        completeMatrix[15][7] = new Safe(colorBox);
        completeMatrix[15][8] = new Safe(colorBox);
        completeMatrix[9][0] = new Safe(colorBox);
        completeMatrix[10][0] = new Safe(colorBox);
        completeMatrix[7][4] = new Safe(colorBox);
        completeMatrix[8][4] = new Safe(colorBox);
    }

    private void successBox(Color colorBox){
        //red
        completeMatrix[9][7] = new Success(colorBox);
        completeMatrix[9][8] = new Success(colorBox);
        completeMatrix[10][7] = new Success(colorBox);
        completeMatrix[10][8] = new Success(colorBox);
        // green
        completeMatrix[9][11] = new Success(colorBox);
        completeMatrix[10][11] = new Success(colorBox);
        completeMatrix[9][12] = new Success(colorBox);
        completeMatrix[10][12] = new Success(colorBox);
        //yellow
        completeMatrix[11][9] = new Success(colorBox);
        completeMatrix[11][10] = new Success(colorBox);
        completeMatrix[12][9] = new Success(colorBox);
        completeMatrix[12][10] = new Success(colorBox);
        //blue
        completeMatrix[7][9] = new Success(colorBox);
        completeMatrix[8][9] = new Success(colorBox);
        completeMatrix[7][10] = new Success(colorBox);
        completeMatrix[8][10] = new Success(colorBox);

    }


    public void evaluateBox(int[] result, Player player,int numberName) {
//        mainBoxes
        // Base validation
        validateOutBase(result,player.getName());
        // Box validation
        validateNormalBox(result[0],player.getName(),numberName); // TODO: cambiar valor por 1 solo dado :(

    }

    public void validateOutBase(int[] result, String player){
        int amountPieces;
        if (player.equals("P1") || true) {
            amountPieces = baseP1.getPieces().size();
            if (amountPieces > 0) outBase(result,player);
        }
    }

    public void outBase(int[] result, String player) {
        int totalDiceSum = result[0] + result[1];
        if (player.equals("P1") || true) {
            if (result[0] == 5 && result[1] == 5) {
                mainBoxes.get(0).addPiece(baseP1.outBase("1"));
            } else if (result[0] == 5 || result[1] == 5 || totalDiceSum == 5) {
                mainBoxes.get(0).addPiece(baseP1.outBase("2"));
            }
            if (mainBoxes.get(0).getPieces().size()>=1){
                completeMatrix[11][4].addPiece(mainBoxes.get(0).getPieces().get(0));
                completeMatrix[14][1].removePiece();
//                completeMatrix[12][4].addPiece(mainBoxes.get(0).getPieces().get(1));
            }

        }
    }

    public void validateNormalBox(int result, String player,int numberName) {
        result=1; // TODO: quitar esto :(
        movePiece(result,player,numberName);
    }

    public void movePiece(int result, String player,int numberName){
        boolean flag = true;
        int referenceIndex = 0;
        // Locate piece
        for (int i = 0 ; i < mainBoxes.size() ; i++) {
            ArrayList<Integer> boxPieces = mainBoxes.get(i).lookPieces();
            if(boxPieces.contains(numberName)) {
                referenceIndex = i;
                flag = false;
            }
        }
        // get the reference of the piece
        Piece movePiece = mainBoxes.get(referenceIndex).pieceReference(numberName);
        // remove the piece using the reference
        mainBoxes.get(referenceIndex).removePiece(movePiece);
//        System.out.println("REFERENCE INDEX IS: " + referenceIndex);

        // move the piece
        if ((referenceIndex + result) >= 68) referenceIndex = 0; // TODO: REPOSICION DE ELEMENTO IRIA DESDE EL INICIO
        //Update the matrix
        refreshCompleteMatrix(result,numberName,referenceIndex, movePiece);
        referenceIndex += result;
        // add the piece using the reference
        mainBoxes.get(referenceIndex).addPiece(movePiece);

    }

    public void refreshCompleteMatrix(int result,int numberName, int referenceIndex, Piece movePiece) {
//        System.out.println("RESULT IS: " + result);
//        System.out.println("REFERENCE INDEX IS: " + referenceIndex);
        int totalMove = referenceIndex + result;
//        mainBoxes;
        System.out.println("---------------------------------------------------------------");
        System.out.println("REFERENCE INDEX IS: " + referenceIndex + " RESULT: " + result);
        System.out.println("ANTES CASILLA: " + getBoxReferencePosition()[referenceIndex][0][0] + "," + getBoxReferencePosition()[referenceIndex][0][1] );
        System.out.println("RESULTADO DEL DADO: " + result);
        System.out.println("DESPUES CASILLA: " + getBoxReferencePosition()[totalMove][0][0] + "," + getBoxReferencePosition()[totalMove][0][1] );
        System.out.println("---------------------------------------------------------------");
        completeMatrix[getBoxReferencePosition()[totalMove][0][0]][getBoxReferencePosition()[totalMove][0][1]].addPiece(movePiece);
        completeMatrix[getBoxReferencePosition()[referenceIndex][0][0]][getBoxReferencePosition()[referenceIndex][0][1]].removePiece(movePiece);
//        initializeBoxReferencePosition()[totalMove][0];
//        initializeBoxReferencePosition()[totalMove][1];
//        for (int i = 0; i < getBoxReferencePosition().length;i++ ){
////            for (int j = 0; j < getBoxReferencePosition().length;j++ ){
//
//                completeMatrix[getBoxReferencePosition()[i][0][0]][getBoxReferencePosition()[i][0][1]].addPiece(new Piece(Color.CYAN));
//                completeMatrix[getBoxReferencePosition()[i][1][0]][getBoxReferencePosition()[i][1][1]].addPiece(new Piece(Color.CYAN));
//                //
////                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
////                System.out.println("Next: ");
////                String userName = myObj.nextLine();  // Read user input
//                //
////            }
//        }
        System.out.println("LONGITUD: " + getBoxReferencePosition().length);
    }


    public int[][][] getBoxReferencePosition(){
        int[][][] boxesPosition = {

                // Red path
                {{11,4},{12, 4}},{{11,5},{12,5}},{{11,6},{12,6}},{{11,7},{12,7}},{{11,8},{12,8}},
                {{13,8},{13,7}},{{14,8},{14,7}},{{15,8},{15,7}},{{16,8},{16,7}},{{17,8},{17,7}},{{18,8},{18,7}},{{19,8},{19,7}},
                {{19,10},{19,9}},{{19,12},{19,11}},{{18,12},{18,11}},{{17,12},{17,11}},{{16,12},{16,11}},

                // Green path
                {{15, 12}, {15, 11}},{{14,12},{14,11}},{{13,12},{13,11}},{{12,12},{12,11}},{{11,12},{11,11}},
                {{12,13},{11,13}},{{12,14},{11,14}},{{12,15}, {11,15}},{{12,16},{11,16}},{{12,17},{11,17}},{{12,18},{11,18}},{{12,19},{11,19}},
                {{10,19},{9,19}},{{8,19},{7,19}},{{8,18}, {7,18}},{{8,17},{7,17}},{{8,16},{7,16}},

                // Yellow path
                {{8,15},{7, 15}},{{8,14},{7,14}},{{8,13},{7,13}},{{8,12},{7,12}},{{8,11},{7,11}},
                {{6,12},{6,11}},{{5,12},{5,11}},{{4,12},{4,11}},{{3,12},{3,11}},{{2,12},{2,11}},{{1,12},{1,11}},{{0,12},{0,11}},
                {{0,10},{0,9}},{{0,8},{0,7}},{{1,8},{1,7}},{{2,8},{2,7}},{{3,8},{3,7}},

                // Blue path
                {{4,8},{4,7}},{{5,8},{5,7}},{{6,8},{6,7}},{{7,8},{7,7}},{{8,8},{8,7}},
                {{8,6},{7,6}},{{8,5},{7,5}},{{8,4},{7,4}},{{8,3},{7,3}},{{8,2},{7,2}},{{8,1},{7,1}},{{8,0},{7,0}},
                {{10,0},{9,0}},{{12,0},{11,0}},{{12,1},{11,1}},{{12,2},{11,2}},{{12,3},{11,3}}

        };
        return boxesPosition;
    }


    public void refresh() {}

}
