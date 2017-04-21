import processing.core.*;

public class Book {
    PApplet p;

    private int size;
    private String title;
    private String author;
    private int year;
    private int fillColor;

    Book(PApplet p) {
        this.p = p;
        size = 50;
        title = "";
        author = "";
        year = 0;
        int r = (int)p.random(255);
        int g = (int)p.random(255);
        int b = (int)p.random(255);
        fillColor = p.color(r, g, b);
    }

    Book(PApplet p, String title, String author, int year, int maxSize) {
        this.p = p;
        this.title = title;
        this.author = author;
        this.year = year;
        size = (int)p.random(10, maxSize);
        int r = (int)p.random(255);
        int g = (int)p.random(255);
        int b = (int)p.random(255);
        fillColor = p.color(r, g, b);
    }

    public void display(int x, int y, int maxSize, String text) {
        p.noStroke();
        p.fill(fillColor);
        p.ellipse(x, y, size, size);
        p.textAlign(p.CENTER);
        p.fill(0);
        p.text(text, x, y + maxSize / 2);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public int getSize() {
        return size;
    }

}
