package presentation;

import domain.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class PoobchisGUI extends JFrame {

    private static final Dimension PREFERRED_DIMENSION = new Dimension(1200,1000);
    // GUI
    private static PoobchisGUI guiAux;
    // POObchis
    Poobchis poobchis;
    int optPlayers=2;

    // Menu
    private JMenuBar navbar;
    private JMenuItem menu,newGame,open,save,saveAs,out,menuColor,menuColorP1,menuColorP2;

    // Home
    private JPanel home,boardBackground,settings;

    // Home Buttons
    private JButton buttonStart,buttonRules, buttonExit;

    // Choose modes
    private JPanel chooseModes;
    // Buttons
    private JButton buttonMode1,buttonMode2;

    // // Mode 1
    private JPanel mode1;
    private JButton powerP1,colorP1,diceStyleP1, playMode1;
    // // JDialog
    private JButton buttonOk = new JButton("Ok");
    // // JDialog checkboxes powers text
    ArrayList<String> powers = new ArrayList<String>();

    //// player amount
    private JDialog playerAmount;
    private ArrayList<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();

    // Board
    private BoardView imageBoard;
    // Board Buttons
    private JButton dice1, dice2, powerful;
    // labels
    private JLabel playerTurn, power;
    // SIZES
    public static final int SIDE=20;
    public static final int SIZE=20;
    public static final int LENGTH=20;


    /*Panel buttonAdd*/
    private JTextField textCode;
    private JTextField textName;
    private JTextField textCredits;
    private JTextArea textResults;

    private PoobchisGUI()
    {
        poobchis = new Poobchis();
        prepareElements();
        prepareActions();
    }

    private void prepareElements(){
        setTitle("POOBchis");
        this.setIconImage((new ImageIcon("minilogo.png")).getImage());
        textCode = new JTextField(50);
        textName = new JTextField(50);
        textCredits = new JTextField(50);
        textResults = new JTextArea(10, 50);
        textResults.setLineWrap(true);
        textResults.setWrapStyleWord(true);
        JTabbedPane labels = new JTabbedPane();
        getContentPane().add(labels);
        setSize(PREFERRED_DIMENSION);
//        setResizable(false); TODO: RESIZE
//        setSize((Toolkit.getDefaultToolkit().getScreenSize().width) , (Toolkit.getDefaultToolkit().getScreenSize().height));
//        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width), (Toolkit.getDefaultToolkit().getScreenSize().height) );

        // Menu
        prepareElementsMenu();

        // Board
        prepareElementsBoard();

        // Modes
        prepareElementsChooseModes();

        //Settings Mode 1
        prepareElementsSettingsMode1();

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
        Icon iconPower = new ImageIcon("images/powers/jumper.png");
        powerful = new JButton();
        powerful.setIcon(iconPower);
        powerful.setBackground(Color.white);
        southButtons.add(power);
        southButtons.add(powerful);
        boardBackground.add(southButtons, BorderLayout.SOUTH);

        JPanel boardImg = new JPanel();
//        homeButtons.setLayout(new GridLayout(5,5));
        // Board
//        ImageIcon img = new javax.swing.ImageIcon("template3.png");
//        JLabel image = new javax.swing.JLabel(img);
        imageBoard = new BoardView(this, poobchis.getBoard().buildMatrix());
        // Piece
        JPanel boardImg2 = new JPanel();
        ImageIcon imgPiece = new javax.swing.ImageIcon("images/pieces/5.png");
        JLabel imagePiece = new javax.swing.JLabel(imgPiece);
        boardImg.add(imageBoard);
        boardImg2.add(imagePiece);
        boardImg2.setBounds(500,500,300,300);
//        boardBackground.add(boardImg2, BorderLayout.CENTER);
        boardBackground.add(boardImg, BorderLayout.CENTER);
    }

    private void prepareElementsHome() {
        home = new JPanel();
        home.setLayout(new BorderLayout(Toolkit.getDefaultToolkit().getScreenSize().width/9, 5));
//        home.setLayout(null);
        add(home);

//        //Background
//        ImageIcon imagenFondo = new ImageIcon("background.png");
//        JLabel fondo = new JLabel();
//        fondo.setBounds(-50,0,980,950);
//        fondo.setIcon(imagenFondo);
//        home.add(fondo);

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
        buttonStart.setBackground(Color.decode("#a4553f"));
        homeButtons.add(buttonStart);
        buttonRules = new JButton("Rules");
        buttonRules.setBackground(Color.decode("#c69275"));
        homeButtons.add(buttonRules);
        buttonExit = new JButton("Exit");
        buttonExit.setBackground(Color.decode("#ffebdb"));
        homeButtons.add(buttonExit);
        home.add(homeButtons, BorderLayout.CENTER);

    }

    private void prepareElementsChooseModes() {
        chooseModes = new JPanel();
        chooseModes.setLayout(new BorderLayout(Toolkit.getDefaultToolkit().getScreenSize().width/9, 5));
        add(chooseModes);

        ImageIcon img = new javax.swing.ImageIcon("logo.png");
        JLabel image = new javax.swing.JLabel(img);
        chooseModes.add(image, BorderLayout.NORTH);
        JPanel homeEast = new JPanel();
        chooseModes.add(homeEast, BorderLayout.EAST);
        JPanel homeWest = new JPanel();
        chooseModes.add(homeWest, BorderLayout.WEST);
        JPanel homeSouth = new JPanel();
        chooseModes.add(homeSouth, BorderLayout.SOUTH);

        JPanel homeButtons = new JPanel();
        homeButtons.setLayout(new GridLayout(5,1, 1, 20));
        buttonMode1 = new JButton("Fun Mode");
        buttonMode1.setBackground(Color.decode("#a4553f"));
//        JDialog d = new JDialog(this , "Dialog Example", true);
//        buttonMode1.add(d); // TODO: llorar
        homeButtons.add(buttonMode1);
        buttonMode2 = new JButton("PvM Mode");
        buttonMode2.setBackground(Color.decode("#c69275"));
        homeButtons.add(buttonMode2);
        chooseModes.add(homeButtons, BorderLayout.CENTER);
    }


    private void prepareElementsSettingsMode1() {
        mode1 = new JPanel();
        mode1.setLayout(new BorderLayout(Toolkit.getDefaultToolkit().getScreenSize().width/9, 5));
        add(mode1);

        JPanel homeNorth = new JPanel();
        JLabel titleMode = new JLabel("Mode 1 | \n\t Choose for player 1:");
        homeNorth.add(titleMode);
        mode1.add(homeNorth, BorderLayout.NORTH);
        JPanel homeEast = new JPanel();
        mode1.add(homeEast, BorderLayout.EAST);
        JPanel homeWest = new JPanel();
        mode1.add(homeWest, BorderLayout.WEST);
        JPanel homeSouth = new JPanel();
        mode1.add(homeSouth, BorderLayout.SOUTH);

        JPanel homeButtons = new JPanel();
        homeButtons.setLayout(new GridLayout(5,1, 1, 20));
        powerP1 = new JButton("Power");
        powerP1.setBackground(Color.decode("#a4553f"));
        homeButtons.add(powerP1);
        colorP1 = new JButton("Color");
        colorP1.setBackground(Color.decode("#c69275"));
        homeButtons.add(colorP1);
        diceStyleP1 = new JButton("Dice Style");
        diceStyleP1.setBackground(Color.decode("#ddbc9b"));
        homeButtons.add(diceStyleP1);
        playMode1 = new JButton("Play");
        playMode1.setBackground(Color.decode("#ffebdb"));
        homeButtons.add(playMode1);

        mode1.add(homeButtons, BorderLayout.CENTER);
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

        // Modes
        prepareActionsButtonsChooseModes();

        // Mode 1 buttons
        prepareActionsSettingsMode1();

        // Dices
        prepareActionsBoard();

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
                goToChooseModes();
//                goToBoard();
            }
        });

        buttonRules.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                cghaneSettings();
            }
        });

        buttonExit.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionExit();
            }
        });


    }

    private void prepareActionsButtonsChooseModes() {
        buttonMode1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goToSettingsMode1();
            }
        });

        buttonMode2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                cghaneSettings();
            }
        });
    }

    private void addingCheckBox(JDialog d) {
        JCheckBox checkbox1 = new JCheckBox("Advantageous");
        JCheckBox checkbox2 = new JCheckBox("Hoover");
        JCheckBox checkbox3 = new JCheckBox("Jumper");
        JCheckBox checkbox4 = new JCheckBox("Normal");
//        checkbox1.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent e) {
//                System.out.println(e.getStateChange() == 1 ?  "Checked" : "unchecked");
//            }
//        });
        d.add(checkbox1);
        d.add(checkbox2);
        d.add(checkbox3);
        d.add(checkbox4);
        checkBoxList.add(checkbox1);
        checkBoxList.add(checkbox2);
        checkBoxList.add(checkbox3);
        checkBoxList.add(checkbox4);
    }
    private void actionCheckBoxPower() {
        for (int i = 0; i < optPlayers; i++) {
            JDialog d = new JDialog();
            if (i == 1) d.setLocation(500, 0);
            d.setLayout(new GridLayout(15, 1, 0, 0));
            d.add(new JLabel("Choose a power"));
            d.add(new JLabel("Please, choose 4 pieces options."));
            buttonOk = new JButton("Ok");
            buttonOk.setBounds(200, 100, 75, 20);
            d.add(new JLabel("Player " + (i + 1)));
            addingCheckBox(d);
            addingCheckBox(d);
            buttonOk.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    actionCheckedOkBoxPower(d);
                }
            });
            d.add(buttonOk);
            d.setSize(420, 420);
            d.setVisible(true);
        }
    }

    private void actionCheckedOkBoxPower(JDialog d) {
//        int i = 0; TODO: list from the expected index position
        for (JCheckBox c : checkBoxList ) {
            if (c.isSelected()) {
                powers.add(c.getText());
//                System.out.println(powers.get(i));
//                i++;
            }
        }
//        powers = new ArrayList<String>();
        d.setVisible(false);
    }

    private void prepareActionsSettingsMode1() {

        powerP1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionCheckBoxPower();
            }
        });

        colorP1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog();
                d.setLayout( new GridLayout(10,1,0,0) );
                String[] colors = new String[optPlayers];
                String[] colorParchis = {"red","yellow","blue","green"};
                for (int i = 0; i < optPlayers; i++) {
                    colors[i] = colorParchis[i];
                }
                d.add( new JLabel ("Choose colors"));
                JButton b=new JButton("Ok");
                b.setBounds(200,100,75,20);
                for (int i = 0; i < optPlayers; i++) {
                    JComboBox cb=new JComboBox(colors);
                    cb.setBounds(50, 50,90,20);
                    d.add(new JLabel("Player " + (i+1) ));
                    d.add(cb);
                    b.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String data = ""+ cb.getItemAt(cb.getSelectedIndex());
                            System.out.println(data);
                            d.setVisible(false);
                        }
                    });
                }
                d.add(b);
                d.setSize(400,400);
                d.setVisible(true);
            }
        });

        diceStyleP1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog();
                d.setLayout( new GridLayout(10,1,0,0) );
                String[] dicesStyles = {"revolver","skull","savage unicorn","cosmic astronaut","plant of death", "crown","little cow"};
                d.add( new JLabel ("Choose a dice style"));
                JButton b=new JButton("Ok");
                b.setBounds(200,100,75,20);
                for (int i = 0; i < optPlayers; i++) {
                    JComboBox cb=new JComboBox(dicesStyles);
                    cb.setBounds(50, 50,90,20);
                    d.add(new JLabel("Player " + (i+1) ));
                    d.add(cb);
                    b.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String data = ""+ cb.getItemAt(cb.getSelectedIndex());
                            System.out.println(data);
                            d.setVisible(false);
                        }
                    });
                }
                d.add(b);
                d.setSize(400,400);
                d.setVisible(true);
            }
        });

        playMode1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goToBoard();
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


    private void goToChooseModes() {
        home.setVisible(false);
        prepareElementsChooseModes();
        prepareActions();
        chooseModes.setVisible(true);
    }


    private void goToSettingsMode1() {
        chooseModes.setVisible(false);
        prepareElementsSettingsMode1();
        prepareActions();
        boardBackground.setVisible(true);
    }

    private void goToHome() {
        boardBackground.setVisible(false);
        prepareElementsHome();
        prepareActions();
//        prepareActionsMenu();
        home.setVisible(true);

    }

    private void goToBoard() {
        mode1.setVisible(false);
        prepareElementsBoard();
        prepareActions();
        boardBackground.setVisible(true);
    }

    private void prepareActionsBoard() {
        dice1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionRollDice();
            }
        });
        dice2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionRollDice();
            }
        });
    }


    private void actionRollDice() {
//        Player player1 = new Player("P1");
        int[] result = poobchis.getP1().getValueDice();
        dice1.setText(String.valueOf(result[0]));
        dice2.setText(String.valueOf(result[1]));
        int[] resultQUITAR = {5,5}; // TODO: quitar esto
        poobchis.play("P1", resultQUITAR,1); // TODO: nameNumber
        imageBoard.repaint();
    }

    public static void main(String[] args) {
        PoobchisGUI gui = new PoobchisGUI();
        guiAux = gui;
        gui.setVisible(true);
    }
}

