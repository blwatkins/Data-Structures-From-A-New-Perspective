// Brittni Watkins
// 15 March 2017
// Project Solution: Dynamic Artwork
// Star Class

import processing.core.PApplet;
import processing.core.PVector;

public class Star extends Shape{
    private PVector[] points;

    private Star() {
        super();
    }

    public Star(PApplet p) {
        super(p);
    }

    public Star(PApplet p, PVector pos, PVector speed, float d, int col) {
        super(p, pos, speed, new DimVector(d, d), col);
        this.col = applyAlpha(175, col);
        _init();
    }

    private void _init() {
        points = new PVector[10];

        float theta = 0;
        for (int i = 0; i < points.length; i++) {
            float x = 0;
            float y = 0;

            if (i % 2 == 0) {
                x = dims.w / 2 * PApplet.cos(theta);
                y = dims.h / 2 * PApplet.sin(theta);
            } else {
                x = (dims.w / 4) * PApplet.cos(theta);
                y = (dims.h / 4) * PApplet.sin(theta);
            }
            points[i] = new PVector(x, y);

            theta += PApplet.TWO_PI / points.length;
        }
    }

    public void setColor(int col) {
        this.col = applyAlpha(175, col);
    }

    public void display() {
        p.noStroke();
        p.fill(col);
        p.pushMatrix();
        p.translate(pos.x, pos.y);
        p.beginShape();
        for (PVector point: points) {
            p.vertex(point.x, point.y);
        }
        p.endShape(PApplet.CLOSE);
        p.popMatrix();
    }
}
