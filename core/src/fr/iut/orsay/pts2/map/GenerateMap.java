package fr.iut.orsay.pts2.map;

import java.util.*;

public class GenerateMap {
    private int width = 10;
    private int height = 10;
    private int tolerance = 4;
    private Element[][] mapContent;
    private Element[] possibleElement;
    private List<Element>[] addedElement;
    private int totalAdded = 0;
    private int totalCounted = 0;

    GenerateMap() {
        this.setUpPossibleElement();
        this.totalAdded = getHeight() * getWidth();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setUpPossibleElement() {
        this.possibleElement = Element.setPossibleElement();
        this.addedElement = (ArrayList<Element>[]) new ArrayList[possibleElement.length];
    }

    public void generateMatrix() {
        this.mapContent = new Element[this.width][this.height];
    }

    public void printMatrix() {
        for (int h = 0; h < this.getHeight(); h++) {
            for (int w = 0; w < this.getWidth(); w++) {
                if (this.mapContent[w][h] == null) {
                    System.out.print(" " + " ");

                } else {
                    System.out.print(this.mapContent[w][h].getType() + " ");

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

    public void setElementAtRandomPosition() {
        int i = 0;
        while (!mapIsFull()) {
            int randomW = generateRandomNumber();
            int randomH = generateRandomNumber();
            if (mapContent[randomW][randomH] == null) {
                this.mapContent[randomW][randomH] = generateRandomElement();
                this.mapContent[randomW][randomH].setLocation(randomW, randomH);
                try {
                    extendSeed((Element) mapContent[randomW][randomH].clone());
                } catch (CloneNotSupportedException e) {
                }

            }
            i++;
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

    private void generateNewRandomSeed(Element element) {
        boolean added = false;
        while (added == false) {
            Random rand = new Random();
            int random_number_w = rand.nextInt(this.width);
            int random_number_h = rand.nextInt(this.height);
            //We are clonning the element, but somehow the clone method is returning an object method only.
            if (this.mapContent[random_number_w][random_number_h] == null) {
                this.setElementAtThisPosition(random_number_w, random_number_h, element);
                added = true;
            }
        }
    }

    private boolean extendSeed(Element element) {
        List<Integer> solution = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) {
            solution.add(i);
        }
        Collections.shuffle(solution);
        boolean added = false;
        // Element aux = new Element();

        for (int i = 0; i < 4; i++) {
            int location = solution.get(i);
            switch (location) {
                /*top*/
                case 0:
                    if (mapContent[element.getLocationW()][element.getLocationH()].getLocationW() > 0 && mapContent[element.getLocationW() - 1][element.getLocationH()] == null) {
                        this.setElementAtThisPosition(element.getLocationW() - 1, element.getLocationH(), element);
                        added = true;
                        i = 4;
                    }
                    break;
                /*bottom*/
                case 1:
                    if (mapContent[element.getLocationW()][element.getLocationH()].getLocationW() < getWidth() - 1 && mapContent[element.getLocationW() + 1][element.getLocationH()] == null) {
                        this.setElementAtThisPosition(element.getLocationW() + 1, element.getLocationH(), element);
                        added = true;
                        i = 4;
                    }
                    break;
                /*left*/
                case 2:
                    if (mapContent[element.getLocationW()][element.getLocationH()].getLocationH() > 0 && mapContent[element.getLocationW()][element.getLocationH() - 1] == null) {
                        this.setElementAtThisPosition(element.getLocationW(), element.getLocationH() - 1, element);
                        added = true;
                        i = 4;
                    }
                    break;
                /*right*/
                case 3:
                    if (mapContent[element.getLocationW()][element.getLocationH()].getLocationH() < getHeight() - 1 && mapContent[element.getLocationW()][element.getLocationH() + 1] == null) {
                        this.setElementAtThisPosition(element.getLocationW(), element.getLocationH() + 1, element);
                        added = true;
                        i = 4;
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
                    if (mapContent[i][j].getType() == element.getType()) {
                        allElement++;
                    }
                }

            }

        }
        float totalPercent = (float) (float) ((element.getPercent() / 100) * totalAdded) / 100;
        return (allElement / 100) <= totalPercent;
    }

    public void getPosition() {
        for (int i = 0; i < this.mapContent.length; i++) {
            for (int j = 0; j < mapContent[i].length; j++) {
                if (mapContent[i][j] != null) {
                    System.out.println(mapContent[i][j].getLocationW() + " " + mapContent[i][j].getLocationH());
                }
            }

        }
    }
}