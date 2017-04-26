// Brittni Watkins
// Unit 3 - Sorting
// Project Solution - Sorting Objects
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

public class SortingObjects extends PApplet {
    private  ArrayList<SimplePixel> rawPixels;
    private ArrayList<SimplePixel> sortedPixels;

    public void setup() {
        PImage image = loadImage("red_flowers.jpg");
        rawPixels = new ArrayList<>();
        sortedPixels = new ArrayList<>();

        image.loadPixels();
        for (int i = 0; i < image.pixels.length; i++) {
            int c = image.pixels[i];
            int r = (int)red(c);
            int g = (int)green(c);
            int b = (int)blue(c);

            rawPixels.add(new SimplePixel(r, g, b));
        }
    }

    public void draw() {
        drawPixels(rawPixels);
    }

    private void drawPixels(ArrayList<SimplePixel> simplePixels) {
        loadPixels();
        for (int i = 0; i < width * height; i++) {
            if (i < simplePixels.size()) {
                SimplePixel p = simplePixels.get(i);
                int c = color(p.getR(), p.getG(), p.getB());
                pixels[i] = c;
            } else {
                pixels[i] = color(0);
            }
        }
        updatePixels();
    }

    public void settings() {
        size(800, 800);
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "SortingObjects" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }

}

