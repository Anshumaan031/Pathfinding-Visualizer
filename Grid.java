package com.company;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {
    public int cells = 20;
    public final int MSIZE = 600;
    public int CSIZE = MSIZE/cells;


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