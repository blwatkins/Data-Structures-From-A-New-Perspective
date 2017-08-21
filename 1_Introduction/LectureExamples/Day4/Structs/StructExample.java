// Brittni Watkins
// Unit 1: Introduction
// Day 4 - Basic Data Structures, Structs and Arrays
// Struct Example
// Creating and printing very simple class structures;

public class StructExample {

    public static void main(String[] args) {
        Book lesMis = new Book();
        lesMis.title = "Les Miserables";
        lesMis.author = "Victor Hugo";
        lesMis.publicationYear = 1862;

        Book prideAndPrejudice = new Book();
        prideAndPrejudice.title = "Pride and Prejudice";
        prideAndPrejudice.author = "Jane Austen";
        prideAndPrejudice.publicationYear = 1813;

        System.out.println(lesMis);
        System.out.println(prideAndPrejudice);
    }
    
}
