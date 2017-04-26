// Brittni Watkins
// Unit 3 - Sorting
// Project Solution - Sorting Objects
// Simple Pixel Class

public class SimplePixel {
    private int r;
    private int g;
    private int b;

    // Percentages
    private float rP; // percentage of red
    private float gP; // percentage of green
    private float bP; // percentage of blue

    public SimplePixel() {
        r = 0;
        g = 0;
        b = 0;
        calculatePercentages();
    }

    public SimplePixel(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        calculatePercentages();
    }

    private void calculatePercentages() {
        float total = r + g + b;

        if (total != 0) {
            rP = r / total;
            gP = g / total;
            bP = b / total;
        } else {
            rP = 0;
            gP = 0;
            bP = 0;
        }

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

    public float getRP() {
        return rP;
    }

    public float getGP() {
        return gP;
    }

    public float getBP() {
        return bP;
    }

    public String toString() {
        String out = "SimplePixel: " + "\n";
        out += "    r = " + r + "\n";
        out += "    g = " + g + "\n";
        out += "    b = " + b + "\n";
        out += "    rP = " + rP + "\n";
        out += "    gP = " + gP + "\n";
        out += "    bP = " + bP + "\n";
        return out;
    }
}
