// Brittni Watkins
// Unit 4: Linked Lists
// Lab 1 - JSON

import processing.core.*;
import processing.data.*;

public class JSON_Processing extends PApplet {

    public void setup() {
        JSONObject bob = loadJSONObject("json_object.json");
        printPerson(bob);

        JSONArray family = loadJSONArray("json_array.json");

        for (int i = 0; i < family.size(); i++) {
            JSONObject person = family.getJSONObject(i);
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
        String name = p.getString("name");
        String possessive = name + "'s";
        int age = p.getInt("age");
        float height = p.getFloat("height");

        println("This object's name is " + name);
        println(possessive + " age is " + age);
        println(possessive + " height is " + height + " feet");
        printChildren(p, possessive);
    }

    private void printChildren(JSONObject p, String possessive) {
        JSONArray children = p.getJSONArray("children");

        if (children != null) {
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