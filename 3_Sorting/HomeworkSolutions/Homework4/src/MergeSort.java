// Brittni Watkins
// Unit 3 - Sorting
// Homework 4 - Merge Sort Implementation Solution
// Text Sources
    // Wordsworth -> http://www.gutenberg.org/cache/epub/8905/pg8905.txt
    // Poe -> http://www.gutenberg.org/cache/epub/10031/pg10031.txt
    // Poe -> http://www.gutenberg.org/cache/epub/1063/pg1063.txt
    // Dickinson -> http://www.gutenberg.org/cache/epub/2679/pg2679.txt
    // Teasdale -> http://www.gutenberg.org/cache/epub/442/pg442.txt

// Text files have been edited to help the circles fit better on the screen

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


import java.util.Arrays;

public class MergeSort extends PApplet {
    private String[] filenames = {"dickinson_1.txt", "dickinson_2.txt", "dickinson_3.txt", "poe_amontillado.txt",
            "poe_bells.txt", "poe_raven.txt", "teasdale_barter.txt", "teasdale_fountain.txt",
            "teasdale_twilight.txt", "wordsworth_animal.txt", "wordsworth_complaint.txt", "wordsworth_tables.txt",
            "dickinson.txt", "poe.txt", "teasdale.txt", "wordsworth.txt"};

    private String[] rawText;
    private String[] sortedText;
    private int maxStringLength;
    private int minStringLength;

    private int rows;
    private int cols;
    private float maxW;
    private float minW;
    private float maxH;
    private float minH;

    private int currentFileIndex;
    private int mode;

    private final int RAW = 0;
    private final int SORTED = 1;

    public void setup() {
        colorMode(HSB, 255);
        currentFileIndex = 0;
        mode = RAW;
        _init();
    }

    public void draw() {
        background(200);
        if (mode == RAW) {
            displayWords(rawText);
        } else if (mode == SORTED) {
            displayWords(sortedText);
        }
    }

    public void settings() {
        size(displayWidth, displayHeight);
    }

    public void keyPressed() {

        if (keyCode == RIGHT) {
            mode = RAW;
            currentFileIndex++;

            if (currentFileIndex >= filenames.length) {
                currentFileIndex = 0;
            }

            _init();
        } else if (keyCode == LEFT) {
            mode = RAW;
            currentFileIndex--;

            if (currentFileIndex < 0) {
                currentFileIndex = filenames.length - 1;
            }

            _init();
        }

    }

    public void mousePressed() {

        if (mode == RAW) {
            mode = SORTED;
            sortedText = mergeSort(rawText);
        } else if (mode == SORTED) {
            mode = RAW;
        }

    }

    private void _init() {
        rawText = getText(filenames[currentFileIndex]);

        int[] factors = findFactors(rawText.length);

        rows = min(factors[0], factors[1]);
        cols = max(factors[0], factors[1]);

        maxStringLength = getMaxLength(rawText);
        minStringLength = getMinLength(rawText);

        maxW = (float)width / cols;
        maxH = height / (rows + 0.5f);

        minW = maxW / 10;
        if (minW < 1) minW = 1;

        minH = maxH / 10;
        if (minH < 1) minH = 1;
    }

    private String[] getText(String file) {
        String[] lines = loadStrings(file);
        ArrayList<String> text = new ArrayList<>();

        for (String line: lines) {
            String[] lineText = splitTokens(line);
            text.addAll(Arrays.asList(lineText));
        }

        String[] textArray = new String[text.size()];
        textArray = text.toArray(textArray);

        return textArray;
    }

    private int[] findFactors(int num) {
        IntList factors = new IntList();

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors.append(i);
            }
        }

        int factor1_index = factors.size() / 2;
        int factor2_index = (factors.size() / 2) - 1;

        if (sqrt(num) == (int)(sqrt(num))) {
            factor2_index = factor1_index;
        }

        int[] maxFactors = new int[2];
        maxFactors[0] = factors.get(factor1_index);
        maxFactors[1] = factors.get(factor2_index);

        return maxFactors;
    }

    private int getMaxLength(String[] text) {
        int maxL = 0;

        for (String token: text) {
            maxL  = max(maxL, token.length());
        }

        return maxL;
    }

    private int getMinLength(String[] text) {
        int minL = text[0].length();

        for (String token: text) {
            minL = min(minL, token.length());
        }

        return minL;
    }

    private void displayWords(String[] text) {

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                String word = text[(i * cols) + j].toLowerCase();
                float ellipseW = map(word.length(), minStringLength, maxStringLength, minW, maxW);
                float ellipseH = map(word.length(), minStringLength, maxStringLength, minH, maxH);
                float ellipseX = (j * maxW) + (maxW / 2);
                float ellipseY = (i * maxH) + (maxH / 2);
                int hue = (int)map((int)word.charAt(0), (int)'a', (int)'z', 0, 255);

                fill(hue, 200, 200);
                noStroke();
                ellipse(ellipseX, ellipseY, ellipseW, ellipseH);
            }

        }

    }

    private String[] mergeSort(String[] text) {
        String[] sorted = Arrays.copyOf(text, text.length);
        return sorted;
    }


    private void swap(String[] text, int indexA, int indexB) {
        String temp = text[indexA];
        text[indexA] = text[indexB];
        text[indexB] = temp;
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "MergeSort" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }
}
