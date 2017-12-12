// Brittni Watkins
// Unit 4: Linked Lists
// Project - Data Visualization

import processing.core.PApplet;

public class DataVisualization extends PApplet{

    public void setup() {

    }

    public void draw() {

    }

    public void settings() {
        //size(displayWidth, displayHeight-45);
        size(600, 600);
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "DataVisualization" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }

}
