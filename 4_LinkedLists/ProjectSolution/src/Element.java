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

    public void setDensity(float density) {
        this.density = density;
    }

    public String toString() {
        String out = "Element: " + '\n';
        out += "    name = " + name + '\n';
        out += "    symbol = " + symbol + '\n';
        out += "    atomicNumber = " + atomicNumber + '\n';
        out += "    atomicMass = " + atomicMass + '\n';
        return out;
    }


}
