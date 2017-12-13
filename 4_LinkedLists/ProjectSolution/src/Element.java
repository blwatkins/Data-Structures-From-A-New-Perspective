// Brittni Watkins
// Unit 4: Linked Lists
// Project - Data Visualization
// Element Class

import processing.core.PApplet;

public class Element {
    private PApplet p;

    private String name;
    private  String symbol;
    private int atomicNumber;
    private float atomicMass;
    private float density;

    private float originalX;
    private float originalY;
    private float x;
    private float y;
    private float r;
    private int color;

    private boolean highlight;

    public Element(PApplet p) {
        this.p = p;
        name = "";
        symbol = "";
        atomicNumber = -1;
        atomicMass = -1;
        density = -1;
        x = 0;
        y = 0;
        r = 10;
        color = p.color(0);
        highlight = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setAtomicNumber(int atomicNumber) {
     this.atomicNumber = atomicNumber;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicMass(float atomicMass) {
        this.atomicMass = atomicMass;
    }

    public float getAtomicMass() {
        return atomicMass;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public float getDensity() {
        return density;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public void mapX(int minNum, int maxNum) {
        x = p.map(atomicNumber, minNum, maxNum, 45, p.width - 45);
        originalX = x;
    }

    public void mapY(float minDensity, float maxDensity) {
        y = p.map(density, minDensity, maxDensity, p.height - 45, 45);
        originalY = y;
    }

    public void mapR(float minMass, float maxMass) {
        r = p.map(atomicMass, minMass, maxMass, 10, 50);
    }

    public void mapColor() {
        float h;
        float s;

        if (symbol.length() == 1) {
            h = p.map((int)symbol.charAt(0), (int)'A', (int)'Z', 0, 255);
            s = 255;
        } else {
            h = p.map((int)symbol.charAt(0), (int)'A', (int)'Z', 0, 255);
            s = p.map((int)symbol.charAt(1), (int)'a', (int)'z', 50, 255);
        }

        color = p.color(h, s, 250);
    }

    public void display() {

        if (highlight) {
            p.strokeWeight(3);
            p.stroke(42, 255, 255);
        } else {
            p.noStroke();
        }

        p.fill(color, 200);
        p.ellipse(x, y, r * 2, r * 2);
    }

    public void randomWalk() {
        int rand = (int)p.random(1000);

        if (rand % 4 == 0) {
            x += 1;
        } else if (rand % 4 == 1) {
            x -= 1;
        } else if (rand % 4 == 2) {
            y += 1;
        } else if (rand % 4 == 3) {
            y -= 1;
        }

    }

    public boolean mouseOver() {
        float d = p.dist(x, y, p.mouseX, p.mouseY);

        if (d < r) {
            return true;
        } else {
            return false;
        }

    }

    public void reset() {
        x = originalX;
        y = originalY;
    }

    public String toString() {
        String out = "Element: " + '\n';
        out += "    name = " + name + '\n';
        out += "    symbol = " + symbol + '\n';
        out += "    atomicNumber = " + atomicNumber + '\n';
        out += "    atomicMass = " + atomicMass + '\n';
        out += "    density = " + density + '\n';
        return out;
    }

}
