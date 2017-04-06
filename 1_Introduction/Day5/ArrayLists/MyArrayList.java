// Brittni Watkins
// 15 March 2017
// ArrayList class

import java.util.ArrayList;

public class MyArrayList {
    private ArrayList<Integer> arrayList;

    MyArrayList() {
        arrayList = new ArrayList<Integer>();
    }

    public void fill(int size) {

        for (int i = 0; i < size; i++) {
            arrayList.add(new Integer((i * 2) + 1));
        }

    }

    public int getSize() {
        return arrayList.size();
    }

    public int getValue(int index) {

        if (index >= 0 && index < arrayList.size()) {
            return arrayList.get(index).intValue();
        } else {
            System.out.println("ERROR: Invalid Index");
            return -1;
        }

    }

    public void insertValue(int data, int index) {

        if (index >= 0 && index <= arrayList.size()) {
            arrayList.add(index, new Integer(data));
        } else {
            System.out.println("ERROR: Invalid Index");
        }

    }

    public void removeValue(int index) {

        if (index >= 0 && index < arrayList.size()) {
            arrayList.remove(index);
        } else {
            System.out.println("ERROR: Invalid Index");
        }

    }

    public String toString() {
        String out = "";
        out += "ArrayList: " + "\n";
        int count = 0;

        for (Integer val: arrayList) {
            out += "    " + count + ": " + val + "\n";
            count++;
        }

        return out;
    }

}