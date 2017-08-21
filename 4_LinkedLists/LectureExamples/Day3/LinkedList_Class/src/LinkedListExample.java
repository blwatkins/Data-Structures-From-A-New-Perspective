// Brittni Watkins
// 21 August 2017
// Linked List Example

import processing.core.*;
import java.util.LinkedList; // import LinkedList class from Java

public class LinkedListExample extends PApplet {
    private LinkedList<Circle> myList; // declare linked list

    public void setup() {
        myList = new LinkedList<>(); // instantiate linked list
        createCircles();
    }

    public void draw() {
        background(250);

        for (int i = 0; i < myList.size(); i++) {
            myList.get(i).display(); // accessing list elements
        }

        for (Circle c: myList) { // iterating through all list elements
            float distance = dist(mouseX, mouseY, c.getPos().x, c.getPos().y);

            if (distance < 25 / 2) {
                fill(0);
                textAlign(CENTER);
                text(c.toString(), width / 2, height - 25);
            }

        }

    }

    public void settings() {
        size(500, 500);
    }

    public void mousePressed() {

        if (myList.size() > 0) {

            for (int i = 0; i < myList.size(); i++) {
                Circle c = myList.get(i);
                float distance = dist(mouseX, mouseY, c.getPos().x, c.getPos().y);

                if (distance < 25 / 2) {
                    myList.remove(i); // removing an element from the list
                }

            }

        }

    }

    private void createCircles() {
        int numCircles = (int)random(5, 50);

        for (int i = 0; i < numCircles; i++) {
            float x = random(20, width - 20);
            float y = random(20, height - 75);
            int color = color(random(255), random(255), random(255));
            Circle c = new Circle(this, new PVector(x, y), color);
            myList.add(c); // adding elements to the list
        }

    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "LinkedListExample" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }

}
