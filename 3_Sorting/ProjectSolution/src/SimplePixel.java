// Brittni Watkins
// Unit 3: Sorting
// Project - Sorting Objects
// Simple Pixel Class

public class SimplePixel {
    private int r;
    private int g;
    private int b;

    public SimplePixel() {
        r = 0;
        g = 0;
        b = 0;
    }

    public SimplePixel(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    // GETTERS

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public String toString() {
        String out = "SimplePixel: " + "\n";
        out += "    r = " + r + "\n";
        out += "    g = " + g + "\n";
        out += "    b = " + b + "\n";
        return out;
    }
}
