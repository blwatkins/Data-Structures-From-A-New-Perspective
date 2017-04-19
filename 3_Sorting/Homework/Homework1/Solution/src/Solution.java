// Brittni Watkins
// Unit 3 - Sorting
// Homework 1 Solution

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

public class Solution extends PApplet {
    String filename;
    String[] rawText;

    public void setup() {
        filename = "test.txt";
        rawText = getText(filename);
    }

    public void draw() {

    }
    public void settings() {
        //size(displayWidth, displayHeight);
        size(500, 500);
    }

    String[] getText(String file) {
        String[] lines = loadStrings(file);
        ArrayList<String> text = new ArrayList<>();

        for (String line: lines) {
            String[] lineText = splitTokens(line);

            for (String token: lineText) {
                text.add(token);
            }

        }

        String[] textArray = new String[text.size()];
        textArray = text.toArray(textArray);

        return textArray;
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "Solution" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }
}
