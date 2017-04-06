// Brittni Watkins
// 15 March 2017
// Array Class Example

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

    public String toString() {
        String out = "Array: " + "\n";

        for (int i = 0; i < array.length; i++) {
            out += "    " + i + ": " + array[i] + "\n";
        }

        return out;
    }

    public void insertValue(int data, int index) {

        if (index >= 0 && index <= array.length) {
            int[] temp = new int[array.length + 1];

            if (index == 0) {

                for (int i = 0; i < array.length; i++) {
                    temp[i + 1] = array[i];
                }

            } else if (index == array.length) {

                for (int i = 0; i < array.length; i++) {
                    temp[i] = array[i];
                }

            } else {

                for (int i = 0; i < array.length; i++) {

                    if (i < index) {
                       temp[i] = array[i];
                    } else if (i > index) {
                        temp[i + 1] = array[i];
                    }

                }

            }

            temp[index] = data;
            array = temp;
        } else {
            System.out.println("ERROR: Invalid Index");
        }

    }

}