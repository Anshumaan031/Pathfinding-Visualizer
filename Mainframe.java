import org.w3c.dom.Node;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Random;


public class Mainframe extends JFrame {
    private int cells = 20;
    private int delay = 30;
    private double dense =  .5;
    private double density = (cells*cells)*.5;

    private final int MSIZE = 600;
    private int CSIZE = MSIZE/cells;
    //UTIL ARRAYS
    private String[] algorithms = {"Dijkstra","A*"};
    private String[] tools = {"Start","Finish","Wall", "Eraser"};
    //BOOLEANS
    private boolean solving = false;
    //UTIL

    //  Algorithm Alg = new Algorithm();
    Random r = new Random();

    //private Grid grid;
    private FormPanel formPanel;
    //BUTTON
    JButton searchB;
    JButton resetB;
    JButton genMapB;
    JButton clearMapB;
    //MAP
    Map canvas;
    //LABEL
    private JLabel sizeL;
    private JLabel cellsL;
    private JLabel delayL;
    private JLabel msl;
    private JLabel densityL;
    private JLabel algL;
    private JLabel toolL;
    private JLabel checkL;
    private JLabel lengthL;
    private JLabel obstacleL;

    //SLIDER
    JSlider size = new JSlider(1,5,2);
    JSlider speed = new JSlider(0,500);
    JSlider obstacles = new JSlider(1,100,50);

    //DROP DOWN
    JComboBox algorithmsBx = new JComboBox(algorithms);
    JComboBox toolBx = new JComboBox(tools);




    public Mainframe(){
        super("PathFinder Visuallization");
        setLayout(new BorderLayout());

        setSize(850,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);


        formPanel = new FormPanel();
        searchB = new JButton("Start Search");
        resetB = new JButton("Reset");
        genMapB = new JButton("Generate Map");
        clearMapB = new JButton("Clear Map");

        sizeL = new JLabel("Size");
        cellsL = new JLabel(cells+"x"+cells);
        delayL = new JLabel("Delay");
        msl = new JLabel(delay+"ms");
        densityL = new JLabel("");
        algL = new JLabel("Algorithms");
        toolL = new JLabel("Toolbox");
        checkL = new JLabel("Checks");
        lengthL = new JLabel("Path Length");
        obstacleL = new JLabel("Density");

        add(formPanel, BorderLayout.WEST);



        formPanel.setBorder(BorderFactory.createTitledBorder("Controls"));
        int space = 25;
        int buff = 45;

        formPanel.setLayout(null);
        formPanel.setBounds(10,10,210,700);

        searchB.setBounds(40,space, 120, 25);
        formPanel.add(searchB);
        space+=buff;

        resetB.setBounds(40,space,120,25);
        formPanel.add(resetB);
        space+=buff;

        genMapB.setBounds(40,space, 120, 25);
        formPanel.add(genMapB);
        space+=buff;

        clearMapB.setBounds(40,space, 120, 25);
        formPanel.add(clearMapB);
        space+=40;

        algL.setBounds(40,space,120,25);
        formPanel.add(algL);
        space+=25;

        algorithmsBx.setBounds(40,space, 120, 25);
        formPanel.add(algorithmsBx);
        space+=40;

        toolL.setBounds(40,space,120,25);
        formPanel.add(toolL);
        space+=25;

        toolBx.setBounds(40,space,120,25);
        formPanel.add(toolBx);
        space+=buff;

        sizeL.setBounds(15,space,40,25);
        formPanel.add(sizeL);
        size.setMajorTickSpacing(10);
        size.setBounds(60,space,100,25);
        formPanel.add(size);
        cellsL.setBounds(160,space,40,25);
        formPanel.add(cellsL);
        space+=buff;

        delayL.setBounds(15,space,50,25);
        formPanel.add(delayL);
        speed.setMajorTickSpacing(5);
        speed.setBounds(60,space,100,25);
        formPanel.add(speed);
        msl.setBounds(160,space,40,25);
        formPanel.add(msl);

        space+=buff;

        obstacleL.setBounds(15,space,100,25);
        formPanel.add(obstacleL);
        obstacles.setMajorTickSpacing(5);
        obstacles.setBounds(60,space,100,25);
        formPanel.add(obstacles);
        densityL.setBounds(15,space,100,25);
        formPanel.add(densityL);
        space+=buff;

        checkL.setBounds(15,space,100,25);
        formPanel.add(checkL);
        space+=buff;

        lengthL.setBounds(15,space,100,25);
        formPanel.add(lengthL);
        space+=buff;

        getContentPane().add(formPanel);

        canvas = new Map();
        canvas.setBounds(230, 10, MSIZE+1, MSIZE+1);
        getContentPane().add(canvas);


    }


    class Map extends JPanel {	//MAP CLASS

        public void paintComponent(Graphics g) {	//REPAINT
            super.paintComponent(g);

            for(int x = 0; x < cells; x++) {	//PAINT EACH NODE IN THE GRID
                for(int y = 0; y < cells; y++) {
                    g.setColor(Color.WHITE);
                    g.fillRect(x*CSIZE,y*CSIZE,CSIZE,CSIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(x*CSIZE,y*CSIZE,CSIZE,CSIZE);

                }
            }
        }
    }


}
