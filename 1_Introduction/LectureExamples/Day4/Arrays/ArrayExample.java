// Brittni Watkins
// Unit 1: Introduction
// Day 4 - Basic Data Structures, Structs and Arrays
// Array Example
// Filling arrays, inserting values into arrays, and printing arrays

public class ArrayExample {

    public static void main(String[] args) {
        MyArray values = new MyArray(10); 
        values.fill();
        System.out.println(values);

        System.out.println("insert value 1000 at index 0 ------------");
        values.insertValue(1000, 0);
        System.out.println(values);

        System.out.println("insert value 5000 at end of array -------");
        values.insertValue(5000, values.getSize());
        System.out.println(values);

        System.out.println("insert value 7000 at index 5 ------------");
        values.insertValue(7000, 5);
        System.out.println(values);

        System.out.println("bounds checking -------------------------");
        values.insertValue(8000, 1000);
        values.insertValue(9000, -5);
        System.out.println(values);
    }
    
}