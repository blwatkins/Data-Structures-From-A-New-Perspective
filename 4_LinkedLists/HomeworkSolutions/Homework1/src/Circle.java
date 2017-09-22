// Brittni Watkins
// Unit 4: Linked Lists
// Homework 1 - Deleting Elements from a Linked List
// Circle Class

import processing.core.PApplet;
import processing.core.PVector;

public class Circle {
    private PApplet p;
    private PVector pos;
    private int color;
    private int size;

    public Circle(PApplet p) {
        this.p = p;
        pos = new PVector(0, 0);
        color = p.color(0);
        size = 25;
    }

    public Circle(PApplet p, PVector pos, int color) {
        this.p = p;
        this.pos = pos.copy();
        this.color = color;
        size = 25;
    }

    public void display() {
        p.noStroke();
        p.fill(color);
        p.ellipse(pos.x, pos.y, size, size);
    }

    public void displayInfo(int x, int y, int index) {

        if (mouseOver()) {
            p.fill(0);
            p.textAlign(p.CENTER);
            p.text(index + ": " + this, x , y);
        }

    }

    public boolean mouseOver() {
        float distance = p.dist(p.mouseX, p.mouseY, pos.x, pos.y);
        return distance < (size / 2);
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
