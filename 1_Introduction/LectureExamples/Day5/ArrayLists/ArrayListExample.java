// Brittni Watkins
// Unit 1: Introduction
// Day 5 - Basic Data Structures, Arrays and ArrayLists
// Array List Example
// Access, insert, delete

public class ArrayListExample {

    public static void main(String[] args) {
        MyArrayList values = new MyArrayList();
        values.fill(10);
        System.out.println(values);

        System.out.println("get value at index 6 --------------------");
        System.out.println(values.getValue(6));
        System.out.println();

        System.out.println("insert value 1000 at index 0 ------------");
        values.insertValue(1000, 0);
        System.out.println(values);

        System.out.println("insert value 5000 at end of array -------");
        values.insertValue(5000, values.getSize());
        System.out.println(values);

        System.out.println("insert value 7000 at index 5 ------------");
        values.insertValue(7000, 5);
        System.out.println(values);

        System.out.println("remove value at index 0 -----------------");
        values.removeValue(0);
        System.out.println(values);

        System.out.println("remove value at index 2 -----------------");
        values.removeValue(2);
        System.out.println(values);

        System.out.println("remove value at end of array ------------");
        values.removeValue(values.getSize() - 1);
        System.out.println(values);

        System.out.println("bounds checking insertValue -------------");
        values.insertValue(8000, 1000);
        values.insertValue(9000, -5);
        System.out.println();

        System.out.println("bounds checking removeValue -------------");
        values.removeValue(65);
        values.removeValue(-1);
        System.out.println();

        System.out.println("bounds checking getValue ----------------");
        System.out.println(values.getValue(-10));
        System.out.println(values.getValue(25));
        System.out.println();

        System.out.println(values);
    }

}