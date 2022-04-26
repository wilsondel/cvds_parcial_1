package presentation;

import domain.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;

public class PoobchisGUI extends JFrame {

    private static final Dimension PREFERRED_DIMENSION = new Dimension(900,900);

    // POObchis
    Poobchis poobchis;

    // Menu
    private JMenuBar navbar;
    private JMenuItem menu,newGame,open,save,saveAs,out,menuColor,menuColorP1,menuColorP2;

    // Home
    private JPanel home,boardBackground,settings;

    // Home Buttons
    private JButton buttonStart,buttonSettings, buttonExit;

    // Board

    // Board Buttons
    private JButton dice1, dice2, powerful;
    // labels
    private JLabel playerTurn, power;

    /*Panel buttonAdd*/
    private JTextField textCode;
    private JTextField textName;
    private JTextField textCredits;
    private JTextArea textResults;

    private PoobchisGUI()
    {
        prepareElements();
        prepareActions();
        poobchis = new Poobchis();
    }

    private void prepareElements(){
        setTitle("POOBchis");
        textCode = new JTextField(50);
        textName = new JTextField(50);
        textCredits = new JTextField(50);
        textResults = new JTextArea(10, 50);
        textResults.setLineWrap(true);
        textResults.setWrapStyleWord(true);
        JTabbedPane labels = new JTabbedPane();
        getContentPane().add(labels);
        setSize(PREFERRED_DIMENSION);
        setResizable(false);
//        setSize((Toolkit.getDefaultToolkit().getScreenSize().width) , (Toolkit.getDefaultToolkit().getScreenSize().height));
//        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width), (Toolkit.getDefaultToolkit().getScreenSize().height) );

        // Menu
        prepareElementsMenu();

        // Board
        prepareElementsBoard();

        // Home
        prepareElementsHome();

    }

    private void prepareElementsMenu() {
        navbar = new JMenuBar();
        menu = new JMenu("Menu");
        newGame = new JMenuItem("New");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        //saveAs = new JMenuItem("Save as");
        out = new JMenuItem("Exit");
        menu.add(newGame);
        menu.add(open);
        menu.add(save);
        //menu.add(saveAs);
        menu.add(out);
        navbar.add(menu);
        setJMenuBar(navbar);
    }


    private void prepareElementsBoard() {
//        System.out.println("ELEMENTS BOARD");
        boardBackground = new JPanel();
        boardBackground.setLayout(new BorderLayout(Toolkit.getDefaultToolkit().getScreenSize().width/50, 5));
        add(boardBackground);
        JPanel boardNorth = new JPanel();
        boardBackground.add(boardNorth, BorderLayout.NORTH);

        JPanel boardEast = new JPanel();
        boardBackground.add(boardEast, BorderLayout.EAST);

        JPanel boardWest = new JPanel();
        boardBackground.add(boardWest, BorderLayout.WEST);

        JPanel southButtons = new JPanel();
        southButtons.setLayout(new GridLayout(1,2));

        playerTurn = new JLabel("PLAYER #");
        Icon iconA = new ImageIcon("images/dices/design6.png");

        dice1 = new JButton("5");
        dice1.setIcon(iconA);
        dice1.setHorizontalTextPosition(JButton.CENTER);
        dice1.setVerticalTextPosition(JButton.CENTER);
        dice1.setBackground(Color.white);
        dice1.setText("5");

        dice2 = new JButton("#");
        dice2.setIcon(iconA);
        dice2.setHorizontalTextPosition(JButton.CENTER);
        dice2.setVerticalTextPosition(JButton.CENTER);
        dice2.setBackground(Color.white);
        dice2.setText("5");

        southButtons.add(playerTurn);
        southButtons.add(dice1);
        southButtons.add(dice2);
        power = new JLabel("POWER");
        powerful = new JButton("Bunny");
        southButtons.add(power);
        southButtons.add(powerful);
        boardBackground.add(southButtons, BorderLayout.SOUTH);

        JPanel boardImg = new JPanel();
//        homeButtons.setLayout(new GridLayout(5,5));
        // Board
        ImageIcon img = new javax.swing.ImageIcon("template2.png");
        JLabel image = new javax.swing.JLabel(img);
        // Piece
        JPanel boardImg2 = new JPanel();
        ImageIcon imgPiece = new javax.swing.ImageIcon("images/pieces/5.png");
        JLabel imagePiece = new javax.swing.JLabel(imgPiece);
        boardImg.add(image);
        boardImg2.add(imagePiece);
        boardImg2.setBounds(500,500,300,300);
//        boardBackground.add(boardImg2, BorderLayout.CENTER);
        boardBackground.add(boardImg, BorderLayout.CENTER);
    }

