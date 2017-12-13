// Brittni Watkins
// Unit 4: Linked Lists
// Project - Data Visualization
// Sources
    // periodicTable.json --> https://github.com/Bowserinator/Periodic-Table-JSON/blob/master/PeriodicTableJSON.json

import java.util.LinkedList;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class DataVisualization extends PApplet {
    private LinkedList<Element> elements;

    public void setup() {
        colorMode(HSB, 255);
        Data.init(this);
        JSONArray elementsArray = getElementsArray("periodicTable.json");
        createElements(elementsArray);

        mapElements();
        println(elements);
    }

    public void draw() {
        background(0);

        for (Element e: elements) {
            e.display();
        }

    }

    public void settings() {
        //size(displayWidth, displayHeight-45);
        size(600, 600);
    }

    private JSONArray getElementsArray(String filename) {
        JSONObject elementsObject = loadJSONObject(filename);
        return elementsObject.getJSONArray("elements");
    }

    private void createElements(JSONArray elementsArray) {
        elements = new LinkedList<>();

        //for (int i = 0; i < 10; i++) {
        for (int i = 0; i < elementsArray.size(); i++) {

            try {
                elements.add(createElement(elementsArray.getJSONObject(i)));
            } catch (Exception e) {
                println(e);
            }

        }

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

    private void mapElements() {
        float[] atomicMasses = getAtomicMasses();
        float[] densities = getDensities();

        for (Element e: elements) {
            e.mapX(Data.getMinFloat(atomicMasses), Data.getMaxFloat(atomicMasses));
            e.mapY(Data.getMinFloat(densities), Data.getMaxFloat(densities));
            e.mapColor();
        }

    }

    private float[] getAtomicMasses() {
        float[] atomicMasses = new float[elements.size()];

        for (int i = 0; i < elements.size(); i++) {
            atomicMasses[i] = elements.get(i).getAtomicMass();
        }

        return atomicMasses;
    }

    private float[] getDensities() {
        float[] densities = new float[elements.size()];

        for (int i = 0; i < elements.size(); i++) {
            densities[i] = elements.get(i).getDensity();
        }

        return densities;
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
