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
    private boolean move;

    public void setup() {
        colorMode(HSB, 255);
        Data.init(this); // initialize PApplet object for static Data class
        JSONArray elementsArray = getElementsArray("periodicTable.json");
        createElements(elementsArray);
        mapElements();
        move = false;
    }

    public void draw() {
        Element selected = null;
        noStroke();
        fill(0, 10);
        rect(-10, -10, width + 10, height + 10);

        for (Element e: elements) {
            e.display();

            if (e.mouseOver()) {
                selected = e;
            }

            if (move) {
                e.randomWalk();
            }

        }

        for (Element e: elements) {

            if (e == selected) {
                e.setHighlight(true);
                displayInfo(e);
            } else {
                e.setHighlight(false);
            }

        }

    }

    public void settings() {
        size(displayWidth, displayHeight-45);
    }

    public void mousePressed() {
        move = !move;
    }

    public void keyPressed() {
        for (Element e: elements) {
            e.reset();
        }
    }

    private JSONArray getElementsArray(String filename) {
        JSONObject elementsObject = loadJSONObject(filename);
        return elementsObject.getJSONArray("elements");
    }

    private void createElements(JSONArray elementsArray) {
        elements = new LinkedList<>();

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
        int[] atomicNums = getAtomicNums();
        float[] atomicMasses = getAtomicMasses();
        float[] densities = getDensities();

        for (Element e: elements) {
            e.mapX(Data.getMinInt(atomicNums), Data.getMaxInt(atomicNums));
            e.mapY(Data.getMinFloat(densities), Data.getMaxFloat(densities));
            e.mapR(Data.getMinFloat(atomicMasses), Data.getMaxFloat(atomicMasses));
            e.mapColor();
        }

    }

    private int[] getAtomicNums() {
        int[] atomicNums = new int[elements.size()];

        for (int i = 0; i < elements.size(); i++) {
            atomicNums[i] = elements.get(i).getAtomicNumber();
        }

        return atomicNums;
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

    private void displayInfo(Element e) {
        textAlign(LEFT, TOP);
        textSize(20);
        fill(255);
        text(e.toString(), 15, 0);
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
