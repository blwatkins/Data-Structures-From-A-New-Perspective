// Brittni Watkins
// Unit 4: Linked Lists
// Day 4 - Implementing a Linked List
// Custom Linked List Implementation
// A LinkedList of Circle Objects
// Press 'c' to add a new random circle
// Press 'p' to print the list to the console

import processing.core.*;

public class CustomLinkedList extends PApplet {
    private LinkedList myList;

    public void setup() {
        myList = new LinkedList();
        createCircles();
    }

    public void draw() {
        background(250);

        for (int i = 0; i < myList.size(); i++) {
            myList.get(i).display();
            myList.get(i).displayInfo(width / 2, height - 25, i);
        }

    }

    public void settings() {
        size(500, 500);
    }

    public void keyPressed() {

        if (key == 'c') {
            addCircle();
        } else if (key == 'p') {
            System.out.println(myList);
        }

    }

    private void createCircles() {

        for (int i = 0; i < 10; i++) {
            addCircle();
        }

    }

    private void addCircle() {
        float x = random(20, width - 20);
        float y = random(20, height - 75);
        int color = color(random(255), random(255), random(255));
        Circle c = new Circle(this, new PVector(x, y), color);
        myList.add(c);
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "CustomLinkedList" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }

}
