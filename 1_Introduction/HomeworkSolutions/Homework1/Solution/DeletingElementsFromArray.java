// Brittni Watkins
// Unit 1: Introduction
// Homework 1 - Deleting Elements from an Array
// Homework Solution

public class DeletingElementsFromArray {

    public static void main(String[] args) {
        MyArray values = new MyArray(10);
        values.fill();
        System.out.println(values);

        System.out.println("remove value at index 0 ------------");
        values.removeValue(0);
        System.out.println(values);

        System.out.println("remove value at end of array -------");
        values.removeValue(values.getSize() - 1);
        System.out.println(values);

        System.out.println("remove value at index 5 ------------");
        values.removeValue(5);
        System.out.println(values);

        System.out.println("bounds checking -------------------------");
        values.removeValue(1000);
        values.removeValue(-5);
        System.out.println(values);
    }

}
