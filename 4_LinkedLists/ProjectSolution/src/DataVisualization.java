// Brittni Watkins
// Unit 4: Linked Lists
// Project - Data Visualization
// Sources
    // periodicTable.json --> https://github.com/Bowserinator/Periodic-Table-JSON/blob/master/PeriodicTableJSON.json

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class DataVisualization extends PApplet {
    private String filename = "periodicTable.json";

    public void setup() {
        JSONObject elementsObject = loadJSONObject(filename);
        JSONArray elements = elementsObject.getJSONArray("elements");

        try {
            Element e = createElement(elements.getJSONObject(0));
            println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void draw() {

    }

    public void settings() {
        //size(displayWidth, displayHeight-45);
        size(600, 600);
    }

    private Element createElement(JSONObject elementObject) throws Exception {
        Element e = new Element(this);
        e.setName(elementObject.getString("name"));
        e.setSymbol(elementObject.getString("symbol"));
        e.setAtomicNumber(elementObject.getInt("number"));
        e.setAtomicMass(elementObject.getFloat("atomic_mass"));
        e.setDensity(elementObject.getFloat("density"));
        return e;
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
