import processing.core.PApplet;

public class Block {
    private int x;
    private int y;
    private float size;
    private int color;
    public boolean wall;
    public boolean checked;
    public boolean left;
    public boolean right;
    public boolean up;
    public boolean down;
    private PApplet p;

    public Block(PApplet p) {
        this.p = p;
        x = 0;
        y = 0;
        size = 10;
        color = p.color(0);
        wall = false;
        checked = false;
        up = false;
        right = false;
        down = false;
        left = false;
    }

    public Block(PApplet p, int x, int y, float size) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.size = size;
        color = p.color(0);
        wall = false;
        checked = false;
        up = false;
        right = false;
        down = false;
        left = false;
    }

    public Block(PApplet p, int x, int y, float size, boolean wall) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.size = size;
        this.wall = wall;

        if (wall) {
            color = p.color(0);
        } else {
            color = p.color(255);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
        if (wall) {
            color = p.color(0);
        } else {
            color = p.color(255);
        }
    }

    public void setColor(int color) {
        this.color = color;
    }


    public void display() {
        p.noStroke();
        p.fill(color);
        p.rect(x * size, y * size, size, size);
    }



}
