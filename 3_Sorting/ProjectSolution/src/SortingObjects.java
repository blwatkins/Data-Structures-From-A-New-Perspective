// Brittni Watkins
// Unit 3: Sorting
// Project - Sorting Objects
// Main Program

import processing.core.*;

import java.util.ArrayList;

public class SortingObjects extends PApplet {
    private ArrayList<SimplePixel> originalPixels;
    private  ArrayList<SimplePixel> sortedPixels;
    private SortMode sortMode = SortMode.NONE;

    private String[] filenames = {"blue_flowers.jpg", "bluebonnet.jpg", "clouds.jpg", "pink_flowers.jpg",
            "red_flowers.jpg", "tree.jpg", "tulips.jpg"};
    private PImage[] images;
    private int currentImageIndex;

    public void setup() {
        images = new PImage[filenames.length];
        originalPixels = new ArrayList<>();
        sortedPixels = new ArrayList<>();

        for (int i = 0; i < images.length; i++) {
            images[i] = loadImage(filenames[i]);
        }

        currentImageIndex = 0;
        loadPixels(currentImageIndex);
    }

    public void draw() {

        if (sortMode == SortMode.NONE) {
            drawPixels(originalPixels);
        } else {
            drawPixels(sortedPixels);
        }

    }

    public void keyPressed() {

        if (key == 'r') {
            sortedPixels.sort(SimplePixelComparator.Red);
            sortMode = SortMode.RED;
        } else if (key == 'g') {
            sortedPixels.sort(SimplePixelComparator.Green);
            sortMode = SortMode.GREEN;
        } else if (key == 'b') {
            sortedPixels.sort(SimplePixelComparator.Blue);
            sortMode = SortMode.BLUE;
        } else if (key == ' ') {
            sortMode = SortMode.NONE;
        }

        if (keyCode == LEFT) {

            if (currentImageIndex == 0) {
                currentImageIndex = images.length - 1;
            } else {
                currentImageIndex--;
            }

            loadPixels(currentImageIndex);
            sortMode = SortMode.NONE;
        } else if (keyCode == RIGHT) {

            if (currentImageIndex == images.length - 1) {
                currentImageIndex = 0;
            } else {
                currentImageIndex++;
            }

            loadPixels(currentImageIndex);
            sortMode = SortMode.NONE;
        }

    }

    private void loadPixels(int imageIndex) {
        originalPixels.clear();
        sortedPixels.clear();
        PImage image = images[imageIndex];
        image.loadPixels();

        for (int i = 0; i < image.pixels.length; i++) {
            int c = image.pixels[i];
            int r = (int)red(c);
            int g = (int)green(c);
            int b = (int)blue(c);

            originalPixels.add(new SimplePixel(r, g, b));
        }

        for (SimplePixel p: originalPixels) {
            sortedPixels.add(p);
        }

    }


    private void drawPixels(ArrayList<SimplePixel> simplePixels) {
        loadPixels();

        for (int i = 0; i < width * height; i++) {

            if (i < simplePixels.size()) {
                SimplePixel p = simplePixels.get(i);
                int c = color(p.getR(), p.getG(), p.getB());

                pixels[i] = c;
            } else {
                pixels[i] = color(0);
            }

        }

        updatePixels();
    }

    public void settings() {
        size(800, 800);
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "SortingObjects" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }

}

