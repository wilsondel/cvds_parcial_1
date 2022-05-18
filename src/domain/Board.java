package domain;


import java.awt.*;
import java.util.ArrayList;

public class Board {

    // Boxes
    private Box[] boxes;
    private Safe[] safes;
    private HomeWay[] homeWays;
    private Success[] successes;

    // Main Matrix
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
    private ArrayList<HomeWay> homeWayP1;
    private ArrayList<HomeWay> homeWayP2;


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
        homeWayP1 = new  ArrayList<HomeWay>(6);
        for (int i = 0; i < 6;i++){
            homeWayP1.add(new HomeWay());
        }
        homeWayP2 = new  ArrayList<HomeWay>(6);
        for (int i = 0; i < 6;i++){
            homeWayP2.add(new HomeWay());
        }
        int[] namesP1 = {1,2,3,4};
        int[] namesP2 = {5,6,7,8};
        initialBase(baseP1,redHome,namesP1);
        initialBase(baseP2,yellowHome,namesP2);
    }

    /*
     * Initialize bases of the board
     * @param base
     * @param color
     * @param names
     */
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
        blueBase(blueHome);
        yellowBase(yellowHome);
        greenBase(greenHome);
        redBase(redHome);
        safeBox(grayBox);
        successBox(grayBox);
        return completeMatrix;
    }

    /*
      * Show blue base
     */
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
    /*
     * Show yellow base
     */
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
        addPiecesBase( position,yellowHome, baseP2);
    }

    /*
     *  Show green base
     */
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

    /*
     * Show red base
     */
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
        addPiecesBase( position,redHome,baseP1);
    }

    /*
     * Add Pieces in the base
     */
    private void addPiecesBase(int[][] position, Color colorPiece, Box base){
        int aux = 0;
        for (int[] pos : position){
            completeMatrix[pos[0]][pos[1]].addPiece(base.getPieces().get(aux));
            aux+=1;
        }
    }
    /*
    * Add the safe Boxes to the Board
    */
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
    /*
     * Add the success Boxes to the Board
     */
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


    public void evaluateBox(int[] result, Player player,int numberName, int pieceMoveResult) {

        // Base validation
        validateOutBase(result,player.getName());
        // Box validation
        validateNormalBox(pieceMoveResult,player.getName(),numberName);
    }

    public void validateOutBase(int[] result, String player){
        int amountPieces;
        int[][] baseRedPosition = { {11,4},{14,1},{12,4},{14,5},{11,4},{18,1},{12,4},{18,5} };
        int[] nameRedPieces = {1,2,3,4};
        int[] nameYellowPieces = {5,6,7,8};
        int[][] baseYellowPosition = { {7,15},{1,14},{8,15},{5,14},{7,15},{1,18},{8,15},{5,18} };
        if (player.equals("P1")) {
            amountPieces = baseP1.getPieces().size();
            if (amountPieces > 0) outBase(result,player,baseRedPosition,nameRedPieces);
        } else {
            amountPieces = baseP2.getPieces().size();
            if (amountPieces > 0) outBase(result,player,baseYellowPosition,nameYellowPieces);
        }
    }
    /*
     *
     */
    public void outBase(int[] result, String player,int[][] basePosition, int[] namePieces) {
        //System.out.println("BASE P1 REFERENCE: " + baseP1.getPieces().size()); //TODO: quitar
        int totalDiceSum = result[0] + result[1];
        int initialPos = 0;
        if (player.equals("P1")) {
            if (result[0] == 5 && result[1] == 5) {
                mainBoxes.get(initialPos).addPiece(baseP1.outBase("1"));
            } else if (result[0] == 5 || result[1] == 5 || totalDiceSum == 5) {
                mainBoxes.get(initialPos).addPiece(baseP1.outBase("2"));
            }
        } else {
            initialPos = 33;
            if (result[0] == 5 && result[1] == 5) {
                mainBoxes.get(initialPos).addPiece(baseP2.outBase("1"));
            } else if (result[0] == 5 || result[1] == 5 || totalDiceSum == 5) {
                mainBoxes.get(initialPos).addPiece(baseP2.outBase("2"));
            }
        }
        // Piece 1 base
        if (mainBoxes.get(initialPos).lookPieces().contains(namePieces[0])){
            completeMatrix[basePosition[0][0]][basePosition[0][1]].addPiece(mainBoxes.get(initialPos).pieceReference(namePieces[0]));
            completeMatrix[basePosition[1][0]][basePosition[1][1]].removePiece();
        }
        // Piece 2 base
        if ((mainBoxes.get(initialPos).lookPieces().contains(namePieces[1]))) {
            completeMatrix[basePosition[2][0]][basePosition[2][1]].addPiece(mainBoxes.get(initialPos).pieceReference(namePieces[1]));
            completeMatrix[basePosition[3][0]][basePosition[3][1]].removePiece();
        }
        // Piece 3 base
        if ((mainBoxes.get(initialPos).lookPieces().contains(namePieces[2]))) {
            completeMatrix[basePosition[4][0]][basePosition[4][1]].addPiece(mainBoxes.get(initialPos).pieceReference(namePieces[2]));
            completeMatrix[basePosition[5][0]][basePosition[5][1]].removePiece();
        }
        // Piece 4 base
        if ((mainBoxes.get(initialPos).lookPieces().contains(namePieces[3]))) {
            completeMatrix[basePosition[6][0]][basePosition[6][1]].addPiece(mainBoxes.get(initialPos).pieceReference(namePieces[3]));
            completeMatrix[basePosition[7][0]][basePosition[7][1]].removePiece();
        }
        // Quit pieces with 0 Num TODO: resolver esto :d, aiññsh => NO :p
        quitExtraPieces(0);
    }

    public void quitExtraPieces(int numPiece) {
        for(int i = 0; i < completeMatrix.length;i++){
            for(int j = 0; j < completeMatrix.length;j++){
                completeMatrix[i][j].removePiece(completeMatrix[i][j].pieceReference(numPiece));
            }
        }
    }

    public void validateNormalBox(int result, String player,int numberName) {
//        result=1; // TODO: quitar esto :l
        movePiece(result,player,numberName);
        // TODO: validar carcel o bloqueo
    }

    /*
     *
     */
    public void movePiece(int result, String player,int numberName){
//        ArrayList<HomeWay> homeWayP;
//        if (player.equals("P1")) {
//            homeWayP =  homeWayP1;
//        } else {
//            homeWayP =  homeWayP2;
//        }
        int referenceIndex = 0;
        // Locate piece
        for (int i = 0 ; i < mainBoxes.size() ; i++) {
            ArrayList<Integer> boxPieces = mainBoxes.get(i).lookPieces();
            if(boxPieces.contains(numberName)) {
                referenceIndex = i;
            }
        }
        // get the reference of the piece
        Piece movePiece = mainBoxes.get(referenceIndex).pieceReference(numberName);
        // remove the piece using the reference
        mainBoxes.get(referenceIndex).removePiece(movePiece);
//        System.out.println("REFERENCE + RESULT: " + referenceIndex + "," + result);
//        if (player.equals("P1")) {
//            movePieceHomeWay(homeWayP1,movePiece,referenceIndex,result,numberName,"red");
//        } else {
//        }

        if ((referenceIndex + result) > 62){
            movePiece.setState("homeWay");
            homeWayP1.get(result-1).addPiece(movePiece);
            refreshCompleteMatrixHomeWay(result,numberName,referenceIndex, movePiece,"red");
        }
        boolean flagHomeWay= homeWayContains(homeWayP1,numberName);
        if (flagHomeWay) {
            removeInMainBoxes(numberName);
            quitExtraPieces(numberName);
            referenceIndex = homeWayReferenceIndex(homeWayP1,numberName);
            movePiece = homeWayP1.get(referenceIndex).pieceReference(numberName);
            homeWayP1.get(referenceIndex).removePiece(movePiece);
            homeWayP1.get(referenceIndex + result).addPiece(movePiece);
            refreshCompleteMatrixHomeWay(result + referenceIndex,numberName,referenceIndex, movePiece,"red");
        }
//        System.out.println("REFERENCE INDEX IS: " + referenceIndex);
//        if (movePiece.getPower().equals("Advantageous")) {
//            result+=3; // TODO: validar turno
//        }
        // move the piece
        if ((referenceIndex + result) >= 68) referenceIndex = 0; // TODO: REPOSICION DE ELEMENTO IRIA DESDE EL INICIO
        if (!flagHomeWay) {
            //Update the matrix
            refreshCompleteMatrix(result,numberName,referenceIndex, movePiece);
            referenceIndex += result;
            // add the piece using the reference
            mainBoxes.get(referenceIndex).addPiece(movePiece);
        }
    }

    public int homeWayReferenceIndex(ArrayList<HomeWay> homeWay, int numPiece){
        ArrayList<Integer> piecesNum;
        for (int i = 0; i < homeWay.size(); i++) {
            piecesNum= homeWay.get(i).lookPieces();
            if (piecesNum.contains(numPiece)){
                System.out.println("Si encuentra la ficha en homeway");
                return i;
            }
        }
        return 0;
    }

    public boolean homeWayContains(ArrayList<HomeWay> homeWay, int numPiece){
        ArrayList<Integer> piecesNum;
        for (Box p : homeWay) {
            piecesNum= p.lookPieces();
            if (piecesNum.contains(numPiece)){
                return true;
            }
        }
        return false;
    }

    public void removeInMainBoxes(int numPiece) {
        ArrayList<Integer> piecesNum;
        for (Box p : mainBoxes) {
            piecesNum= p.lookPieces();
            if (piecesNum.contains(numPiece)){
                p.removePiece(p.pieceReference(numPiece));
            }
        }
    }

    public void refreshCompleteMatrix(int result,int numberName, int referenceIndex, Piece movePiece) {
//        System.out.println("RESULT IS: " + result);
//        System.out.println("REFERENCE INDEX IS: " + referenceIndex);
        int totalMove = referenceIndex + result;
//        mainBoxes;
//        System.out.println("---------------------------------------------------------------");
//        System.out.println("REFERENCE INDEX IS: " + referenceIndex + " RESULT: " + result);
//        System.out.println("ANTES CASILLA: " + getBoxReferencePosition()[referenceIndex][0][0] + "," + getBoxReferencePosition()[referenceIndex][0][1] );
//        System.out.println("RESULTADO DEL DADO: " + result);
//        System.out.println("DESPUES CASILLA: " + getBoxReferencePosition()[totalMove][0][0] + "," + getBoxReferencePosition()[totalMove][0][1] );
//        System.out.println("---------------------------------------------------------------");
//        boolean flag = completeMatrix[getBoxReferencePosition()[referenceIndex][0][0]][getBoxReferencePosition()[totalMove][0][1]].pieceReference(numberName) == movePiece;

        boolean flagPath1 = completeMatrix[getBoxReferencePosition()[totalMove][0][0]][getBoxReferencePosition()[totalMove][0][1]].getState().equals("");
        boolean flagPath2 = completeMatrix[getBoxReferencePosition()[totalMove][1][0]][getBoxReferencePosition()[totalMove][1][1]].getState().equals("");
        boolean validatePieceMovement = false;
        if (flagPath1) {
            completeMatrix[getBoxReferencePosition()[totalMove][0][0]][getBoxReferencePosition()[totalMove][0][1]].addPiece(movePiece);
            validatePieceMovement = true;
        } else if (flagPath2){
            completeMatrix[getBoxReferencePosition()[totalMove][1][0]][getBoxReferencePosition()[totalMove][1][1]].addPiece(movePiece);
            validatePieceMovement = true;
        }
        if (validatePieceMovement) {
            completeMatrix[getBoxReferencePosition()[referenceIndex][0][0]][getBoxReferencePosition()[referenceIndex][0][1]].removePiece(movePiece);
            completeMatrix[getBoxReferencePosition()[referenceIndex][1][0]][getBoxReferencePosition()[referenceIndex][1][1]].removePiece(movePiece);
        }

    }

    /*
    * */
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

    public int[][][] getBoxReferencePositionHomeWay(String baseHomeWay){
        int[][][] boxesPositionHomeWay = {};
        if (baseHomeWay.equals("red")) {
            int[][][] boxesPositionRedHomeWay = {
                    //Red
                    {{9,1},{10,1}},{{9,2},{10,2}},{{9,3},{10,3}},{{9,4},{10,4}},{{9,5},{10,5}},{{9,6},{10,6}}
             };
            return  boxesPositionRedHomeWay;
        } else if (baseHomeWay.equals("yellow")) {
            int[][][] boxesPositionYellowHomeWay = {
                    //Yellow
                    {{9,19},{10,19}},{{9,18},{10,18}},{{9,17},{10,17}},{{9,16},{10,16}},{{9,15},{10,15}},{{9,14},{10,14}}
            };
            return boxesPositionYellowHomeWay;
        }
        return boxesPositionHomeWay;
    }

    /*
     *
     */
    public void refreshCompleteMatrixHomeWay(int result,int numberName, int referenceIndex, Piece movePiece, String colorBase) {
        boolean flagPath1 = completeMatrix[getBoxReferencePositionHomeWay(colorBase)[result][0][0]][getBoxReferencePositionHomeWay(colorBase)[result][0][1]].getState().equals("");
        boolean flagPath2 = completeMatrix[getBoxReferencePositionHomeWay(colorBase)[result][1][0]][getBoxReferencePositionHomeWay(colorBase)[result][1][1]].getState().equals("");
        boolean validatePieceMovement = false;
        System.out.println("********************************************************");
        System.out.println("REFERENCE INDEX IS: " + referenceIndex + " RESULT: " + result);
        System.out.println("CASILLA A PARAR (1): " + getBoxReferencePositionHomeWay(colorBase)[result][0][0] + "," + getBoxReferencePositionHomeWay(colorBase)[result][0][1] );
        System.out.println("RESULTADO DEL DADO: " + result);
        System.out.println("CASILLA A PARAR: " + getBoxReferencePositionHomeWay(colorBase)[result][1][0] + "," + getBoxReferencePositionHomeWay(colorBase)[result][1][1] );
        System.out.println("********************************************************");
        if (flagPath1) {
            completeMatrix[getBoxReferencePositionHomeWay(colorBase)[result][0][0]][getBoxReferencePositionHomeWay(colorBase)[result][0][1]].addPiece(movePiece);
            validatePieceMovement = true;
        } else if (flagPath2){
            completeMatrix[getBoxReferencePositionHomeWay(colorBase)[result][1][0]][getBoxReferencePositionHomeWay(colorBase)[result][1][1]].addPiece(movePiece);
            validatePieceMovement = true;
        }
//        if (validatePieceMovement) {
//            completeMatrix[getBoxReferencePositionHomeWay(colorBase)[result][0][0]][getBoxReferencePositionHomeWay(colorBase)[result][0][1]].removePiece(movePiece);
//            completeMatrix[getBoxReferencePositionHomeWay(colorBase)[result][1][0]][getBoxReferencePositionHomeWay(colorBase)[result][1][1]].removePiece(movePiece);
//        }
    }



public void refresh() {}

}
