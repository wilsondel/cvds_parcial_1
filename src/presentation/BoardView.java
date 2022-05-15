package presentation;

import domain.Box;
import domain.Poobchis;
import domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BoardView extends JPanel{
    private PoobchisGUI gui;
    private Box[][] completeMatrix;

    // COLORS
    private Color blueHome = new Color(0xFF356DE8,true);
    private Color redHome = new Color(0xE6FF1616,true);
    private Color greenHome = new Color(0xE67FB95F,true);
    private Color yellowHome = new Color(0xE6F9A72B,true);
    private Color grayBox = new Color(0xE666635B,true);

    public BoardView(PoobchisGUI gui, Box[][] completeMatrix) {
        this.gui=gui;
        this.completeMatrix = completeMatrix;
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(980, 950));
    }


    public void paintComponent(Graphics g){
//        CellularAutomata automata=gui.getAutomata();
        super.paintComponent(g);
        g.setColor( new Color(0xFFB6B6B6,true));

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
                if (completeMatrix[f][c] != null) {
                    if (completeMatrix[f][c].getState().equals("")) {
                        //                    System.out.println("SI ENTRA");
//                        System.out.println("COLOR: " + completeMatrix[f][c].getColorPiece().toString());
                        g.setColor(completeMatrix[f][c].getColorPiece());
//                        if (false) {
                        g.fillRoundRect(gui.SIDE * c * 2 + 1, gui.SIDE * f * 2 + 1, gui.SIDE * 2 - 2, gui.SIDE * 2 - 2, 2, 2);
//                        } else {
//                            g.drawRoundRect(gui.SIDE * c * 2 + 1, gui.SIDE * f * 2 + 1, gui.SIDE * 2 - 2, gui.SIDE * 2 - 2, 2, 2);
//                        }
                    } else if (completeMatrix[f][c].getState().equals("1")) {
                        g.setColor(completeMatrix[f][c].getColorPiece());
                        g.fillOval(gui.SIDE*c*2+1,gui.SIDE*f*2+1,gui.SIDE*2-2,gui.SIDE*2-2);
                        g.setColor(Color.BLACK);
                        g.drawString(String.valueOf(completeMatrix[f][c].getPieceNumber()),gui.SIDE*c*2+20,gui.SIDE*f*2+20);
                    }
                }
            }
        }
    }
}
