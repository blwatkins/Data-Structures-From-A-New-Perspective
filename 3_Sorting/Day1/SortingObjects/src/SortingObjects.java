// Brittni Watkins
// Sorting Objects Lecture Example

import processing.core.*;

import java.util.Arrays;

public class SortingObjects extends PApplet {
    private String[] titles = {"The Hunchback of Notre Dame", "Pride and Prejudice", "Don Quixote", "Wuthering Heights",
            "To Kill a Mockingbird", "Brave New World", "A Tale of Two Cities"};
    private String[] authors = {"Victor Hugo", "Jane Austen", "Miguel de Cervantes Saavedra", "Emily Bronte", "Harper Lee",
            "Aldous Huxley", "Charles Dickens"};
    private int[] years = {1831, 1813, 1605, 1847, 1960, 1932, 1859};

    private Book[] books;
    private Book[] booksByTitle;
    private Book[] booksByYear;
    private Book[] booksByAuthor;
    private Book[] booksBySize;

    private int xSpacing;
    private int ySpacing;

    public void setup() {
        xSpacing = width / titles.length;
        ySpacing = height / 5;

        books = createBooks(titles, authors, years);

        booksByTitle = Arrays.copyOf(books, books.length);
        Arrays.sort(booksByTitle, BookComparator.Title);

        booksByYear = Arrays.copyOf(books, books.length);
        Arrays.sort(booksByYear, BookComparator.Year);

        booksByAuthor = Arrays.copyOf(books, books.length);
        Arrays.sort(booksByAuthor, BookComparator.Author);

        booksBySize = Arrays.copyOf(books, books.length);
        Arrays.sort(booksBySize, BookComparator.Size);
    }

    public void draw() {
        background(200);
        translate(0, (ySpacing - 55) / 2);
        displayBooks(books, 0, "title");
        displayBooks(booksByTitle,  ySpacing, "title");
        displayBooks(booksByYear, 2 * ySpacing, "year");
        displayBooks(booksByAuthor, 3 * ySpacing, "author");
        displayBooks(booksBySize, 4 * ySpacing, "size");
    }

    public void settings() {
        size(displayWidth, displayHeight);
    }

    private Book[] createBooks(String[] titles, String[] authors, int[] years) {
        Book[] books = new Book[titles.length];

        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(this, titles[i], authors[i], years[i], min(xSpacing - 45, ySpacing - 45));
        }

        return books;
    }

    private void displayBooks(Book[] books, int y, String display) {

        switch (display) {

            case "title":

                for (int i = 0; i < books.length; i++) {
                    books[i].display((i * xSpacing) + (xSpacing / 2), y, ySpacing - 40, books[i].getTitle());
                }

                break;

            case "year":

                for (int i = 0; i < books.length; i++) {
                    books[i].display((i * xSpacing) + (xSpacing / 2), y, ySpacing - 40, str(books[i].getYear()));
                }

                break;

            case "author":

                for (int i = 0; i < books.length; i++) {
                    books[i].display((i * xSpacing) + (xSpacing / 2), y, ySpacing - 40, books[i].getAuthor());
                }

                break;

            case "size":

                for (int i = 0; i < books.length; i++) {
                    books[i].display((i * xSpacing) + (xSpacing / 2), y, ySpacing - 40, str(books[i].getSize()));
                }

                break;

            default:

                for (int i = 0; i < books.length; i++) {
                    books[i].display((i * xSpacing) + (xSpacing / 2), y, ySpacing - 40, books[i].getTitle());
                }

                break;

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
