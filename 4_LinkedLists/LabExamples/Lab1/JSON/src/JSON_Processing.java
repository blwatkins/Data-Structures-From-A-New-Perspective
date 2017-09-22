// Brittni Watkins
// Unit 4: Linked Lists
// Lab 1 - JSON
// Load, manipulate, and print the data stored in JSON files

import processing.core.*;
import processing.data.*;

public class JSON_Processing extends PApplet {

    public void setup() {
        // Create JSON object from JSON data in the file
        JSONObject bob = loadJSONObject("json_object.json");
        println("JSON Object: ");
        printPerson(bob);

        // Create a JSON array from the JSON data in the file
        JSONArray family = loadJSONArray("json_array.json");

        println("JSON Array:");

        // iterate over JSON objects in the JSON array
        for (int i = 0; i < family.size(); i++) {
            JSONObject person = family.getJSONObject(i); // get object at i-th position in the array
            printPerson(person);
        }

    }

    public void draw() {
    }

    public void settings() {
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[] { "JSON_Processing" };

        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }

    }

    private void printPerson(JSONObject p) {
        // get name attribute from JSON object --> name is of type string
        String name = p.getString("name");
        String possessive = name + "'s";

        // get age attribute from JSON object --> age is of type int
        int age = p.getInt("age");

        // get height attribute from JSON object --> height is of type float
        float height = p.getFloat("height");

        println("This object's name is " + name);
        println(possessive + " age is " + age);
        println(possessive + " height is " + height + " feet");
        printChildren(p, possessive);
    }

    private void printChildren(JSONObject p, String possessive) {
        // get the JSON array stored in the JSON object
        // JSON array of children stored in the children attribute of the object
        JSONArray children = p.getJSONArray("children");

        if (children != null) {
            // build a string listing the names of the children "a, b, and c."
            String childrenString = possessive + " children are named ";

            for (int i = 0; i < children.size(); i++) {
                JSONObject child = children.getJSONObject(i);
                String childName = child.getString("name");

                if (i == children.size() - 1) {
                    childrenString += "and " + childName + ".";
                } else {
                    childrenString += childName + ", ";
                }

            }

            println(childrenString);
        }

        println("");
    }

}