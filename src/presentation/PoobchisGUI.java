package presentation;

import domain.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PoobchisGUI extends JFrame {

    private static final Dimension PREFERRED_DIMENSION = new Dimension(1200,1000);

    // Poobchis
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
    // Dices
    private String diceLegend ="";
    private HashMap<String,String> dicesStyleRoute = new HashMap<String,String>();

    // labels
    private JLabel playerTurn, power, successPiece;
    // SIZES
    public static final int SIDE=20;

    public static final int LENGTH=20;

    /*Panel buttonAdd*/
    private JTextField textCode;
    private JTextField textName;
    private JTextField textCredits;
    private JTextArea textResults;



    private PoobchisGUI() {
        poobchis = new Poobchis();
        initializeDiceRoutes();
        prepareElements();
        prepareActions();
    }

    /**
     * Prepare base elements
     */
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

    /**
     * Prepare elements menu
     */
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


    /**
     * Prepare elements board
     */
    private void prepareElementsBoard() {
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

        playerTurn = new JLabel("PLAYER " +  poobchis.player());
        successPiece = new JLabel("PIECES WON " +  poobchis.getSuccessPiece());
        if (diceLegend == null || diceLegend.equals("") ) diceLegend="crown";
        Icon iconA = new ImageIcon(dicesStyleRoute.get(diceLegend));

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
        southButtons.add(successPiece);
        southButtons.add(dice1);
        southButtons.add(dice2);
        power = new JLabel("POWER");
        String powerRoute = "";
        if (powers.size()>=1) powerRoute = "images/powers/jumper.png";
        Icon iconPower = new ImageIcon(powerRoute);
        powerful = new JButton();
        powerful.setIcon(iconPower);
        powerful.setBackground(Color.white);
        southButtons.add(power);
        southButtons.add(powerful);
        boardBackground.add(southButtons, BorderLayout.SOUTH);

        JPanel boardImg = new JPanel();
        imageBoard = new BoardView(this, poobchis.getBoard().buildMatrix());
        // Piece
        JPanel boardImg2 = new JPanel();
        ImageIcon imgPiece = new javax.swing.ImageIcon(dicesStyleRoute.get(diceLegend));
        JLabel imagePiece = new javax.swing.JLabel(imgPiece);
        boardImg.add(imageBoard);
        boardImg2.add(imagePiece);
        boardImg2.setBounds(500,500,300,300);
        boardBackground.add(boardImg, BorderLayout.CENTER);
    }

    /**
     * Prepare home elements
     */
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

    /**
     * prepare elements Choose modes (PvP | PvM)
     */
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
        homeButtons.add(buttonMode1);
        buttonMode2 = new JButton("PvM Mode");
        buttonMode2.setBackground(Color.decode("#c69275"));
        homeButtons.add(buttonMode2);
        chooseModes.add(homeButtons, BorderLayout.CENTER);
    }


    /**
     * Prepare elements settings mode PvP
     */
    private void prepareElementsSettingsMode1() {
        mode1 = new JPanel();
        mode1.setLayout(new BorderLayout(Toolkit.getDefaultToolkit().getScreenSize().width/9, 5));
        add(mode1);

        JPanel homeNorth = new JPanel();
        JLabel titleMode = new JLabel("Mode 1 ");
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

    /**
     * Dice routes  initialization
     */
    private void initializeDiceRoutes(){
        dicesStyleRoute.put("revolver","images/dices/design.png");
        dicesStyleRoute.put("skull","images/dices/design2.png");
        dicesStyleRoute.put("Horse","images/dices/design3.png");
        dicesStyleRoute.put("cosmic astronaut","images/dices/design4.png");
        dicesStyleRoute.put("Lucky horseShoe","images/dices/design5.png");
        dicesStyleRoute.put("crown","images/dices/design6.png");
        dicesStyleRoute.put("little cow","images/dices/design7.png");

    }


    /**
     * Prepare actions
     */
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


        // Modes
        prepareActionsButtonsChooseModes();

        // Mode 1 buttons
        prepareActionsSettingsMode1();

        // Dices
        prepareActionsBoard();

    }

    /**
     * Prepare actions menu
     */
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
        // New option
        newGame.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionNewPoobchis();
            }
        });


    }

    /**
     * New window game
     */
    private void actionNewPoobchis(){
        PoobchisGUI poobchisito =new PoobchisGUI();
        poobchisito.setVisible(true);
    }

    /**
     * Open action
     */
    private void actionOpen(){
        try {
            JFileChooser filepath = new JFileChooser();
            filepath.setFileFilter(new FileNameExtensionFilter(null, "dat"));
            filepath.showDialog(null, "Open file");
            filepath.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            poobchis = MenuOptions.getMenuOptions().open(filepath.getSelectedFile());
            imageBoard.repaint();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * Prepare action buttons
     */
    private void prepareActionsButtons() {
        buttonStart.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goToChooseModes();
//                goToBoard();
            }
        });

        buttonRules.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionRules();
            }
        });

        buttonExit.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionExit();
            }
        });

    }

    /**
     * Prepare actions from choose modes buttons
     */
    private void prepareActionsButtonsChooseModes() {
        buttonMode1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goToSettingsMode1();
            }
        });

        buttonMode2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goToBoard();
            }
        });
    }

    /**
     * Rules action
     */
    private void actionRules(){
        JLabel daRules = new JLabel(DaRules.RULES);
        //Create a JPanel
        JPanel panel=new JPanel();
        panel.add(daRules);
//        JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollPane scrollBar=new JScrollPane(panel);
        JFrame frame=new JFrame("AddScrollBarToJFrame");
        frame.add(scrollBar);
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    /**
     * Adding checkbox
     * @param d
     */
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

    /**
     * Action of check Box Power
     */
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

    /**
     * @param d
     */
    private void actionCheckedOkBoxPower(JDialog d) {

        for (JCheckBox c : checkBoxList ) {
            if (c.isSelected()) {
                powers.add(c.getText());
            }
        }
        poobchis.setPowerPieces(powers.get(0));
        d.setVisible(false);
    }
    /**
     * Prepare elements in Settings Mode 1
     */
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
                String[] dicesStyles = {"revolver","skull","Horse","cosmic astronaut","Lucky horseShoe", "crown","little cow"};
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
                            diceLegend = data;
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

    /**
     * Action save
     * */
    private void actionSave() {
        try {
            JFileChooser filepath = new JFileChooser();
            filepath.setFileFilter(new FileNameExtensionFilter(null, "dat"));
            filepath.showDialog(null, "Save");
            filepath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            MenuOptions.getMenuOptions().save(filepath.getSelectedFile(), poobchis);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Action exit
     * */
    private void actionExit(){
        int confirmation= JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confirmacion",JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == confirmation){
            System.exit(0);
        }
    }
    /**
     * Confirm if get out
     * */
    private void outConfirmation() {
        if (JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)  System.exit(0) ;
    }

    /**
     * Go to option choose Modes
     * */
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
        home.setVisible(true);
    }
    /**
     * Go to Board
     * */
    private void goToBoard() {
        mode1.setVisible(false);
        chooseModes.setVisible(false);
        prepareElementsBoard();
        prepareActions();
        boardBackground.setVisible(true);
    }

    /**
     * Prepare actions on Board
     * */
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

    /**
     * Execute action Roll the Dice
     * */
    private void actionRollDice() {
        int[] result = poobchis.getP1().getValueDice();
        dice1.setText(String.valueOf(result[0]));
        dice2.setText(String.valueOf(result[1]));
        preparePieceDiceElements("1",result[0], result);
        preparePieceDiceElements("2", result[1], result);
//        int nameNumber = 1;
//        poobchis.play("P1", result,nameNumber,1);
        imageBoard.repaint();
        playerTurn.setText("PLAYER "+poobchis.player());
        successPiece.setText("PIECES WON " +  poobchis.getSuccessPiece());
    }
    /**
     * prepare the piece elements
     * @param dice
     * @param result
     * @param results
     * */
    public void preparePieceDiceElements(String dice, int result, int[] results){
        Frame frame = new JFrame();
        // Create the label
        JLabel label = new JLabel("Which of the following pieces would you like to move " + result +" steps ?", JLabel.CENTER);
        label.setBounds(0,0,380,95);
        int[] namesP = poobchis.getNumPieceList();
        // Create the radio buttons
        JRadioButton btn1 = new JRadioButton("Piece " + namesP[0]);
        JRadioButton btn2 = new JRadioButton("Piece " + namesP[1]);
        JRadioButton btn3 = new JRadioButton("Piece " + namesP[2]);
        JRadioButton btn4 = new JRadioButton("Piece " + namesP[3]);
        // Set the position of the radio buttons
        btn1.setBounds(40,60,200,50);
        btn2.setBounds(40,100,200,50);
        btn3.setBounds(40,140,200,50);
        btn4.setBounds(40,180,200,50);
        // Add radio buttons to group
        ButtonGroup bg = new ButtonGroup();
        bg.add(btn1);
        bg.add(btn2);
        bg.add(btn3);
        bg.add(btn4);
        JButton btn = new JButton("OK");
        btn.setBounds(40,250,200,50);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String playerTurn = poobchis.player();
                int[] namesP = poobchis.getNumPieceList();
                if(btn1.isSelected()){
                    poobchis.play(playerTurn, results,namesP[0],result);
                }else if (btn2.isSelected()) {
                    poobchis.play(playerTurn, results,namesP[1],result);
                }else if(btn3.isSelected()){
                    poobchis.play(playerTurn, results,namesP[2],result);
                }else if(btn4.isSelected()){
                    poobchis.play(playerTurn, results,namesP[3],result);
                }else{
                    poobchis.play(playerTurn, results,namesP[0],result);
                }
                frame.setVisible(false);
                imageBoard.repaint();
            }
        });
        // Add buttons to frame
        frame.add(label);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn);

        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    /**
     * main function
     * @param args
     * */
    public static void main(String[] args) {
        PoobchisGUI gui = new PoobchisGUI();
        gui.setVisible(true);
    }
}

