// Brittni Watkins
// 21 August 2017
// Circle Class

import processing.core.PApplet;
import processing.core.PVector;

public class Circle {
    private PApplet p;
    private PVector pos;
    private int color;

    public Circle(PApplet p) {
        this.p = p;
        pos = new PVector(0, 0);
        color = p.color(0);
    }

    public Circle(PApplet p, PVector pos, int color) {
        this.p = p;
        this.pos = pos.copy();
        this.color = color;
    }

    public void display() {
        p.noStroke();
        p.fill(color);
        p.ellipse(pos.x, pos.y, 25, 25);
    }

    public PVector getPos() {
        return pos;
    }

    public String toString() {
        String objString = "Circle: ";
        objString += "position = (" + (int)pos.x + ", " + (int)pos.y + "); ";
        objString += "color = (" + (int)p.red(color) + ", " + (int)p.green(color) + ", " + (int)p.blue(color) + ")";
        return objString;
    }

}
