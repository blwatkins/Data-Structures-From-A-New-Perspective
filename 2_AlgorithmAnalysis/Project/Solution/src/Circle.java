// Brittni Watkins
// 15 March 2017
// Project Solution: Dynamic Artwork
// Circle Class

import processing.core.PApplet;
import processing.core.PVector;

public class Circle extends Shape {

    private Circle() {
        super();
    }

    public Circle(PApplet p) {
        super(p);
    }

    public Circle(PApplet p, PVector pos, PVector speed, float d, int col) {
        super(p, pos, speed, new DimVector(d, d));
        this.col = applyAlpha(100, col);
    }

    public void setColor(int col) {
        this.col = applyAlpha(100, col);
    }

    public void display() {
        p.noStroke();
        p.fill(col);
        p.ellipse(pos.x, pos.y, dims.w, dims.h);
    }

    public void move() {
        pos.x += p.random(-0.5f, 0.5f);
        pos.y += p.random(-0.5f, 0.5f);
    }

}
