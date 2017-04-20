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

import java.util.Arrays;

public class Solution extends PApplet {
    private String[] rawText;

    private int maxStringLength;
    private int minStringLength;

    private int rows;
    private int cols;

    private float maxW;
    private float minW;

    private float maxH;
    private float minH;

    public void setup() {
        colorMode(HSB, 255);
        String filename = "test.txt";
        rawText = getText(filename);

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

    public void draw() {

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                String word = rawText[(i * cols) + j].toLowerCase();
                float ellipseW = map(word.length(), minStringLength, maxStringLength, minW, maxW);
                float ellipseH = map(word.length(), minStringLength, maxStringLength, minH, maxH);
                float ellipseX = (j * maxW) + (maxW / 2);
                float ellipseY = (i * maxH) + (maxH / 2);
                int hue = (int)map((int)word.charAt(0), (int)'a', (int)'z', 0, 255);

                fill(hue, 200, 200);
                ellipse(ellipseX, ellipseY, ellipseW, ellipseH);
            }

        }

    }

    public void settings() {
        size(displayWidth, displayHeight);
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

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "Solution" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }
}
