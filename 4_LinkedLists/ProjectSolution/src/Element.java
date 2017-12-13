// Brittni Watkins
// Unit 4: Linked Lists
// Project - Data Visualization
// Element Class

import processing.core.PApplet;

public class Element {
    PApplet p;

    private String name;
    private  String symbol;
    private int atomicNumber;
    private float atomicMass;
    private float density;

    private float x;
    private float y;
    private float size;
    private int color;

    public Element(PApplet p) {
        this.p = p;
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

    public void mapX(float minMass, float maxMass) {
        x = p.map(atomicMass, minMass, maxMass, 45, p.width-45);
    }

    public void mapY(float minDensity, float maxDensity) {
        y = p.map(density, minDensity, maxDensity, p.height - 45, 45);
    }

    public void display() {
        p.ellipse(x, y, 25, 25);
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
