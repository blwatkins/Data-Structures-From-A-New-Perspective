// Brittni Watkins
// Unit 4: Linked Lists
// Project - Data Visualization
// Data Class
// Functions for processing data
// i.e. getting min and max values from an array; getting average or median values

import processing.core.PApplet;

public class Data {

    private static PApplet p;

    public static void init(PApplet context) {
        p = context;
    }

    public static int getMaxInt(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            max = p.max(max, array[i]);
        }

        return max;
    }

    public static int getMinInt(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            min = p.min(min, array[i]);
        }

        return min;
    }

    public static float getMaxFloat(float[] array) {
        float max = array[0];

        for (int i = 1; i < array.length; i++) {
            max = p.max(max, array[i]);
        }

        return max;
    }

    public static float getMinFloat(float[] array) {
        float min = array[0];

        for (int i = 1; i < array.length; i++) {
            min = p.min(min, array[i]);
        }

        return min;
    }

}
