// Brittni Watkins
// Unit 5 - Stacks and Queues
// Project Solution - Self-Solving Maze
// Main Program

import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

import java.util.Stack;

public class SelfSolvingMaze extends PApplet {
    private Block[][] blocks;
    private Stack<Block> player;

    private int cols;
    private Block begin;
    private Block end;

    private int x;
    private int y;

    public void setup() {

        String[] mazeRows = loadStrings("maze20.txt");
        cols = mazeRows[0].length();
        float size = width / cols;

        blocks = new Block[cols][cols];

        player = new Stack<>();

        for (int i = 0; i < mazeRows.length; i++) {
            String row = mazeRows[i];
            for (int j = 0; j < row.length(); j++) {
                Block b = new Block(this, j, i, size);
                if (row.charAt(j) == 'w') {
                    b.setWall(true);
                } else if (row.charAt(j) == 'o') {
                    b.setWall(false);
                } else if (row.charAt(j) == 'b') {
                    begin = b;
                } else if (row.charAt(j) == 'e') {
                    end = b;
                }
                blocks[i][j] = b;
            }
        }

        begin.setColor(color(0, 255, 0));
        end.setColor(color(0, 255, 0));

        x = begin.getX();
        y = begin.getY();

    }

    public void draw() {
        for (Block[] bs: blocks) {
            for (Block b: bs) {
                b.display();
            }
        }

        if (player.size() > 0 && player.peek() != end || player.size() == 0) {

            if (frameCount % 5 == 0) {
                getBlock(x, y);

                Block b = player.peek();
                x = b.getX();
                y = b.getY();

                if (!b.up) {
                    y--;
                    b.up = true;
                } else if (!b.right) {
                    x++;
                    b.right = true;
                } else if (!b.down) {
                    y++;
                    b.down = true;
                } else if (!b.left) {
                    x--;
                    b.left = true;
                } else {
                    Block bn = player.pop();
                    bn.setColor(color(255));
                }
            }
        }

    }

    private void getBlock(int j, int i) {
        if (i >= 0 && i < cols && j >= 0 && j < cols) {
            Block b = blocks[i][j];
            if (!b.checked && !b.wall) {
                player.push(b);
                b.setColor(color(255, 0, 255));
                b.checked = true;
            }
        }
    }

    public void settings() {
        size(600, 600);
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "SelfSolvingMaze" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }
}