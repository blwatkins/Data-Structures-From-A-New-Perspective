// Brittni Watkins
// Unit 4: Linked Lists
// Day 5 - Implementing a Linked List, Day 2
// Custom Linked List Implementation
// A LinkedList of Circle Objects
// Press 'c' to add a new random circle
// Press 'p' to print the list to the console

import processing.core.*;

public class CustomLinkedList extends PApplet {
    private LinkedList myList;
    private String addString = "0123456789";

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
        //size(displayWidth, displayHeight - 45);
        size(500, 500);
    }

    public void keyPressed() {

        if (key == 'c') {
            addCircle();
        } else if (key == 'p') {
            System.out.println(myList);
        } else if (key == 'b') {
            addCircle(0);
        } else if (key == 'e')  {
            addCircle(myList.size());
        }

        for (int i = 0; i < addString.length(); i++) {

            if (key == addString.charAt(i)) {
                addCircle(i);
            }

        }

    }

    private void createCircles() {

        for (int i = 0; i < 10; i++) {
            addCircle();
        }

    }

    private void addCircle(int index) {
        float x = random(20, width - 20);
        float y = random(20, height - 75);
        int color = color(random(255), random(255), random(255));
        Circle c = new Circle(this, new PVector(x, y), color);
        myList.add(c, index);
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
