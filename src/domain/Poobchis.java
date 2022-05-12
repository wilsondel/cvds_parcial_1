package domain;

public class Poobchis {
    private Board board;
    private Player p1, p2;

    public Poobchis(){
        board = new Board();
        p1 = new Player("P1");
        p2 = new Player("P2");
    }

    public void finish() {
        System.exit(0);
    }

    public void play(String player, int nameNumber){ // TODO: nameNumber
        int[] result = p1.getValueDice();
        System.out.println("RESULT: " + result[0] + "," +result[1]);
        board.evaluateBox(result,p1,1); //TODO: COLOCAR ARGUMENTO DE QUE FICHA VA A AVANZAR


    }

    public Board getBoard() {
        return board;
    }

}
