// Brittni Watkins
// Unit 1: Introduction
// Day 4 - Basic Data Structures, Structs and Arrays
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
