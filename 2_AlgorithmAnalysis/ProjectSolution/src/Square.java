// Brittni Watkins
// Unit 2: Algorithm Analysis
// Project - Dynamic Artwork
// Square Class

import processing.core.PApplet;
import processing.core.PVector;

public class Square extends Shape {

    private Square() {
        super();
    }

    public Square(PApplet p) {
        super(p);
    }

    public Square(PApplet p, PVector pos, PVector speed, float d, int col) {
        super(p, pos, speed, new DimVector(d, d));
        this.col = applyAlpha(120, col);
    }

    public void setColor(int col) {
        this.col = applyAlpha(120, col);
    }

    public void display() {
        p.noStroke();
        p.fill(col);
        p.rect(pos.x, pos.y, dims.w, dims.h);
    }

    public void move() {
        pos.x += speed.x;
        pos.y += speed.y;

        if (pos.x > p.width) {
            pos.x = 0;
        } else if (pos.x < 0) {
            pos.x = p.width;
        }

        if (pos.y > p.height) {
            pos.y = 0;
        } else if (pos.y < 0) {
            pos.y = p.height;
        }
    }

}
