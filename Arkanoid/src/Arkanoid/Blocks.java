package Arkanoid;

import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Blocks {

    private int blockwidth = 700;
    private int blockheight = 600;
    private int block[][];
    Rectangle test = new Rectangle();
    /*
        Sukuriamas blokų masyvas, kuriame saugome 1 ir 0; 1 reiškia, kad blokas 
        vis dar egzistuoja, 0 reiškia, kad bloką sunaikino.
     */
    public Blocks(int row, int col) {

        block = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                block[i][j] = 1;
            }
        }
        this.blockwidth = 560 / col;
        this.blockheight = 150 / row;
    }

    public void draw(Graphics2D g) { //Blokų piešimas g graphicks.
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[0].length; j++) {
                if (block[i][j] > 0) {
                    g.setColor(Color.orange);
                    g.fillRect((j - 1) * blockwidth + 80, blockheight * (i - 1) + 50, blockwidth, blockheight);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect((j - 1) * blockwidth + 80, blockheight * (i - 1) + 50, blockwidth, blockheight);
                }
            }
        }
    }

    public void Destroyed(int i, int j) {//Blokų "sunaikinimas"

        block[i][j] = 0;

    }

    public int getBlockwidth() {
        return blockwidth;
    }

    public int getBlockheight() {
        return blockheight;
    }

    public int[][] getBlock() {
        return block;
    }

}
