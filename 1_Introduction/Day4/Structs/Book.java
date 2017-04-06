// Brittni Watkins
// 27 January 2017
// Struct Example
// Very simple class with overrided toString() method

public class Book {
    String title;
    String author;
    int publicationYear;

    //overriding typical object println() behavior
    public String toString() {
        String out = "Book: " + "\n";
        out += "  Title = " + title + "\n";
        out += "  Author = " + author + "\n";
        out += "  Publication Data = " + publicationYear;
        return out;
    }
    
}