    private void prepareElementsHome() {
        home = new JPanel();
        home.setLayout(new BorderLayout(Toolkit.getDefaultToolkit().getScreenSize().width/9, 5));
        add(home);

        ImageIcon img = new javax.swing.ImageIcon("logo.png");
        JLabel image = new javax.swing.JLabel(img);
        home.add(image, BorderLayout.NORTH);
        JPanel homeEast = new JPanel();
        home.add(homeEast, BorderLayout.EAST);
        JPanel homeWest = new JPanel();
        home.add(homeWest, BorderLayout.WEST);
        JPanel homeSouth = new JPanel();
        home.add(homeSouth, BorderLayout.SOUTH);

        JPanel homeButtons = new JPanel();
        homeButtons.setLayout(new GridLayout(5,1, 1, 20));
        buttonStart = new JButton("Start");
        buttonStart.setBackground(Color.decode("#c9edea"));
        homeButtons.add(buttonStart);
//        buttonSettings = new JButton("Settings");
//        buttonSettings.setBackground(Color.decode("#c9edea"));
//        homeButtons.add(buttonSettings);
        buttonExit = new JButton("Exit");
        buttonExit.setBackground(Color.decode("#c9edea"));
        homeButtons.add(buttonExit);
        home.add(homeButtons, BorderLayout.CENTER);
    }

    private void prepareActions() {
        // Finish program when JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Closing confirmation
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                outConfirmation();
            }
        });

        //Menu
        prepareActionsMenu();

        //ToBoard
        prepareActionsButtons();

        // Board Houses
        //prepareActionsButtonsHouses();

    }
    private void prepareActionsMenu() {
        //Exit option
        out.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionExit();
            }
        });

        // Open option
        open.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionOpen();
            }
        });

        //Save option
        save.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionSave();
            }
        });

    }

    private void actionOpen(){
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(this, "We are working in this functionality. We cannot open " + fileChooser.getSelectedFile().getName());
        }
    }

    private void prepareActionsButtons() {
        buttonStart.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goToBoard();
            }
        });

//        buttonSettings.addActionListener( new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
////                cghaneSettings();
//            }
//        });

        buttonExit.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionExit();
            }
        });


    }

    private void actionSave() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(this, "We are working in this functionality. We cannot save " + fileChooser.getSelectedFile().getName());
        }
    }


    private void actionExit(){
        int confirmation= JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confirmacion",JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == confirmation){
            System.exit(0);
        }
    }

    private void outConfirmation() {
        if (JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)  System.exit(0) ;
    }


    private void goToBoard() {
        home.setVisible(false);
        prepareElementsBoard();
        prepareActions();
//        prepareActionsButtons();
//        prepareActionsButtonsHouses();
        boardBackground.setVisible(true);
    }

    private void goToHome() {
        boardBackground.setVisible(false);
        prepareElementsHome();
        prepareActions();
//        prepareActionsMenu();
        home.setVisible(true);

    }

    public static void main(String[] args) {
        PoobchisGUI gui = new PoobchisGUI();
        gui.setVisible(true);
    }
}

