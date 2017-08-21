// Brittni Watkins
// Unit 2: Algorithm Analysis
// Project - Dynamic Artwork
// Shape Class

import processing.core.PApplet;
import processing.core.PVector;

public abstract class Shape {
    protected PApplet p;
    protected PVector pos;
    protected PVector speed;
    protected DimVector dims;
    protected int col;

    protected Shape() {
        p = null;
        pos = new PVector(0, 0);
        speed = new PVector(0, 0);
        dims = new DimVector();
        col = 0;
    }

    public Shape(PApplet p) {
        this.p = p;
        pos = new PVector(0, 0);
        speed = new PVector(0, 0);
        dims = new DimVector();
        col = p.color(0);
    }

    public Shape(PApplet p, PVector pos, PVector speed, DimVector dims) {
        this.p = p;
        this.pos = new PVector(pos.x, pos.y);
        this.speed = new PVector(speed.x, speed.y);
        this.dims = new DimVector(dims);
        this.col = p.color(0);
    }

    public Shape(PApplet p, PVector pos, PVector speed, DimVector dims, int col) {
        this.p = p;
        this.pos = new PVector(pos.x, pos.y);
        this.speed = new PVector(speed.x, speed.y);
        this.dims = new DimVector(dims);
        this.col = col;
    }

    public void setColor(int col) {
        this.col = col;
    }

    public void setPosition(PVector pos) {
        this.pos.set(pos);
    }

    public abstract void display();

    public void move() {
        pos.x += speed.x;
        pos.y += speed.y;

        if (pos.x > p.width) {
            speed.x = p.random(-5, -1);
        } else if (pos.x < 0) {
            speed.x = p.random(1, 5);
        }

        if (pos.y > p.height) {
            speed.y = p.random(-5, -1);
        } else if (pos.y < 0) {
            speed.y = p.random(1, 5);
        }

    }

    protected int applyAlpha(int alpha, int col) {
        float r = p.red(col);
        float g = p.green(col);
        float b = p.blue(col);
        return p.color(r, g, b, alpha);
    }

}
