// Brittni Watkins
// 15 March 2017
// Homework 1 Template
// Deleting Elements from an Array
// Array class

public class MyArray {
    private int[] array;

    MyArray() {
        array = null;
    }

    MyArray(int size) {
        array = new int[size];
    }

    public int getSize() {
        return array.length;
    }

    public void fill() {

        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }

    }

    public void removeValue(int index) {

    }

    public String toString() {
        String out = "Array: " + "\n";

        for (int i = 0; i < array.length; i++) {
            out += "    " + i + ": " + array[i] + "\n";
        }

        return out;
    }

}