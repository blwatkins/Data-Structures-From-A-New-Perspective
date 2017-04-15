// Brittni Watkins
// Sorting Arrays Lecture Example

import processing.core.*;

public class SortingArrays extends PApplet {

    private String[] words = {"fat", "cat", "hat", "mat", "sat", "this", "her", "us", "hey", "you", "see", "there", "me", "three", "picture"};
    private String[] sortedWords;

    private int[] wordLengths;
    private int[] sortedWordLengths;

    private int spacing;

    public void setup() {
        colorMode(HSB, 255);
        spacing = width / words.length;

        wordLengths = new int[words.length];

        for (int i = 0; i < wordLengths.length; i++) {
            wordLengths[i] = words[i].length();
        }

        sortedWords = sort(words);
        sortedWordLengths = sort(wordLengths);
    }

    public void draw() {
        background(200);
        noStroke();

        displayStrings(words, height / 4 - 50);
        displayStrings(sortedWords, height / 4 + 50);

        displayInts(wordLengths, height / 4 + 200);
        displayInts(sortedWordLengths, height / 4 + 300);
    }

    private void displayStrings(String[] words, int y) {

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            w = w.toLowerCase();
            float size = w.length() * 10;
            int hue = (int)map((int)w.charAt(0), (int)'a', (int)'z', 0, 255);
            fill(hue, 200, 200);
            ellipse(i * spacing + spacing / 2, y, size, size);
            fill(0);
            textAlign(CENTER);
            text(w, i * spacing + spacing / 2, y + 50);
        }

    }

    private void displayInts(int[] nums, int y) {

        for (int i = 0; i < nums.length; i++) {
            float size = nums[i] * 10;
            fill(0);
            ellipse(i * spacing + spacing / 2, y, size, size);
            textAlign(CENTER);
            text(str(nums[i]), i * spacing + spacing / 2, y + 50);
        }

    }

    public void settings() {  size(displayWidth, displayHeight); }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "SortingArrays" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }

}
