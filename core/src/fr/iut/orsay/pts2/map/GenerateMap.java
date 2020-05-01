package fr.iut.orsay.pts2.map;

import java.util.List;
import java.util.Random;

import fr.iut.orsay.pts2.CONSTANT;
import fr.iut.orsay.pts2.GetLuck;

public class GenerateMap implements Cloneable {
    private int width = CONSTANT.WIDTH;
    private int height = CONSTANT.HEIGHT;
    private int tolerance = CONSTANT.TOLERANCE;
    private Element[][] mapContent;
    private Element[] possibleElement;
    private List<Element>[] addedElement;
    private int totalAdded = 0;
    private int totalCounted = 0;
    GenerateMap() {
        this.possibleElement = Element.setPossibleElement();
        this.totalAdded = getHeight() * getWidth();
        this.mapContent = new Element[this.width][this.height];
        this.RandomSeed();
        this.printMatrix();
        // this.setRealPosition();
        // this.getPosition();
    }

    public Element[][] getMapContent() {
        return mapContent;
    }

    public int getTotalAdded() {
        return totalAdded;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void printMatrix() {
        for (int h = 0; h < this.getHeight(); h++) {
            for (int w = 0; w < this.getWidth(); w++) {
                if (this.mapContent[w][h] == null) {
                    System.out.print(" " + " ");

                } else {
                    System.out.print(this.mapContent[w][h].getElementType().getType() + " ");

                }
            }
            System.out.println();
        }
    }

    private Element generateRandomElement() {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(possibleElement.length);
        Element randomElement = this.possibleElement[randomNumber];
        return randomElement;
    }

    private int generateRandomNumber() {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(this.width);
        return randomNumber;
    }

    public void RandomSeed() {

        while (!mapIsFull()) {
            int randomW = generateRandomNumber();
            int randomH = generateRandomNumber();
            Element rndElement = generateRandomElement();
            if (mapContent[randomW][randomH] == null) {
                if (GetLuck.getLuck(rndElement.getPercent())) {
                    this.mapContent[randomW][randomH] = rndElement;

                    //  this.mapContent[randomW][randomH].setLocation(randomW, randomH);
                    this.setElementAtThisPosition(randomW, randomH, (mapContent[randomW][randomH].clone()));
                    extendSeed(mapContent[randomW][randomH].clone());

                }
            }

        }
        for (int i = 0; i < tolerance; i++) {
            this.cleanMap();
        }
    }

    private void cleanMap() {
        for (Element[] elements : mapContent) {
            for (Element element : elements) {
                // if(GetLuck.getLuck(element.getPercent()))
                this.matchElementWithEnvironnement(element.clone());

            }

        }
    }

    private void matchElementWithEnvironnement(Element element) {
        boolean added = false;
        while (!added) {
            switch (CONSTANT.RND.nextInt(4)) {
                /*top*/
                case 0:
                    if (element.getLocationW() > 0) {
                        Element newElement = this.mapContent[element.getLocationW() - 1][element.getLocationH()].clone();
                        // newElement.setLocation(aux.getLocationW() - 1, aux.getLocationH());
                        this.setElementAtThisPosition(element.getLocationW(), element.getLocationH(), newElement/*.clone()*/);
                        added = true;
                        this.mapContent[element.getLocationW()][element.getLocationH()] = newElement;
                    }
                    break;
                /*right*/
                case 1:
                    if (element.getLocationH() < getHeight() - 1) {
                        Element newElement = this.mapContent[element.getLocationW()][element.getLocationH() + 1].clone();
                        //newElement.setLocation(aux.getLocationW(), aux.getLocationH() + 1);
                        setElementAtThisPosition(element.getLocationW(), element.getLocationH(), newElement/*.clone()*/);
                        added = true;
                        this.mapContent[element.getLocationW()][element.getLocationH()] = newElement;
                    }
                    break;
                case 2:
                    /*bottom*/
                    if (element.getLocationW() < this.getWidth() - 1) {
                        Element newElement = this.mapContent[element.getLocationW() + 1][element.getLocationH()].clone();
                        //newElement.setLocation(aux.getLocationW() + 1, aux.getLocationH());
                        this.setElementAtThisPosition(element.getLocationW(), element.getLocationH(), newElement/*.clone()*/);
                        added = true;
                        this.mapContent[element.getLocationW()][element.getLocationH()] = newElement;
                    }
                    break;
                case 3:
                    /*left*/
                    if (element.getLocationH() > 0) {
                        Element newElement = this.mapContent[element.getLocationW()][element.getLocationH() - 1].clone();
                        // newElement.setLocation(aux.getLocationW(), aux.getLocationH() - 1);
                        this.setElementAtThisPosition(element.getLocationW(), element.getLocationH(), newElement/*.clone()*/);
                        this.mapContent[element.getLocationW()][element.getLocationH()] = newElement;
                    }
                    break;
            }


        }
    }

    private boolean mapIsFull() {
        int expected_total = this.getWidth() * this.getHeight();
        int total_found = 0;
        for (int h = 0; h < this.getHeight(); h++) {
            for (int w = 0; w < this.getWidth(); w++) {
                if (this.mapContent[w][h] != null) {
                    total_found++;
                }
            }
        }

        return total_found >= expected_total;
    }

    private boolean extendSeed(Element element) {
        boolean added = false;
        if (comparationElementPercent(element)) {

            switch (CONSTANT.RND.nextInt(4)) {
                /*top*/
                case 0:
                    if (mapContent[element.getLocationW()][element.getLocationH()].getLocationW() > 0 && mapContent[element.getLocationW() - 1][element.getLocationH()] == null) {
                        this.setElementAtThisPosition(element.getLocationW() - 1, element.getLocationH(), element.clone());
                        added = true;

                    }
                    break;
                /*bottom*/
                case 1:
                    if (mapContent[element.getLocationW()][element.getLocationH()].getLocationW() < getWidth() - 1 && mapContent[element.getLocationW() + 1][element.getLocationH()] == null) {
                        this.setElementAtThisPosition(element.getLocationW() + 1, element.getLocationH(), element.clone());
                        added = true;

                    }
                    break;
                /*left*/
                case 2:
                    if (mapContent[element.getLocationW()][element.getLocationH()].getLocationH() > 0 && mapContent[element.getLocationW()][element.getLocationH() - 1] == null) {
                        this.setElementAtThisPosition(element.getLocationW(), element.getLocationH() - 1, element.clone());
                        added = true;

                    }
                    break;
                /*right*/
                case 3:
                    if (mapContent[element.getLocationW()][element.getLocationH()].getLocationH() < getHeight() - 1 && mapContent[element.getLocationW()][element.getLocationH() + 1] == null) {
                        this.setElementAtThisPosition(element.getLocationW(), element.getLocationH() + 1, element.clone());
                        added = true;
                    }
                    break;
            }

        }
        return added;

    }


    private void setElementAtThisPosition(int elementWidth, int elementHeight, Element element) {
        this.mapContent[elementWidth][elementHeight] = element;
        element.setLocation(elementWidth, elementHeight);
        totalCounted++;

    }

    private boolean comparationElementPercent(Element element) {
        float allElement = 0;
        for (int i = 0; i < mapContent.length; i++) {
            for (int j = 0; j < mapContent[i].length; j++) {
                if (mapContent[i][j] != null) {
                    if (mapContent[i][j].getElementType().getType() == element.getElementType().getType()) {
                        allElement++;
                    }
                }

            }

        }
        float totalPercent = (float) ((element.getPercent() / 100) * totalAdded) / 100;
        return (allElement / 100) <= totalPercent;
    }

    public void getPosition() {
        for (Element[] elements : mapContent) {
            for (Element element : elements) {
                System.out.println(element.getLocationW() + " : " + element.getLocationH());
            }
        }
    }

    private void setRealPosition() {
        for (int i = 0; i < mapContent.length; i++) {
            for (int j = 0; j < mapContent[i].length; j++) {
                this.setElementAtThisPosition(i, j, mapContent[i][j].clone());

            }
        }
    }


}