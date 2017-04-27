// Brittni Watkins
// Unit 3 - Sorting
// Project Solution - Sorting Objects
// Simple Pixel Comparator Class

import java.util.Comparator;

public class SimplePixelComparator {

    public static Comparator<SimplePixel> Red = new Comparator<SimplePixel>() {

        public int compare(SimplePixel p1, SimplePixel p2) {

            if (p1.getR() != p2.getR()) {
                return Integer.compare(p2.getR(), p1.getR());
            } else {

                if (p1.getG() != p2.getG()) {
                    return Integer.compare(p2.getG(), p1.getG());
                } else {
                    return Integer.compare(p2.getB(), p1.getB());
                }

            }

        }

    };

    public static Comparator<SimplePixel> Green = new Comparator<SimplePixel>() {

        public int compare(SimplePixel p1, SimplePixel p2) {

            if (p1.getG() != p2.getG()) {
                return Integer.compare(p2.getG(), p1.getG());
            } else {

                if (p1.getB() != p2.getB()) {
                    return Integer.compare(p2.getB(), p1.getB());
                } else {
                    return Integer.compare(p2.getR(), p1.getR());
                }

            }

        }

    };

    public static Comparator<SimplePixel> Blue = new Comparator<SimplePixel>() {

        public int compare(SimplePixel p1, SimplePixel p2) {

            if (p1.getB() != p2.getB()) {
                return Integer.compare(p2.getB(), p1.getB());
            } else {

                if (p1.getR() != p2.getR()) {
                    return Integer.compare(p2.getR(), p1.getR());
                } else {
                    return Integer.compare(p2.getG(), p1.getG());
                }

            }

        }

    };

}
