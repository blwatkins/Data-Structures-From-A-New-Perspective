// Brittni Watkins
// 21 August 2017
// Linked List Example

import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class LinkedListExample extends PApplet {

    public void setup() {

    }

    public void draw() {

    }

    public void settings() {
        size(500, 500);
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
