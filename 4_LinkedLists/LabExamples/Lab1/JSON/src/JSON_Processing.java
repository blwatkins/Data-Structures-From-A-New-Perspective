// Brittni Watkins
// Unit 4: Linked Lists
// Lab 1 - JSON
// Load, manipulate, and print the data stored in JSON files

import processing.core.*;
import processing.data.*;

public class JSON_Processing extends PApplet {

    public void setup() {
        rectMode(CENTER);

        // Create JSON object from JSON data in the file
        JSONObject shape = loadJSONObject("json_object.json");
        drawShape(shape);

        // Create JSON array from JSON data in the file
        JSONArray shapes = loadJSONArray("json_array.json");
        drawShapes(shapes);
    }

    public void draw() {
    }

    public void settings() {
        size(displayWidth, displayHeight);
    }

    private void drawShapes(JSONArray shapes) {

        // iterate over each JSON object in the array and call the drawShape method
        for (int i = 0; i < shapes.size(); i++) {
            drawShape(shapes.getJSONObject(i));
        }

    }

    private void drawShape(JSONObject shape) {
        String type = shape.getString("shape"); // access the object's shape attribute
        String color = shape.getString("color"); // access the color attribute
        int size = shape.getInt("size"); // access the size attribute
        float x = random(size, width-size);
        float y = random(size, height - size);

        fill(getColor(color), 100);

        switch (type) {
            case "square":
                rect(x, y, size, size);
                break;

            case "circle":
                ellipse(x, y, size, size);
                break;

            case "triangle":
                triangle(x, y, size);
                break;

            default:
                rect(x, y, size * 2, size);
                break;
        }


    }

    private int getColor(String color) {
        int col;

        switch (color) {
            case "red":
                col = color(255, 0, 0);
                break;

            case "blue":
                col = color(0, 0, 255);
                break;

            case "green":
                col = color(0, 255, 0);
                break;

            default:
                col = color(0);
                break;
        }

        return col;
    }

    private void triangle(float x, float y, float size) {
        float side = size / 2;
        triangle(x, y - side, x + side, y + side, x - side, y + side);
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "JSON_Processing" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }

}