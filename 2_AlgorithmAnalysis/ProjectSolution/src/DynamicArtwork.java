// Brittni Watkins
// Unit 2: Algorithm Analysis
// Project Solution: Dynamic Artwork
// PApplet Class

import processing.core.PApplet;
import processing.core.PVector;

public class DynamicArtwork extends PApplet {
    private final int START_SCREEN = 0;
    private final int ART_SCREEN = 1;
    private int screen;
    private Shape[] shapes;

    public void setup() {
        shapes = new Shape[100];

        for (int i = 0; i < shapes.length; i++) {
            int type = (int)random(1000);
            float x = random(10, width - 10);
            float y = random(10, height - 10);
            float r = random(10, 50);
            float xSpeed = random(-5, 5);
            float ySpeed = random(-5, 5);

            if (type % 3 == 0) {
                shapes[i] = new Circle(this, new PVector(x, y), new PVector(xSpeed, ySpeed), r, color(0, 255, 0));
            } else if (type % 3 == 1) {
                shapes[i] = new Square(this, new PVector(x, y), new PVector(xSpeed, ySpeed), r, color(0, 0, 255));
            } else if (type % 3 == 2) {
                shapes[i] = new Star(this, new PVector(x, y), new PVector(xSpeed, ySpeed), r, color(255, 0, 0));
            }

        }

        screen = START_SCREEN;
    }

    public void draw() {

        if (screen == START_SCREEN) {
            background(255);
            textAlign(CENTER, CENTER);
            textSize(50);
            fill(0);
            text("Welcome!", width / 2, height / 2 - 55);
            textSize(17);
            text("Click to move all of the shapes to the center of the screen.", width / 2, height / 2);
            text("Press any key to randomize the color of the shapes.", width / 2, height / 2 + 30);
            text("Click to continue.", width / 2, height / 2 + 65);
        } else if (screen == ART_SCREEN) {
            background(0);

            for (Shape s: shapes) {
                s.display();
                s.move();
            }

        }

    }

    public void settings() {
        size(displayWidth, displayHeight);
    }

    public void keyPressed() {

        if (screen == ART_SCREEN) {

            for (Shape s: shapes) {
                s.setColor(color(random(255), random(255), random(255)));
            }

        }

    }

    public void mousePressed() {

        if (screen == START_SCREEN) {
            screen = ART_SCREEN;
        } else if (screen == ART_SCREEN) {

            for (Shape s: shapes) {
                s.setPosition(new PVector(width / 2, height / 2));
            }

        }

    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "DynamicArtwork" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }

}
