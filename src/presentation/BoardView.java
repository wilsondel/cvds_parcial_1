package presentation;

import domain.Box;
import domain.Poobchis;
import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//public class BoardView extends JFrame {
//    public static final int SIDE=20;
//    public static final int SIZE=20;
//
//    private JButton buttonTicTac;
//    private JPanel panelControl;
//    private PhotoAutomata photo;
////    private CellularAutomata automata;
//
//    private BoardView() {
////        Poobchis poobchis = new Poobchis();
//        prepareElements();
//        prepareActions();
//    }
//
//    private void prepareElements() {
////        setTitle("Automata celular");
//        photo=new PhotoAutomata(this);
//        buttonTicTac=new JButton("Tic-tac");
//        setLayout(new BorderLayout());
//        add(photo,BorderLayout.NORTH);
//        add(buttonTicTac,BorderLayout.SOUTH);
//        setSize(new Dimension(980,950));
//        //setResizable(false);
//        photo.repaint();
//    }
//
//    private void prepareActions(){
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        buttonTicTac.addActionListener(
//                new ActionListener(){
//                    public void actionPerformed(ActionEvent e) {
//                        buttonTicTacAction();
//                    }
//                });
//
//    }
//
//    private void buttonTicTacAction() {
//        automata.ticTac();
//        photo.repaint();
//    }
//
//    public CellularAutomata getAutomata(){
//        return automata;
//    }
//
//    public static void main(String[] args) {
//        AutomataGUI ca=new AutomataGUI();
//        ca.setVisible(true);
//    }
//
//}

class BoardView extends JPanel{
    private PoobchisGUI gui;
    private Box[][] completeMatrix;

    // COLORS
    private Color blueHome = new Color(0x805FF2EE,true);
    private Color redHome = new Color(0x80FF1616,true);
    private Color greenHome = new Color(0x807FB95F,true);
    private Color yellowHome = new Color(0x80F9A72B,true);
    private Color grayBox = new Color(0xBF66635B,true);

    public BoardView(PoobchisGUI gui, Box[][] completeMatrix) {
        this.gui=gui;
        this.completeMatrix = completeMatrix;
        setBackground(Color.white);
        setPreferredSize(new Dimension(980, 950));
    }


    public void paintComponent(Graphics g){
//        CellularAutomata automata=gui.getAutomata();
        super.paintComponent(g);


        for (int f=0;f<=gui.LENGTH;f++){
            g.drawLine(f*gui.SIDE*2,0,f*gui.SIDE*2,gui.LENGTH*gui.SIDE*2);
        }
        for (int c=0;c<=gui.LENGTH;c++){
            g.drawLine(0,c*gui.SIDE*2,gui.LENGTH*gui.SIDE*2,c*gui.SIDE*2);
        }
//        for (int f=0;f<gui.LENGTH;f++){
//            for(int c=0;c<gui.LENGTH;c++){
//                if (automata.getItem(f,c)!=null){
//                    g.setColor(automata.getItem(f,c).getColor());
//                    if (automata.getItem(f,c).shape()==Item.SQUARE){
//                        if (automata.getItem(f,c).isAlive()){
//                            g.fillRoundRect(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2,2,2);
//                        }else{
//                            g.drawRoundRect(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2,2,2);
//                        }
//                    }else {
//                        if (automata.getItem(f,c).isAlive()){
//                            g.fillOval(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2);
//                        } else {
//                            g.drawOval(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2);
//                        }
//                    }
//                }
//            }
//        }

        for (int f=0;f<gui.LENGTH;f++){
            for(int c=0;c<gui.LENGTH;c++){
//                System.out.println("SI ENTRA FUERA");
                if (completeMatrix[f][c] != null){
//                    System.out.println("SI ENTRA");
                    g.setColor(completeMatrix[f][c].getColor());
                        if (true){
                            g.fillRoundRect(gui.SIDE*c*2+1,gui.SIDE*f*2+1,gui.SIDE*2-2,gui.SIDE*2-2,2,2);
                        }else{
                            g.drawRoundRect(gui.SIDE*c*2+1,gui.SIDE*f*2+1,gui.SIDE*2-2,gui.SIDE*2-2,2,2);
                        }
                }
            }
        }
    }
}
