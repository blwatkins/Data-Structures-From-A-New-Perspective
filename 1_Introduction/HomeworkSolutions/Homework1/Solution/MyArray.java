// Brittni Watkins
// Unit 1: Introduction
// Homework 1 - Deleting Elements from an Array
// Homework Solution
// Array Class

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

        if (index >= 0 && index < array.length) {
            int[] temp = new int[array.length - 1];

            if (index == 0) {

                for (int i = 1; i < array.length; i++) {
                    temp[i - 1] = array[i];
                }

            } else if (index == array.length - 1) {

                for (int i = 0; i < array.length - 1; i++) {
                    temp[i] = array[i];
                }

            } else {

                for (int i = 0; i < array.length - 1; i++) {

                    if (i < index) {
                        temp[i] = array[i];
                    } else if (i >= index) {
                        temp[i] = array[i + 1];
                    }

                }

            }

            array = temp;
        } else {
            System.out.println("ERROR: Invalid Index");
        }

    }

    public String toString() {
        String out = "Array: " + "\n";

        for (int i = 0; i < array.length; i++) {
            out += "    " + i + ": " + array[i] + "\n";
        }

        return out;
    }

}