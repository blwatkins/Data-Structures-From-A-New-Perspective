// Brittni Watkins
// Sorting Objects Lecture Example

import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

import java.util.Arrays;

public class SortingObjects extends PApplet {
    String[] titles = {"The Hunchback of Notre Dame", "Pride and Prejudice", "Don Quixote", "Wuthering Heights",
            "To Kill a Mockingbird", "Brave New World", "A Tale of Two Cities"};
    String[] authors = {"Victor Hugo", "Jane Austen", "Miguel de Cervantes Saavedra", "Emily Bronte", "Harper Lee",
            "Aldous Huxley", "Charles Dickens"};
    int[] years = {1831, 1813, 1605, 1847, 1960, 1932, 1859};

    Book[] books;
    Book[] booksByTitle;

    int spacing;

    public void setup() {
        spacing = width / titles.length;
        books = createBooks(titles, authors, years);
        booksByTitle = Arrays.copyOf(books, books.length);
        Arrays.sort(booksByTitle, BookComparator.Title);
    }

    public void draw() {
        background(200);
        displayBooks(books, spacing / 2);
        displayBooks(booksByTitle, spacing * 2);
    }

    public void settings() {
        size(displayWidth, displayHeight);
    }

    private Book[] createBooks(String[] titles, String[] authors, int[] years) {
        Book[] books = new Book[titles.length];

        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(this, titles[i], authors[i], years[i], spacing);
        }

        return books;
    }

    private void displayBooks(Book[] books, int y) {

        for (int i = 0; i < books.length; i++) {
            books[i].display((i * spacing) + (spacing / 2), y, spacing, books[i].getTitle());
        }

    }


    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "SortingObjects" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }

}
